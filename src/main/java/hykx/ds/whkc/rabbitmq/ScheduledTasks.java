package hykx.ds.whkc.rabbitmq;


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
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

}
