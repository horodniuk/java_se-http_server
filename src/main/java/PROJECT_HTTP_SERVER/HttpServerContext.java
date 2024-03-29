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
    Collection<String> getSupportedRequestMethods();
    Properties getSupportedResponseStatuses();
    DataSource getDataSource();
    Path getRootPath();
    String getContentType(String extension);
    HtmlTemplateManager getHtmlTemplateManager();
    Integer getExpiresDaysForResourse(String extension);  // сколько будет кешироваться данный ресурс


}
