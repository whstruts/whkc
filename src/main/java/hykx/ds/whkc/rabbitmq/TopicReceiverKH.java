//package hykx.ds.whkc.rabbitmq;
//
//import hykx.ds.whkc.bean.Khzl;
//import hykx.ds.whkc.tools.JSONChange;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//@RabbitListener(queues = "topic.whkhcx")
//public class TopicReceiverKH {
//    @Autowired
//    private KhzlService khzlService;
//    @RabbitHandler
//    public void process(String message) throws IOException
//    {
//        int i_pos;
//        String s_json;
//        Khzl khzl = new Khzl();
//        i_pos = message.indexOf("{");
//        s_json = message.substring(i_pos);
//        khzl = (Khzl) JSONChange.jsonToObj(khzl,s_json);
//        khzlService.ItoKhs(khzl);
//        System.out.println("接收者 TopicReceiverKH,"+s_json);
//    }
//}
