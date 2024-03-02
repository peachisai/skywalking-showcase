package org.apache.skywalking.showcase.services.song.mq.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaMsgConsumer {

    private static final String TOPIC = "TEST_TOPIC";

    private static final String GROUP = "TEST_GROUP";

    @KafkaListener(topics = TOPIC, groupId = GROUP)
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
