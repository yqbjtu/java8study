
package com.yq;

import io.vertx.core.Vertx;

/**
 * Simple to Introduction
 * className: HelloWorldVertx
 *
 * @author EricYang
 * @version 2018/5/26 13:22
 */
public class HelloWorldVertx {
    public static void main(String[] args){
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new MyVerticle());
    }
}
