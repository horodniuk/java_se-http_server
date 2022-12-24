package lecture16_http_interface.config;

import lecture16_http_interface.HttpResponse;

import java.util.Map;

/**
 * описывает методы для чтения данных ответа
 */
public interface ReadableHttpResponse extends HttpResponse {
    int getSatus();

    Map<String, String> getHeaders();
    byte[] getBody();
    boolean isBodyEmpty();
    int getBodyLenght();
}
