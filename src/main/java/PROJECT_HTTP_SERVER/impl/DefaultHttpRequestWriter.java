package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.Constants;
import PROJECT_HTTP_SERVER.HttpRequest;
import PROJECT_HTTP_SERVER.config.HttpRequestParser;
import PROJECT_HTTP_SERVER.config.HttpResponseWriter;
import PROJECT_HTTP_SERVER.config.HttpServerConfig;
import PROJECT_HTTP_SERVER.config.ReadableHttpResponse;
import org.apache.http.protocol.HTTP;

import java.io.*;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static java.lang.System.out;

class DefaultHttpRequestWriter extends AbstractHttpConfigurableComponent implements HttpResponseWriter {

    DefaultHttpRequestWriter(HttpServerConfig httpServerConfig) {
         super(httpServerConfig);
     }

     @Override
    public void writerHttpResponse(OutputStream outputStream, ReadableHttpResponse response) throws IOException {
         PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out, StandardCharsets.UTF_8)));
         addStartingLine(writer, response);
         addHeaders(writer, response);
         writer.println();
         writer.flush();
         addMessageBody(out, response);
    }

    /**
    *  HTTP/1.1 200 OK
    */
    protected void addStartingLine(PrintWriter out, ReadableHttpResponse response) {
        String httpVersion = Constants.HTTP_VERSION;
        int statusCode = response.getStatus();
        String statusMessage = httpServerConfig.getStatusMessage(statusCode);
        //HTTP/1.1 200 Ok
        out.println(String.format("%s %s %s", httpVersion, statusCode, statusMessage));
    }

    /**
     *  Date: Wed, 12 Oct 2016 14:36:12 +0300
     * Server: Devstudy HTTP server
     * Content-Language: en
     * Connection: close
     * Content-Type: text/html
     * Content-Length: 339
     */
    protected void addHeaders(PrintWriter out, ReadableHttpResponse response) {
        for(Map.Entry<String, String> entry : response.getHeaders().entrySet()) {
            // Content-Type: text/plain
            out.println(String.format( entry.getKey(), entry.getValue()," %s: %s"));
        }
    }


/**
 * html code
 */
    protected void addMessageBody(OutputStream out, ReadableHttpResponse response) throws IOException {
        if(!response.isBodyEmpty()) {
            out.write(response.getBody());
            out.flush();
        }
    }

}
