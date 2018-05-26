
package com.yq;

import com.yq.base.StaticServer;
import io.vertx.core.Vertx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * Simple to Introduction
 * className: VertxApplication
 *
 * @author EricYang
 * @version 2018/5/26 22:34
 */

@SpringBootApplication
public class VertxApplication {

    @Autowired
    private StaticServer staticServer;

    public static void main(String[] args) {

        // This is basically the same example as the web-examples static site example but it's booted using
        // Spring Boot, not Vert.x
        SpringApplication.run(VertxApplication.class, args);
    }

    @PostConstruct
    public void deployVerticle() {
        Vertx.vertx().deployVerticle(staticServer);
    }
}