package hykx.ds.whkc.rabbitmq;//package hykx.ds.whkc.rabbitmq;

import hykx.ds.whkc.dao.ThirdCommodityDao;
import hykx.ds.whkc.entity.ThirdCommodityEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@RabbitListener(queues = "topic.thirdCommodity")
public class TopicReceiverTCE {
    @Autowired
    private ThirdCommodityDao thirdCommodityDao;
    @RabbitHandler
    public void process(String message) throws IOException
    {
        int i_pos;
        String s_json;
        i_pos = message.indexOf("{");
        s_json = message.substring(i_pos);
        JSONObject jsonObject = JSONObject.fromObject(s_json);
        ThirdCommodityEntity tce = (ThirdCommodityEntity) JSONObject.toBean(jsonObject,ThirdCommodityEntity.class);
        thirdCommodityDao.save(tce);
        System.out.println("接收者 TopicReceiverTCE,"+s_json);
    }
}
