package hykx.ds.whkc.rabbitmq;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTopicConfig {


    final static String YZYGOODS = "topic.yzygoods"; //20191226 whstruts 兵兵 MSSQL 商品库存

    @Bean
    public Queue queueYZYGOODS() {
        return new Queue(RabbitTopicConfig.YZYGOODS);
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
    Binding bindingExchangeYZYGOODS(Queue queueYZYGOODS, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueYZYGOODS).to(topicExchange).with("topic.yzygoods");
    }

}
