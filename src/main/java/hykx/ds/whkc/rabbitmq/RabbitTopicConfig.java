package hykx.ds.whkc.rabbitmq;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTopicConfig {

    final static String ERPDDHZ = "topic.erpddhz";
    final static String ERPDDMX = "topic.erpddmx";
    final static String ERPDD = "topic.erpdd";
    @Bean
    public Queue queueErpDDHZ() {
        return new Queue(RabbitTopicConfig.ERPDDHZ);
    }

    @Bean
    public Queue queueErpDDMX() {
        return new Queue(RabbitTopicConfig.ERPDDMX);
    }


    @Bean
    public Queue queueErpDD() {
        return new Queue(RabbitTopicConfig.ERPDD);
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
    Binding bindingExchangeDDHZ(Queue queueErpDDHZ, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueErpDDHZ).to(topicExchange).with("topic.erpddhz");
    }

    @Bean
    Binding bindingExchangeDDMX(Queue queueErpDDMX, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueErpDDMX).to(topicExchange).with("topic.erpddmx");
    }

    @Bean
    Binding bindingExchangeDD(Queue queueErpDD, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueErpDD).to(topicExchange).with("topic.erpdd");
    }

}
