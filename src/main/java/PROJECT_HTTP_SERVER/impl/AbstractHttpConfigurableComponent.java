package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.config.HttpServerConfig;

public class AbstractHttpConfigurableComponent {
    final HttpServerConfig httpServerConfig;

    AbstractHttpConfigurableComponent(HttpServerConfig httpServerConfig) {
        this.httpServerConfig = httpServerConfig;
    }
}
