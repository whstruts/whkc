package hykx.ds.whkc.rabbitmq;

import hykx.ds.whkc.bean.BBSPJG;
import hykx.ds.whkc.bean.BBSPKC;
import hykx.ds.whkc.tools.JSONChange;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "topic.bbspjg")
public class TopicReceiverBBSPJG {
        @Autowired
    private KhzlService khzlService;
    @RabbitHandler
    public void process(String message) throws IOException
    {
//        int i_pos;
//        String s_json;
//        BBSPJG bbspjg = new BBSPJG();
//        i_pos = message.indexOf("{");
//        s_json = message.substring(i_pos);
//        bbspjg = (BBSPJG) JSONChange.jsonToObj(bbspjg,s_json);
//        khzlService.BBSPJG(bbspjg);
//        System.out.println("接收者 BBSPJG,"+s_json);
    }
}

