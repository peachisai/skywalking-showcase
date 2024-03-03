package org.apache.skywalking.showcase.services.song.mq.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

@Component
public class KafkaMsgProducer {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @PostConstruct
    public void init() {
        if (StringUtils.isEmpty(bootstrapServers)) {
            return;
        }
        System.out.println(bootstrapServers);
    }
}
