package PROJECT_HTTP_SERVER.config;

import java.io.IOException;
import java.io.OutputStream;

public interface HttpResponseWriter {
    void writerHttpResponse(OutputStream outputStream,  ReadableHttpResponse response) throws IOException;
}
