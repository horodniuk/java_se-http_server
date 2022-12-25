package PROJECT_HTTP_SERVER.config;

public interface HttpResponseBuilder {
    ReadableHttpResponse buildNewHttpResponse();
    void prepareHttpResponse(ReadableHttpResponse response, boolean clearBody); // boolean для head запроса

}
