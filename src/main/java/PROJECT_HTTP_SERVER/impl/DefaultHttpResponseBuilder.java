package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.config.HttpResponseBuilder;
import PROJECT_HTTP_SERVER.config.ReadableHttpResponse;

 class DefaultHttpResponseBuilder implements HttpResponseBuilder {
    @Override
    public ReadableHttpResponse buildNewHttpResponse() {
        return null;
    }

    @Override
    public void prepareHttpResponse(ReadableHttpResponse response, boolean clearBody) {

    }
}
