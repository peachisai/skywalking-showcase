package org.apache.skywalking.showcase.services.song.mq.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

@Component
public class KafkaMsgProducer {


    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostConstruct
    public void sendMessage(String topic, String message) {
        if (StringUtils.isEmpty(bootstrapServers)) {
            return;
        }
        kafkaTemplate.send(topic, message);
    }
}
