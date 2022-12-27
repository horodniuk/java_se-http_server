package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.Constants;
import PROJECT_HTTP_SERVER.config.HttpResponseWriter;
import PROJECT_HTTP_SERVER.config.HttpServerConfig;
import PROJECT_HTTP_SERVER.config.ReadableHttpResponse;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class DefaultHttpResponseWriter extends AbstractHttpConfigurableComponent implements HttpResponseWriter {
    DefaultHttpResponseWriter(HttpServerConfig httpServerConfig) {
        super(httpServerConfig);
    }

    @Override
    public void writerHttpResponse(OutputStream outputStream, ReadableHttpResponse response) throws IOException {
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8)));
        addStartingLine(writer, response);
        addHeaders(writer, response);
        writer.println();
        writer.flush();
        addMessageBody(outputStream, response);
    }

    protected void addStartingLine(PrintWriter out, ReadableHttpResponse response) {
        String httpVersion = Constants.HTTP_VERSION;
        int statusCode = response.getStatus();
        String statusMessage = httpServerConfig.getStatusMessage(statusCode);
        //HTTP/1.1 200 Ok
        out.println(String.format("%s %s %s", httpVersion, statusCode, statusMessage));
    }

    protected void addHeaders(PrintWriter out, ReadableHttpResponse response) {
        for(Map.Entry<String, String> entry : response.getHeaders().entrySet()) {
            // Content-Type: text/plain
            out.println(String.format("%s: %s", entry.getKey(), entry.getValue()));
        }
    }

    protected void addMessageBody(OutputStream outputStream, ReadableHttpResponse response) throws IOException {
        if(!response.isBodyEmpty()) {
            outputStream.write(response.getBody());
            outputStream.flush();
        }
    }
}
