package com.yq.helloworld;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

/**
 * Simple to Introduction
 * className: MyVerticle
 *
 * @author EricYang
 * @version 2018/5/26 13:21
 */
public class MyVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        final Router router = Router.router(vertx);

        router.route().handler(BodyHandler.create());
        // router.get("/hello")表示所监听URL路径, 只匹配精确的http://127.0.0.1:8080/hello， http://127.0.0.1:8080/hello/aaa不行
        router.get("/hello").handler(new Handler<RoutingContext>() {
            @Override
            public void handle(RoutingContext event) {
                event.response().putHeader("content-type", "text/html").end("Hello World");
            }
        });

        vertx.createHttpServer().requestHandler(new Handler<HttpServerRequest>() {
            @Override
            public void handle(HttpServerRequest event) {
                router.accept(event);
            }
        }).listen(8080);
    }

    @Override
    public void stop(Future stopFuture) throws Exception{
        System.out.println("MyVerticle stopped!");
    }
}