package lecture16_http_interface.config;

public interface HttpResponseBuilder {
    ReadableHttpResponse buildNewHttpResponse();
    void prepareHttpResponse(ReadableHttpResponse response, boolean clearBody); // boolean для head запроса

}
