package hykx.ds.whkc.rabbitmq;

import hykx.ds.whkc.bean.BBSPJG;
import hykx.ds.whkc.bean.BBSPZL;
import hykx.ds.whkc.tools.JSONChange;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "topic.bbspzl")
public class TopicReceiverBBSPZL {
        @Autowired
    private KhzlService khzlService;
    @RabbitHandler
    public void process(String message) throws IOException
    {
//        int i_pos;
//        String s_json;
//        BBSPZL bbspzl = new BBSPZL();
//        i_pos = message.indexOf("{");
//        s_json = message.substring(i_pos);
//        bbspzl = (BBSPZL) JSONChange.jsonToObj(bbspzl,s_json);
//        khzlService.BBSPZL(bbspzl);
//        System.out.println("接收者 BBSPZL,"+s_json);
    }
}

