package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.Constants;
import PROJECT_HTTP_SERVER.HttpRequest;
import PROJECT_HTTP_SERVER.config.HttpRequestParser;
import PROJECT_HTTP_SERVER.exeptions.BadRequestException;
import PROJECT_HTTP_SERVER.exeptions.HttpServerException;
import PROJECT_HTTP_SERVER.exeptions.HttpVersionNotSupportedException;
import PROJECT_HTTP_SERVER.exeptions.MethodNotAllowedException;
import PROJECT_HTTP_SERVER.utils.DataUtils;
import PROJECT_HTTP_SERVER.utils.HttpUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;



/*
--- Example Request ---
GET / HTTP/1.1
Host: localhost:9090
User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9;q=0.8
Accept-Language: en-US,en;q=0.5
Accept-Encoding: gzip, deflate
Connection: keep-alive
Upgrade-Insecure-Requests: 1
Cache-Control: max-age=0



parseHttpRequest()
convertParsedRequestToHttpRequest() -> validateHttpVersion()
parseHeaders() -> putHeader()
class ParsedRequest -> parseInputStream()
class ProcessedUri  -> extractParametersIfPresent() -> extractParametersFromUri -> getParameters()
*/

class DefaultHttpRequestParser implements HttpRequestParser {


    @Override
    public HttpRequest parseHttpRequest(InputStream inputStream, String remoteAddress) throws IOException, HttpServerException {
        String startingLine = null;
        try {
            ParsedRequest request = parseInputStream(inputStream); //  parse input stream
            return convertParsedRequestToHttpRequest(request, remoteAddress);
        } catch (RuntimeException e) {
            if (e instanceof HttpServerException) {
                throw e;
            } else {
                throw new BadRequestException("Can't parse http request: " + e.getMessage(), e, startingLine);
            }
        }
    }

    private HttpRequest convertParsedRequestToHttpRequest(ParsedRequest request, String remoteAddress) throws IOException {

        // Parse starting line: GET /index.html HTTP/1.1
        String[] startingLineData = request.startingLine.split(" ");
        String method = startingLineData[0];
        String uri = startingLineData[1];
        String httpVersion = startingLineData[2];
        validateHttpVersion(request.startingLine, httpVersion);

        // Parse headers: Host: localhost
        Map<String, String> headers = parseHeaders(request.headersLine);

        // Parse message body or uri params
        ProcessedUri processedUri = extractParametersIfPresent(method, uri, httpVersion, request.messageBody);
        return new DefaultHttpRequest(
                method,
                processedUri.uri,
                httpVersion,
                remoteAddress,
                headers,
                processedUri.parameters
        );
    }

    // вытаскиваем параметры
    // могут быть в body(post) или в стартовой строке (get, head)
    private ProcessedUri extractParametersIfPresent(String method, String uri, String httpVersion, String messageBody) throws UnsupportedEncodingException {
        Map<String, String> parameters = Collections.emptyMap();
        if (Constants.GET.equalsIgnoreCase(method) || Constants.HEAD.equalsIgnoreCase(method)) {
            int indexOfDelim = uri.indexOf('?');
            if (indexOfDelim != -1) {
                return extractParametersFromUri(uri, indexOfDelim);
            }
        } else if (Constants.POST.equalsIgnoreCase(method)) {
            if (messageBody != null && !"".equals(messageBody)) {
                parameters = getParameters(messageBody);
            }
        } else {
            throw new MethodNotAllowedException(method, String.format("%s %s %s", method, uri, httpVersion));
        }
        return new ProcessedUri(uri, parameters);
    }

    protected ProcessedUri extractParametersFromUri(String uri, int indexOfDelim) throws UnsupportedEncodingException {
        String paramString = uri.substring(indexOfDelim + 1);
        Map<String, String> parameters = getParameters(paramString);
        uri = uri.substring(0, indexOfDelim);
        return new ProcessedUri(uri, parameters);
    }

    protected Map<String, String> getParameters(String paramString) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        String[] params = paramString.split("&");
        for (String param : params) {
            String[] items = param.split("=");
            // If empty value for param
            if (items.length == 1) {
                items = new String[]{items[0], ""};
            }
            String name = items[0];
            String value = map.get(name);
            if (value != null) {
                value += "," + URLDecoder.decode(items[1], "UTF-8");
            } else {
                value = URLDecoder.decode(items[1], "UTF-8");
            }
            map.put(name, value);
        }
        return map;
    }

    private void validateHttpVersion(String startingLine, String httpVersion) {
        if (!Constants.HTTP_VERSION.equals(httpVersion)) {
            throw new HttpVersionNotSupportedException("Current server supports only " + Constants.HTTP_VERSION + " protocol", startingLine);
        }
    }

    protected Map<String, String> parseHeaders(List<String> list) throws IOException {
        Map<String, String> map = new LinkedHashMap<>();
        String prevName = null;
        for (String headerItem : list) {
            prevName = putHeader(prevName, map, headerItem);
        }
        return map;
    }

    // adding parseHeaders
    protected String putHeader(String prevName, Map<String, String> map, String header) {
        if (header.charAt(0) == ' ') {             // проверяем на значение в новой строке
            String value = map.get(prevName) + header.trim();
            map.put(prevName, value);
            return prevName;
        } else {
            int index = header.indexOf(':');
            String name = HttpUtils.normilizeHeaderName(header.substring(0, index));
            String value = header.substring(index + 1).trim();
            map.put(name, value);
            return name;
        }
    }

    protected ParsedRequest parseInputStream(InputStream inputStream) throws IOException {
        String startingLineAndHeaders = HttpUtils.readStartingLineAndHeaders(inputStream); // прочитали строку и заголовки
        int contentLengthIndex = HttpUtils.getContentLengthIndex(startingLineAndHeaders); // ищем поле content lenght
        if (contentLengthIndex != -1) {
            int contentLength = HttpUtils.getContentLengthValue(startingLineAndHeaders, contentLengthIndex); // если находим - получаем кол-во байтов
            String messageBody = HttpUtils.readMessageBody(inputStream, contentLength); // и пытаемся прочесть сообщение
            return new ParsedRequest(startingLineAndHeaders, messageBody);
        } else {
            return new ParsedRequest(startingLineAndHeaders, null);
        }
    }

    private static class ParsedRequest {  // parse request
        private final String startingLine;
        private final List<String> headersLine;
        private final String messageBody;

        public ParsedRequest(String startingLineAndHeaders, String messageBody) {
            super();
            List<String> list = DataUtils.convertToLineList(startingLineAndHeaders);
            this.startingLine = list.remove(0);       // удаляем из коллекции стартовую строку
            this.headersLine = list.isEmpty() ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.messageBody = messageBody;
        }
    }

    private static class ProcessedUri {
        final String uri;
        final Map<String, String> parameters;

        ProcessedUri(String uri, Map<String, String> parameters) {
            super();
            this.uri = uri;
            this.parameters = parameters;
        }
    }
}
