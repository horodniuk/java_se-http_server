package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.HtmlTemplateManager;
import PROJECT_HTTP_SERVER.HttpServerContext;
import PROJECT_HTTP_SERVER.ServerInfo;
import PROJECT_HTTP_SERVER.config.*;
import PROJECT_HTTP_SERVER.exeptions.HttpServerConfigException;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ThreadFactory;


/**
 * конфигурация текущего сервера
 */
public class DefaultHttpServerConfig implements HttpServerConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHttpServerConfig.class);

    private final Properties serverProperties = new Properties(); // основные настройки
    private final Properties statusesProperties = new Properties();  // статус код - описание
    private final Properties mimeTypesProperties = new Properties(); // расширение файла - майм тайп
    private final BasicDataSource dataSource; // для пула соеденений к базе данных
    private final Path rootPath; // путь к корневой директории
    private final HttpServerContext httpServerContext;
    private final HttpRequestParser httpRequestParser;
    private final HttpResponseWriter httpResponseWriter;
    private final HttpResponseBuilder httpResponseBuilder;
    private final HttpRequestDispatcher httpRequestDispatcher; // обработчик запросов
    private final ThreadFactory workerThreadFactory; // для создания новых потоков
    private final HtmlTemplateManager htmlTemplateManager; // для сохдания html страничек
    private final ServerInfo serverInfo;
    private final List<String> staticExpiresExtensions; // статические ресурсы которые должны устаревать
    private final int staticExpiresDays;  // сколько дней должен устаривать данный ресурс

    DefaultHttpServerConfig(Properties overrideServerProperties) {
        super();
        loadAllProperties(overrideServerProperties);
        this.rootPath = createRootPath();
        this.dataSource = createBasicDataSource();
        this.serverInfo = createServerInfo();
        this.staticExpiresDays = Integer.parseInt(this.serverProperties.getProperty("webapp.static.expires.days"));
        this.staticExpiresExtensions = Arrays.asList(this.serverProperties.getProperty("webapp.static.expires.extensions").split(","));

        // Create default implementations
        this.httpServerContext = new DefaultHttpServerContext(this);
        this.httpRequestParser = new DefaultHttpRequestParser();
        this.httpResponseWriter = new DefaultHttpResponseWriter(this);
        this.httpResponseBuilder = new DefaultHttpResponseBuilder(this);
        this.httpRequestDispatcher = new DefaultHttpHandler();
        this.workerThreadFactory = new DefaultThreadFactory();
        this.htmlTemplateManager = null;
    }

    /**
     * загружает ресурсы по указанным properties
     *
     * @param overrideServerProperties
     */
    private void loadAllProperties(Properties overrideServerProperties) {
        ClassLoader classLoader = DefaultHttpServerConfig.class.getClassLoader();
        loadProperties(this.statusesProperties, classLoader, "statuses.properties");
        loadProperties(this.mimeTypesProperties, classLoader, "mime-types.properties");
        loadProperties(this.serverProperties, classLoader, "server.properties");
        if (overrideServerProperties != null) {
            LOGGER.info("Overrides default server properties");
            this.serverProperties.putAll(overrideServerProperties);
        }
        logServerProperties();
    }

    private void logServerProperties() {
        if (LOGGER.isDebugEnabled()) {
            StringBuilder res = new StringBuilder("Current server properties is:\n");
            for (Map.Entry<Object, Object> entry : this.serverProperties.entrySet()) {
                res.append(entry.getKey()).append('=').append(entry.getValue()).append('\n');
            }
            LOGGER.debug(res.toString());
        }
    }

    private void loadProperties(Properties statusesProperties, ClassLoader classLoader, String resource) {
        try (InputStream in = classLoader.getResourceAsStream(resource)) {
            if (in != null) {
                statusesProperties.load(in);
              LOGGER.debug("Successful loaded properties from classpath resource: {}", resource);
            } else {
                throw new HttpServerConfigException("Classpath resource not found: " + resource);
            }
        } catch (IOException e) {
            throw new HttpServerConfigException("Can't load properties from resource: " + resource, e);
        }
    }

    protected ServerInfo createServerInfo() {
        ServerInfo serverInfo = new ServerInfo(
                serverProperties.getProperty("server.name"),
                Integer.parseInt(serverProperties.getProperty("server.port")),
                Integer.parseInt(serverProperties.getProperty("server.thread.count")));
        if (serverInfo.getThreadCount() < 0) {
            throw new HttpServerConfigException("server.thread.count should be >= 0");
        }
        return serverInfo;
    }

    protected Path createRootPath() {
        Path path = Paths.get(new File(this.serverProperties.getProperty("wepapp.static.dir.root")).getAbsoluteFile().toURI());
        if (!Files.exists(path)) {
            throw new HttpServerConfigException("Root path not found: " + path.toString());
        }
        if (!Files.isDirectory(path)) {
            throw new HttpServerConfigException("Root path is not directory: " + path.toString());
        }
        LOGGER.info("Root path is {}", path.toAbsolutePath());
        return path;
    }

    protected BasicDataSource createBasicDataSource() {
        BasicDataSource dataSource = null;
        if (Boolean.parseBoolean(serverProperties.getProperty("db.datasource.enabled"))) {
            dataSource = new BasicDataSource();
            dataSource.setDefaultAutoCommit(false);
            dataSource.setRollbackOnReturn(true);
            dataSource.setDriverClassName(Objects.requireNonNull(serverProperties.getProperty("db.datasource.driver")));
            dataSource.setUrl(Objects.requireNonNull(serverProperties.getProperty("db.datasource.url")));
            dataSource.setUsername(Objects.requireNonNull(serverProperties.getProperty("db.datasource.username")));
            dataSource.setPassword(Objects.requireNonNull(serverProperties.getProperty("db.datasource.password")));
            dataSource.setInitialSize(Integer.parseInt(Objects.requireNonNull(serverProperties.getProperty("db.datasource.pool.initSize"))));
            dataSource.setMaxTotal(Integer.parseInt(Objects.requireNonNull(serverProperties.getProperty("db.datasource.pool.maxSize"))));
            LOGGER.info("Datasource is enabled. JDBC url is {}", dataSource.getUrl());
        } else {
            LOGGER.info("Datasource is disabled");
        }
        return dataSource;
    }


    @Override
    public ServerInfo getServerInfo() {
        return serverInfo;
    }

    @Override
    public String getStatusMessage(int statusCode) {
        String message = statusesProperties.getProperty(String.valueOf(statusCode));
        return message != null ? message : statusesProperties.getProperty("500");
    }

    @Override
    public HttpRequestParser getHttpRequestParser() {
        return httpRequestParser;
    }

    @Override
    public HttpResponseBuilder getHttpResponseBuilder() {
        return httpResponseBuilder;
    }

    @Override
    public HttpResponseWriter getHttpResponseWriter() {
        return httpResponseWriter;
    }

    @Override
    public HttpServerContext getHttpServerContext() {
        return httpServerContext;
    }

    @Override
    public HttpRequestDispatcher getHttpRequestDispatcher() {
        return httpRequestDispatcher;
    }

    @Override
    public ThreadFactory getWorkerThreadFactory() {
        return workerThreadFactory;
    }

    @Override
    public HttpClientSocketHandler buildNewHttpClientSocketHandler(Socket clientSocket) {
        return new DefaultHttpClientSocketHandler(clientSocket, this);
    }


    @Override
    public void close() {
        if (dataSource != null) {
            try {
                dataSource.close();
            } catch (SQLException e) {
                LOGGER.error("Close datasource failed: " + e.getMessage(), e);
            }
        }
        LOGGER.info("DefaultHttpServerConfig closed");
    }


    protected BasicDataSource getDataSource() {
        return dataSource;
    }

    protected Path getRootPath() {
        return rootPath;
    }

    protected Properties getStatusesProperties() {
        return statusesProperties;
    }

    public Properties getMimeTypesProperties() {
        return mimeTypesProperties;
    }


    protected HtmlTemplateManager getHtmlTemplateManager() {
        return htmlTemplateManager;
    }

    protected List<String> getStaticExpiresExtensions() {
        return staticExpiresExtensions;
    }

    protected int getStaticExpiresDays() {
        return staticExpiresDays;
    }
}
