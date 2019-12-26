package hykx.ds.whkc.rabbitmq;

import hykx.ds.whkc.bean.*;
import hykx.ds.whkc.tools.JSONChange;
import net.sf.json.JSONObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class ScheduledTasks {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private KhzlService khzlService;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//    @Scheduled(fixedDelay = 60*1000)
//    public void reportCurrentTime()throws Exception {
//
//        List<ERPddhz> listsDDHZ = khzlService.getDDHZ();
//        for (int i = 0; i < listsDDHZ.size(); i++) {
//            ERPddhz ddhz = listsDDHZ.get(i);
//
//            List<ERPddmx> listDDMX = khzlService.getDDMXbyID(ddhz.getKpbh());
//            ERPDD dd = new ERPDD();
//            if(listDDMX.size()>0)
//            {
//                dd.setErpddhz(ddhz);
//                dd.setErpddmxs(listDDMX);
//            }
//            else
//                return;
//            khzlService.UpdateDD(ddhz.getKpbh());//更新订单汇总状态
//            for(int j = 0;j<listDDMX.size();j++)
//            {
//                khzlService.UpdateDDMX(listDDMX.get(j));  //更新订单明细状态
//            }
//
//            JSONObject data = JSONObject.fromObject(dd);
//
//            System.out.println("GetDD,Name:" + data.toString());
//
//
//            String context = data.toString();
//
//            String routeKey = "topic.erpdd";
//
//            String exchange = "topicExchange";
//
//            context = "context:" + exchange + ",routeKey:" + routeKey + ",context:" + context;
//
//            System.out.println("sendDDTest : " + context);
//
//            this.rabbitTemplate.convertAndSend(exchange, routeKey, context);
//        }
//    }

//    @Scheduled(fixedDelay = 600*1000)//20190829 whstruts 定时回写药师帮订单数据
//    public void reportCurrentTime1()throws Exception{
//        khzlService.DoYSBWriteBack();
//        System.out.println("DoYSBWriteBack!");
//    }

    @Scheduled(fixedDelay = 1800*1000)
    public void reportCurrentTimeYZYGOODS()throws Exception {

        System.out.println("DELETEYZYGOODS!");

        String context = "DELETEYZYGOODS";

        String routeKey = "topic.yzygoods";

        String exchange = "topicExchange";

        context = "context:" + exchange + ",routeKey:" + routeKey + ",context:" + context;

        System.out.println("DELETEYZYGOODS : " + context);

        this.rabbitTemplate.convertAndSend(exchange, routeKey, context);

        List<YZYGOODS> listsYZYGOODS = khzlService.getYZYGOODS();
        for (int i = 0; i < listsYZYGOODS.size(); i++) {
            YZYGOODS yzygoods = listsYZYGOODS.get(i);

            System.out.println("GetYZYGOODS,Name:" + JSONChange.objToJson(yzygoods));

            context = JSONChange.objToJson(yzygoods);

            routeKey = "topic.yzygoods";

            exchange = "topicExchange";

            context = "context:" + exchange + ",routeKey:" + routeKey + ",context:" + context;

            System.out.println("sendYZYGOODS : " + context);

            this.rabbitTemplate.convertAndSend(exchange, routeKey, context);
        }
    }
}
