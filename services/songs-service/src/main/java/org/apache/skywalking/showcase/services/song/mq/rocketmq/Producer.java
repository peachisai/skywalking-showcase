package org.apache.skywalking.showcase.services.song.mq.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * @description:
 * @author: sym
 * @create: 2023-11-18 18:02
 **/

@Slf4j
@Component
public class Producer {

    @Value("${ROCKETMQ_SERVER_URL:127.0.0.1:9876}")
    private String rocketmqAddr;

    @PostConstruct
    public void initMQ() {
        try {
            DefaultMQProducer producer = new DefaultMQProducer("producer-group");
            producer.setNamesrvAddr(rocketmqAddr);
            producer.start();

            for (int i = 0; i < 100; i++) {
                Message message = new Message("topic1", "hello rocketmq".getBytes(StandardCharsets.UTF_8));
                Message message2 = new Message("topic2", "hello rocketmq2".getBytes(StandardCharsets.UTF_8));
                SendResult result = producer.send(message);
                SendResult result2 = producer.send(message2);
                System.out.println("producer返回结果" + result);
                System.out.println("producer返回结果" + result2);
                Thread.sleep(new Random().nextInt(10) * 3000);
            }

            producer.shutdown();
        } catch (Exception e) {
            log.error("rocketmq", e);
        }
    }
}
