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

    final static String GYSGOODS = "topic.gysgoods"; //20200724 whstruts 供应商 商品库存

    final static String STGOODS = "topic.STGoods"; //20200724 whstruts 供应商 商品库存

    final static String MCHK = "topic.mchk"; //20220513

    @Bean
    public Queue queueYZYGOODS() {
        return new Queue(RabbitTopicConfig.YZYGOODS);
    }

    @Bean
    public Queue queueGYSGOODS() {
        return new Queue(RabbitTopicConfig.GYSGOODS);
    }

    @Bean
    public Queue queueSTGOODS() {
        return new Queue(RabbitTopicConfig.STGOODS);
    }

    @Bean
    public Queue queueMCHK() {
        return new Queue(RabbitTopicConfig.MCHK);
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

    @Bean
    Binding bindingExchangeGYSGOODS(Queue queueGYSGOODS, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueGYSGOODS).to(topicExchange).with("topic.gysgoods");
    }

    @Bean
    Binding bindingExchangeSTGOODS(Queue queueSTGOODS, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueSTGOODS).to(topicExchange).with("topic.STGoods");
    }

    @Bean
    Binding bindingExchangeMCHK(Queue queueMCHK, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueMCHK).to(topicExchange).with("topic.mchk");
    }


}
