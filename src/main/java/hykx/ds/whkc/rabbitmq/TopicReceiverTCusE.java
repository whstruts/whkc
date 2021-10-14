package hykx.ds.whkc.rabbitmq;//package hykx.ds.whkc.rabbitmq;


import hykx.ds.whkc.dao.ThirdCustomerDao;
import hykx.ds.whkc.entity.ThirdCustomerEntity;
import net.sf.json.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@RabbitListener(queues = "topic.thirdCustomer")
public class TopicReceiverTCusE {
    @Autowired
    private ThirdCustomerDao thirdCustomerDao;
    @RabbitHandler
    public void process(String message) throws IOException
    {
        int i_pos;
        String s_json;
        i_pos = message.indexOf("{");
        s_json = message.substring(i_pos);
        JSONObject jsonObject = JSONObject.fromObject(s_json);
        ThirdCustomerEntity tce = (ThirdCustomerEntity) JSONObject.toBean(jsonObject,ThirdCustomerEntity.class);
        thirdCustomerDao.save(tce);
        System.out.println("接收者 TopicReceiverTCE,"+s_json);
    }
}
