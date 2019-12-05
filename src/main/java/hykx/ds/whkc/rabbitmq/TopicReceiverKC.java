//package hykx.ds.whkc.rabbitmq;
//
//import hykx.ds.whkc.bean.SpKC;
//import hykx.ds.whkc.tools.JSONChange;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//@RabbitListener(queues = "topic.whkcx")
//public class TopicReceiverKC {
//    @Autowired
//    private KhzlService khzlService;
//    @RabbitHandler
//    public void process(String message) throws IOException
//    {
//        int i_pos;
//        String s_json;
//        SpKC spkc = new SpKC();
//        i_pos = message.indexOf("{");
//        s_json = message.substring(i_pos);
//        spkc = (SpKC) JSONChange.jsonToObj(spkc,s_json);
//        khzlService.ItoKCs(spkc);
//        System.out.println("接收者 TopicReceiverKC,"+s_json);
//    }
//}
