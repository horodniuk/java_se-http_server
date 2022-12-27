package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.config.HttpResponseBuilder;
import PROJECT_HTTP_SERVER.config.HttpServerConfig;
import PROJECT_HTTP_SERVER.config.ReadableHttpResponse;

import java.util.Date;

/*
--- Example Response ---
HTTP/1.1 200 OK
Date: Wed, 12 Oct 2016 14:36:12 +0300
Server: Devstudy HTTP server
Content-Language: en
Connection: close
Content-Type: text/html
Content-Length: 339
*/

class DefaultHttpResponseBuilder extends AbstractHttpConfigurableComponent implements HttpResponseBuilder {
 /**
  *      для извлечения доп. информации нужен server config. Например извлечь имя сервера
  */
     DefaultHttpResponseBuilder(HttpServerConfig httpServerConfig) {
         super(httpServerConfig);
     }

     protected ReadableHttpResponse createReadableHttpResponseInstance(){
         return new DefaultReadableHttpResponse();
     }

     @Override
    public ReadableHttpResponse buildNewHttpResponse() {
         ReadableHttpResponse response = createReadableHttpResponseInstance();
         response.setHeader("Date", new Date());
         response.setHeader("Server", httpServerConfig.getServerInfo().getName());
         response.setHeader("Content-Language", "en");
         response.setHeader("Connection", "close");
         response.setHeader("Content-Type", "text/html");
         return response;
    }

    @Override
    public void prepareHttpResponse(ReadableHttpResponse response, boolean clearBody) {
        if (response.getStatus() >= 400 && response.isBodyEmpty()) {
            // добавить шаблон страницы с кодом ошибки
        }
        setContentLength(response);
        if (clearBody) {
            clearBody(response);
        }
    }

    protected void setContentLength(ReadableHttpResponse response) {
        response.setHeader("Content-Length", response.getBodyLength()); // сначала нужно высчитать размер response
    }

    protected void clearBody(ReadableHttpResponse response) {  // потом удаляем body
        response.setBody("");
    }

}
