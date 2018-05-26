
package com.yq.router;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simple to Introduction
 * className: RoutePathServer
 *
 * @author EricYang
 * @version 2018/5/26 12:48
 */

public class RoutePathServer extends AbstractVerticle {
    private static final Logger logger = LoggerFactory.getLogger(RoutePathServer.class);

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpServer server = vertx.createHttpServer();

        Router router = Router.router(vertx);

        // 路径必须是以“/”开头的,但是Route将会忽略最后的斜杠（/）,当然我们也可以使用通配符“*”,这样就能匹配以该路径开头的所有路径了
        //还有占位符“:”用于获取路径参数的，以及使用正则表达式匹配路径URI的，官网都有例子
        //http://127.0.0.1:8080/dev/aaa http://127.0.0.1:8080/dev/bbb
        //当访问http://127.0.0.1:8080/， 页面提示 Resource not found  http://127.0.0.1:8080/
        Route route = router.route().path("/dev/*");
        //还可以将数据放在routingContext中，put get
        route.handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            response.putHeader("Content-Type", "text/html;charset=UTF-8");
            response.end("根据路径(Path dev)配置的路由");
        });

        //http://127.0.0.1:8080/test/aaa http://127.0.0.1:8080/test/bbb
        //当访问http://127.0.0.1:8080/， 页面提示 Resource not found  http://127.0.0.1:8080/
        Route route2 = router.route().path("/test/*");
        //还可以将数据放在routingContext中，put get
        route2.handler(routingContext -> {
            HttpServerResponse response = routingContext.response();
            response.putHeader("Content-Type", "text/html;charset=UTF-8");
            response.putHeader("Content-Language", "en,zh");
            String data = "根据路径(Path test)配置的路由";

            response.end(data);
        });
        logger.info("Path helloworld starting done");
        server.requestHandler(router::accept).listen(8080);
    }

}
