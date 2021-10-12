package hykx.ds.whkc.rabbitmq;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTopicConfig {


    final static String thirdCommodity = "topic.thirdCommodity"; //20211011


    @Bean
    public Queue queueThirdCommodity() {
        return new Queue(RabbitTopicConfig.thirdCommodity);
    }


    /**
     * 交换机(Exchange) 描述：接收消息并且转发到绑定的队列，交换机不存储消息
     */
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }
    //綁定队列 queueYmq() 到 topicExchange 交换机,路由键只要是以 topic 开头的队列接受者可以收到消息


    @Bean
    Binding bindingExchangeThirdCommodity(Queue queueThirdCommodity, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueThirdCommodity).to(topicExchange).with("topic.thirdCommodity");
    }


}
