package hykx.ds.whkc.rabbitmq;

import hykx.ds.whkc.bean.*;
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
    @Scheduled(fixedDelay = 60*1000)
    public void reportCurrentTime()throws Exception {

        List<ERPddhz> listsDDHZ = khzlService.getDDHZ();
        for (int i = 0; i < listsDDHZ.size(); i++) {
            ERPddhz ddhz = listsDDHZ.get(i);

            List<ERPddmx> listDDMX = khzlService.getDDMXbyID(ddhz.getKpbh());
            ERPDD dd = new ERPDD();
            if(listDDMX.size()>0)
            {
                dd.setErpddhz(ddhz);
                dd.setErpddmxs(listDDMX);

                khzlService.UpdateDD(ddhz.getKpbh());//更新订单汇总状态
                for(int j = 0;j<listDDMX.size();j++)
                {
                    khzlService.UpdateDDMX(listDDMX.get(j));  //更新订单明细状态
                }

                JSONObject data = JSONObject.fromObject(dd);

                System.out.println("GetDD,Name:" + data.toString());


                String context = data.toString();

                String routeKey = "topic.erpdd";

                String exchange = "topicExchange";

                context = "context:" + exchange + ",routeKey:" + routeKey + ",context:" + context;

                System.out.println("sendDDTest : " + context);

                this.rabbitTemplate.convertAndSend(exchange, routeKey, context);
            }
            else
                continue; //20191213 whstruts 明细没有数据，继续处理下一订单
        }
    }

    @Scheduled(fixedDelay = 600*1000)//20190829 whstruts 定时回写药师帮订单数据
    public void reportCurrentTime1()throws Exception{
        khzlService.DoYSBWriteBack();
        System.out.println("DoYSBWriteBack!");
    }


}
