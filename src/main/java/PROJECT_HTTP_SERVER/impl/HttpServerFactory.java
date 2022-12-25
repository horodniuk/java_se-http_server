package PROJECT_HTTP_SERVER.impl;

import PROJECT_HTTP_SERVER.HttpServer;

import java.util.Properties;

public class HttpServerFactory {
    protected  HttpServerFactory(){

    }

    public static HttpServerFactory create(){
        return new HttpServerFactory();
    }

    public HttpServer createHttpServer(Properties overridesServerProperties){
        return new HttpServer() {
            @Override
            public void start() {

            }

            @Override
            public void stop() {

            }
        };
    }
}
