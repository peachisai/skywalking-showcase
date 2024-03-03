package org.apache.skywalking.showcase.services.song.mq.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class KafkaMsgProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostConstruct
    public void init() {
        log.info("start kafka producer");
        kafkaTemplate.send("topic", "skywalking-showcase-kafka");
    }
}
