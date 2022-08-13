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
    private Sender sender;
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private KhzlService khzlService;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedDelay = 1800*1000)
    public void reportCurrentTimeYZYGOODS()throws Exception {

        System.out.println("UPDATEYZYGOODS!");

        String context = "UPDATEYZYGOODS";

        String routeKey = "topic.yzygoods";

        String exchange = "topicExchange";

        context = "context:" + exchange + ",routeKey:" + routeKey + ",context:" + context;

        System.out.println("UPDATEYZYGOODS : " + context);

        sender.send(context);//20200520 whstruts 库存发布

        List<YZYGOODS> listsYZYGOODS = khzlService.getYZYGOODS();
        for (int i = 0; i < listsYZYGOODS.size(); i++) {
            YZYGOODS yzygoods = listsYZYGOODS.get(i);

            System.out.println("GetYZYGOODS,Name:" + JSONChange.objToJson(yzygoods));

            context = JSONChange.objToJson(yzygoods);

            routeKey = "topic.yzygoods";

            exchange = "topicExchange";

            context = "context:" + exchange + ",routeKey:" + routeKey + ",context:" + context;

            System.out.println("sendYZYGOODS : " + context);

            sender.send(context);//20200520 whstruts 库存发布
        }
        if(listsYZYGOODS.size()>20000) //新上架的商品超过一定数据才删除老的商品
        {
            System.out.println("DELETEYZYGOODS!");

            context = "DELETEYZYGOODS";

            routeKey = "topic.yzygoods";

            exchange = "topicExchange";

            context = "context:" + exchange + ",routeKey:" + routeKey + ",context:" + context;

            System.out.println("DELETEYZYGOODS : " + context);

            sender.send(context);//20200520 whstruts 库存发布
        }
    }

    @Scheduled(fixedDelay = 60*10*1000) //10分钟
    public void CurrentTimeGToY()throws Exception{
        khzlService.gysgoodsToyzygoods();//20200801 whstruts 准实时同步
        System.out.println("准实时同步GToY");
    }

    @Scheduled(cron = "0 0 */2 * * ?")
    public void DownSTGoods() throws Exception{
       khzlService.updateSTGoodsDown();
    }

}
