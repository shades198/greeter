/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shades.greeter.config;

import org.eclipse.jetty.http.HttpStatus;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author shantanu
 */
@Configuration
public class JettyConfiguration {
//    @Bean
//    public ConfigurableServletWebServerFactory webServerFactory() 
//    {
//        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
//        factory.setPort(8082);
//        factory.setContextPath("/myapp");
//        factory.addErrorPages(new ErrorPage(org.springframework.http.HttpStatus.NOT_FOUND, "/notfound.html"));
//        return factory;
//    }
    
    @Bean
    public JettyServletWebServerFactory jettyServletWebServerFactory() {
        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
        factory.addServerCustomizers(server -> {
            GzipHandler gzipHandler = new GzipHandler();
            gzipHandler.setInflateBufferSize(1);
            gzipHandler.setHandler(server.getHandler());

            HandlerCollection handlerCollection = new HandlerCollection(gzipHandler);
            server.setHandler(handlerCollection);
        });
        factory.setPort(8082);
        return factory;
    }
}
