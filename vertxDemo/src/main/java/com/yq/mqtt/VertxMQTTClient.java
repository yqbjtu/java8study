
package com.yq.mqtt;

import io.netty.handler.codec.mqtt.MqttQoS;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.mqtt.MqttClient;
import io.vertx.mqtt.MqttClientOptions;

import java.nio.charset.Charset;


public class VertxMQTTClient extends AbstractVerticle {

    private static final String MQTT_TOPIC = "topic01";
    private static final String MQTT_MESSAGE = "Hello Vert.x MQTT Client";
    private static final String BROKER_HOST = "192.168.119.131";
    private static final int BROKER_PORT = 1883;

    // Convenience method so you can run it in your IDE
    public static void main(String[] args) {
        Runner.runExample(VertxMQTTClient.class);
    }

    @Override
    public void start() throws Exception {
        MqttClientOptions options = new MqttClientOptions().setKeepAliveTimeSeconds(2);
        //options.setUsername();
        //options.setPassword()
        MqttClient client = MqttClient.create(Vertx.vertx(), options);

        // handler will be called when we have a message in topic we subscribing for
        client.publishHandler(publish -> {
            System.out.println("Just received message on [" + publish.topicName() + "] payload [" + publish.payload().toString(Charset.defaultCharset()) + "] with QoS [" + publish.qosLevel() + "]");
        });

        // handle response on subscribe request
        client.subscribeCompletionHandler(h -> {
            System.out.println("Receive SUBACK from server with granted QoS : " + h.grantedQoSLevels());

            // let's publish a message to the subscribed topic
            client.publish(
                    MQTT_TOPIC,
                    Buffer.buffer(MQTT_MESSAGE),
                    MqttQoS.AT_MOST_ONCE,
                    false,
                    false,
                    s -> System.out.println("Publish sent to a server"));

            // unsubscribe from receiving messages for earlier subscribed topic
            //vertx.setTimer(5000, l -> client.unsubscribe(MQTT_TOPIC));
        });

        // handle response on unsubscribe request
        client.unsubscribeCompletionHandler(h -> {
            System.out.println("Receive UNSUBACK from server");
            vertx.setTimer(5000, l ->
                    // disconnect for server
                    client.disconnect(d -> System.out.println("Disconnected form server"))
            );
        });

        // connect to a server
        client.connect(BROKER_PORT, BROKER_HOST, ch -> {
            if (ch.succeeded()) {
                System.out.println("Connected to a server");
                client.subscribe(MQTT_TOPIC, 0);
            } else {
                System.out.println("Failed to connect to a server");
                System.out.println(ch.cause());
            }
        });
    }
}
