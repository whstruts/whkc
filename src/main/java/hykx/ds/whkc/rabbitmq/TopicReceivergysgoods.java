package hykx.ds.whkc.rabbitmq;

import hykx.ds.whkc.bean.gysgoods;
import hykx.ds.whkc.tools.JSONChange;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "topic.gysgoods")
public class TopicReceivergysgoods {
    @Autowired
    private KhzlService khzlService;
    @RabbitHandler
    public void process(String message) throws IOException
    {
        int i_pos;
        String s_json;
        gysgoods gysgoods = new gysgoods();
        i_pos = message.indexOf("{");
        s_json = message.substring(i_pos);
        gysgoods = (gysgoods) JSONChange.jsonToObj(gysgoods,s_json);
        khzlService.Itogysgoods(gysgoods);
       // khzlService.gysgoodsToyzygoods();//20200801 whstruts 准实时同步
        System.out.println("接收者 TopicReceiverGYS,"+s_json);
    }
}
