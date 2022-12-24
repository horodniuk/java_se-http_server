package lecture16_http_interface.impl;

import lecture16_http_interface.HttpServer;

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
