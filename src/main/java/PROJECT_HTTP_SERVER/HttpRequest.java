package PROJECT_HTTP_SERVER;

import java.util.Map;
/**
 * Этот компонент будет предоставлять информацию запроса
 */
public interface HttpRequest {
    String getStartingLine(); // для логирования какой запрос обрабатывается

    String getMethod();  //  get , post, head

    String getUri();  // возвращает уникальный идентификатор ресурса

    String getHttpVersion();  // версия протокола

    String getRemoteAddess();  // удаленный адрес подключения

    Map<String, String> getHeaders(); // карта заголовков

    Map<String, String> getParameters(); //карта параметров (разделяется :)
}
