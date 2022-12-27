package PROJECT_HTTP_SERVER.config;

import PROJECT_HTTP_SERVER.HttpResponse;

import java.util.Map;

/**
 * описывает методы для чтения данных ответа
 */
public interface ReadableHttpResponse extends HttpResponse {
    int getStatus();

    Map<String, String> getHeaders();
    byte[] getBody();
    boolean isBodyEmpty();
    int getBodyLength();
}
