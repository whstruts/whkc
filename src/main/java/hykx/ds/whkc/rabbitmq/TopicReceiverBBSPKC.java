package hykx.ds.whkc.rabbitmq;

import hykx.ds.whkc.bean.BBSPKC;
import hykx.ds.whkc.tools.JSONChange;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "topic.bbspkc")
public class TopicReceiverBBSPKC {
        @Autowired
    private KhzlService khzlService;
    @RabbitHandler
    public void process(String message) throws IOException
    {
//        int i_pos;
//        String s_json;
//        BBSPKC bbspkc = new BBSPKC();
//        i_pos = message.indexOf("{");
//        s_json = message.substring(i_pos);
//        bbspkc = (BBSPKC) JSONChange.jsonToObj(bbspkc,s_json);
//        khzlService.BBSPKC(bbspkc);
//        System.out.println("接收者 BBSPKC,"+s_json);
    }
}

