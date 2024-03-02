package org.apache.skywalking.showcase.services.song.mq.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class KafkaMsgProducer {

    private static final String TOPIC = "TEST_TOPIC";

    private static final String MESSAGE = "This is a message";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostConstruct
    public void init() {
        while (true) {
            try {
                ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC, MESSAGE);
                SendResult<String, String> result = future.get();
                System.out.println(result.getProducerRecord());
                Thread.sleep(new Random().nextInt(10) * 10000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
