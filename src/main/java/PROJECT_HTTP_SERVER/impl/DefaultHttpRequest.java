package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.HttpRequest;

import java.util.Collections;
import java.util.Map;

class DefaultHttpRequest implements HttpRequest {
  private final  String method;
  private final  String uri;
  private final  String httpVersion;
  private final  String remoteAddess;
  private final  Map<String, String> headers;
  private final  Map<String, String> parameters;

    public DefaultHttpRequest(String method, String uri, String httpVersion, String remoteAddess, Map<String, String> headers, Map<String, String> parameters) {
        this.method = method;
        this.uri = uri;
        this.httpVersion = httpVersion;
        this.remoteAddess = remoteAddess;
        this.headers = Collections.unmodifiableMap(headers); // не возможности модификации
        this.parameters = Collections.unmodifiableMap(parameters); // не возможности модификации
    }

    @Override
    public String getStartingLine() {
        return String.format("%s %s %s", getMethod(), getUri(), getHttpVersion());
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public String getUri() {
        return uri;
    }

    @Override
    public String getHttpVersion() {
        return httpVersion;
    }

    @Override
    public String getRemoteAddess() {
        return remoteAddess;
    }

    @Override
    public Map<String, String> getHeaders() {
        return headers;
    }

    @Override
    public Map<String, String> getParameters() {
        return parameters;
    }
}
