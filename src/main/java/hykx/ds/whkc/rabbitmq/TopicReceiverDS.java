package hykx.ds.whkc.rabbitmq;

import hykx.ds.whkc.bean.Ddzt;
import hykx.ds.whkc.tools.JSONChange;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "topic.whds")
public class TopicReceiverDS {
    @Autowired
    private KhzlService khzlService;
    @RabbitHandler
    public void process(String message) throws IOException
    {
        int i_pos;
        String s_json;
        Ddzt ddzt = new Ddzt();
        i_pos = message.indexOf("{");
        s_json = message.substring(i_pos);
        ddzt = (Ddzt) JSONChange.jsonToObj(ddzt,s_json);
        khzlService.ItoDDs(ddzt);
        System.out.println("接收者 TopicReceiverDS,"+s_json);

    }
}
