package hykx.ds.whkc.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.fanout.exchange}")
    private String fanoutExchangeName;

    public void send(int index) {
        // 直接发送到 exchange
        rabbitTemplate.convertAndSend(fanoutExchangeName, "", index);
    }

    public void send(String content) {
        // 直接发送到 exchange
        rabbitTemplate.convertAndSend(fanoutExchangeName, "", content);
    }
}
