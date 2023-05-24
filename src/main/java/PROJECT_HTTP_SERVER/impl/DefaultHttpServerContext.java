package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.Constants;
import PROJECT_HTTP_SERVER.HtmlTemplateManager;
import PROJECT_HTTP_SERVER.HttpServerContext;
import PROJECT_HTTP_SERVER.ServerInfo;
import PROJECT_HTTP_SERVER.exeptions.HttpServerConfigException;

import javax.sql.DataSource;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Properties;

/*
 * для получения служебной информации
 */
public class DefaultHttpServerContext extends AbstractHttpConfigurableComponent implements HttpServerContext {
    DefaultHttpServerContext(DefaultHttpServerConfig httpServerConfig) {
        super(httpServerConfig);
    }

    private DefaultHttpServerConfig getHttpServerConfig() {
        return (DefaultHttpServerConfig) httpServerConfig;
    }

    @Override
    public DataSource getDataSource() {
        if (getHttpServerConfig().getDataSource() != null) {
            return getHttpServerConfig().getDataSource();
        } else {
            throw new HttpServerConfigException("Datasource is not configured for this context");
        }
    }

    @Override
    public ServerInfo getServerInfo() {
        return getHttpServerConfig().getServerInfo();
    }

    @Override
    public Collection<String> getSupportedRequestMethods() {
        return Constants.ALLOWED_METHODS;
    }

    @Override
    public Properties getSupportedResponseStatuses() {
        Properties properties = new Properties();
        properties.putAll(getHttpServerConfig().getStatusesProperties());
        return properties;
    }


    @Override
    public Path getRootPath() {
        return getHttpServerConfig().getRootPath();
    }

    @Override
    public String getContentType(String extension) {
        String result = getHttpServerConfig().getMimeTypesProperties().getProperty(extension);
        return result != null ? result : "text/plain";
    }

    @Override
    public HtmlTemplateManager getHtmlTemplateManager() {
        return getHttpServerConfig().getHtmlTemplateManager();
    }

    @Override
    public Integer getExpiresDaysForResourse(String extension) {
        if (getHttpServerConfig().getStaticExpiresExtensions().contains(extension)) {
            return getHttpServerConfig().getStaticExpiresDays();
        } else {
            return null;
        }
    }

}
