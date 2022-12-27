package PROJECT_HTTP_SERVER;

import javax.sql.DataSource;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Properties;
/**
 * Информация о настройках сервера к которой должны иметь доступы обработчики
 */
public interface HttpServerContext  {
    ServerInfo getServerInfo();
    Collection<String> getSupportedRequestMethod();
    Properties getSupportedResponseStatuses();
    DataSource getDataSource();
    Path getRootPaht();
    String getContentType(String extension);
    HtmlTemplateManager getHtmlTemplateManager();
    Integer getExpiresDaysForResourse(String extension);  // сколько будет кешироваться данный ресурс
}
