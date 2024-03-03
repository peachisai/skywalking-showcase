package org.apache.skywalking.showcase.services.song.mq.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMsgConsumer {

    @KafkaListener(id = "kafkaListener", topics = "topic")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
