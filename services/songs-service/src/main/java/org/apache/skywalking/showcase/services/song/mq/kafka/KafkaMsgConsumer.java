package org.apache.skywalking.showcase.services.song.mq.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaMsgConsumer {

    private static final String TOPIC = "TEST_TOPIC";

    @KafkaListener(topics = TOPIC)
    public void onMessage(String msg) {
        log.info("kafka receive msg :{}", msg);
    }
}
