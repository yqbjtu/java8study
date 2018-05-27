
package com.yq.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * A configuration bean.
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
@Configuration
public class AppConfiguration {

//    @Autowired
//    Environment environment;
//
//    public int httpPort() {
//        return environment.getProperty("http.port", Integer.class, 8081);
//    }

    @Value("${vertx.http.port:8081}")
    private int httpPort;

    public int httpPort() {
        return httpPort;
    }
}
