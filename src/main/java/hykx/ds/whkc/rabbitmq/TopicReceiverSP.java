//package hykx.ds.whkc.rabbitmq;
//
//import hykx.ds.whkc.bean.Spzl;
//import hykx.ds.whkc.tools.JSONChange;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//@RabbitListener(queues = "topic.whkspx")
//public class TopicReceiverSP {
//    @Autowired
//    private KhzlService khzlService;
//    @RabbitHandler
//    public void process(String message) throws IOException
//    {
//        int i_pos;
//        String s_json;
//        Spzl spzl = new Spzl();
//        i_pos = message.indexOf("{");
//        s_json = message.substring(i_pos);
//        spzl = (Spzl) JSONChange.jsonToObj(spzl,s_json);
//        khzlService.ItoSPs(spzl);
//        System.out.println("接收者 TopicReceiverSP,"+s_json);
//    }
//}
