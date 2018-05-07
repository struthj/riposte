package com.nike;

import com.nike.helloworld.controllers.HelloWorldEndpoint;
import com.nike.helloworld.controllers.ProductsEndpoint;
import com.nike.riposte.server.Server;
import com.nike.riposte.server.config.ServerConfig;
import com.nike.riposte.server.http.Endpoint;
import com.nike.riposte.server.logging.AccessLogger;

import java.util.Collection;
import java.util.Collections;

/**
 * Typically trivial sample to demonstrate the use of the Riposte core framework. After this application starts up
 * you can hit http://localhost:8080/products to receive alist of products response from {@link ProductsEndpoint}.
 */
public class Main {

    public static class AppServerConfig implements ServerConfig {
        private final Collection<Endpoint<?>> endpoints = Collections.singleton(new ProductsEndpoint.Get());
        private final AccessLogger accessLogger = new AccessLogger();

        @Override
        public Collection<Endpoint<?>> appEndpoints() {
            return endpoints;
        }

        @Override
        public AccessLogger accessLogger() {
            return accessLogger;
        }
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(new AppServerConfig());
        server.startup();
    }
}
