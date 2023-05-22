package PROJECT_HTTP_SERVER;

import java.util.Map;
/**
 * Этот компонент будет отвечать за обработку шаблонов
 */
public interface HtmlTemplateManager {
    String processTemplate(String templateName, Map<String, Object> args);  // html код который будет нам отдавать сервер


}
