package hykx.ds.whkc.rabbitmq;

import hykx.ds.whkc.bean.mchk;
import hykx.ds.whkc.tools.JSONChange;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "topic.mchk")
public class TopicReceiverMCHK {
    @Autowired
    private KhzlService khzlService;
    @RabbitHandler
    public void process(String message) throws IOException
    {
        int i_pos;
        String s_json;
        mchk m = new mchk();
        i_pos = message.indexOf("{");
        s_json = message.substring(i_pos);
        m = (mchk) JSONChange.jsonToObj(m,s_json);
        khzlService.ItoMCHK(m);
        System.out.println("接收者 TopicReceiverMCHK,"+s_json);
    }
}
