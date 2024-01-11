package kr.bb.wishlist.cart.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<Long,String> kafkaTemplate;

    public void send(String topicName, String data) {
        kafkaTemplate.send(topicName, data);
    }
}
