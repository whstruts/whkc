package hykx.ds.whkc.rabbitmq;

import hykx.ds.whkc.bean.STGoods;
import hykx.ds.whkc.bean.gysgoods;
import hykx.ds.whkc.tools.JSONChange;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "topic.STGoods")
public class TopicReceiverSTGoods {
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
        khzlService.ItoSTGoods(stGoods);
        System.out.println("接收者 TopicReceiverSTGoods,"+s_json);
    }
}
