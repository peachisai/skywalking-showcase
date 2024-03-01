package org.apache.skywalking.showcase.services.song.mq.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class KafkaMsgProducer {

    private static final String TOPIC = "TEST_TOPIC";

    private static final String MESSAGE = "This is a message";

    private static final String BROKER_LIST = "43.139.166.178:9092";

    private static final String ACK_CONFIG = "all";

    /**
     * 缓存消息数达到此数值后批量提交
     */
    private static final String BATCH_SIZE_CONFIG = "1";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostConstruct
    public void init() {
        while (true) {
            kafkaTemplate.send(TOPIC, MESSAGE);
            try {
                Thread.sleep(new Random().nextInt(10) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
