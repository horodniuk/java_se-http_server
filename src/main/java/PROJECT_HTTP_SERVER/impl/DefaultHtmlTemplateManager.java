package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.HtmlTemplateManager;
import PROJECT_HTTP_SERVER.exeptions.HttpServerException;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class DefaultHtmlTemplateManager implements HtmlTemplateManager {
    private final Map<String, String> templates = new HashMap<>();

    @Override
    public String processTemplate(String templateName, Map<String, Object> args) {
        String template = getTemplate(templateName);
        return populateTemplate(template, args);
    }



    private String getTemplate(String templateName) {
        String template = templates.get(templateName);
        if(template == null){
            try(InputStream in = getClasspathResource("html/templates/" + templateName)){
                if(in == null){
                    throw new HttpServerException("Classpath resource \"html/templates/" + templateName + "/not found");
                }
                template = IOUtils.toString(in, StandardCharsets.UTF_8);
                templates.put(templateName, template);
            } catch (IOException e){
                throw new HttpServerException("Cant load template: " + templateName, e);
            }
        }
        return template;
    }

    private String populateTemplate(String template, Map<String, Object> args) {
        return null;
    }

    private InputStream getClasspathResource(String s) {
        return null;
    }

}
