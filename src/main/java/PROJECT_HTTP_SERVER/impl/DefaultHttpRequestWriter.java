package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.HttpRequest;
import PROJECT_HTTP_SERVER.config.HttpRequestParser;
import PROJECT_HTTP_SERVER.config.HttpResponseWriter;
import PROJECT_HTTP_SERVER.config.ReadableHttpResponse;
import PROJECT_HTTP_SERVER.exeptions.HttpServerException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

 class DefaultHttpRequestWriter implements HttpResponseWriter {
    @Override
    public void writerHttpResponse(OutputStream outputStream, ReadableHttpResponse response) throws IOException {

    }
}
