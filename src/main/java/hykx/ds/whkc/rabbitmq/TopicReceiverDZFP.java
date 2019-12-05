//package hykx.ds.whkc.rabbitmq;
//
//import hykx.ds.whkc.bean.DZFP;
//import hykx.ds.whkc.tools.JSONChange;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//@RabbitListener(queues = "topic.whdzfp")
//public class TopicReceiverDZFP {
//    @Autowired
//    private KhzlService khzlService;
//    @RabbitHandler
//    public void process(String message) throws IOException
//    {
//        int i_pos;
//        String s_json;
//        DZFP dzfp = new DZFP();
//        i_pos = message.indexOf("{");
//        s_json = message.substring(i_pos);
//        dzfp = (DZFP) JSONChange.jsonToObj(dzfp,s_json);
//        khzlService.ItoDZFPs(dzfp);
//        System.out.println("接收者 TopicReceiverDZFP,"+s_json);
//
//    }
//}
