package hykx.ds.whkc.rabbitmq;

import hykx.ds.whkc.bean.BBSPJG;
import hykx.ds.whkc.bean.BBSPPH;
import hykx.ds.whkc.tools.JSONChange;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "topic.bbspph")
public class TopicReceiverBBSPPH {
        @Autowired
    private KhzlService khzlService;
    @RabbitHandler
    public void process(String message) throws IOException
    {
//        int i_pos;
//        String s_json;
//        BBSPPH bbspph = new BBSPPH();
//        i_pos = message.indexOf("{");
//        s_json = message.substring(i_pos);
//        bbspph = (BBSPPH) JSONChange.jsonToObj(bbspph,s_json);
//        khzlService.BBSPPH(bbspph);
//        System.out.println("接收者 BBSPPH,"+s_json);
    }
}

