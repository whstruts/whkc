package hykx.ds.whkc.rabbitmq;

import hykx.ds.whkc.bean.STGoods;
import hykx.ds.whkc.tools.JSONChange;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "topic.ST2YNGoods")
public class TopicReceiverST2YNGoods {
    @Autowired
    private KhzlService khzlService;
    @RabbitHandler
    public void process(String message) throws IOException
    {
        int i_pos;
        String s_json;
        STGoods stGoods = new STGoods();
        i_pos = message.indexOf("{");
        s_json = message.substring(i_pos);
        stGoods = (STGoods) JSONChange.jsonToObj(stGoods,s_json);
        khzlService.ItoST2YNGoods(stGoods);
        System.out.println("接收者 TopicReceiverST2YNGoods,"+s_json);
    }
}
