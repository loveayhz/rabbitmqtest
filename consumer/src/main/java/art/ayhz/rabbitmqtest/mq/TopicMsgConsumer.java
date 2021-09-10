package art.ayhz.rabbitmqtest.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topicA")
public class TopicMsgConsumer {
    @RabbitHandler
    public void reciveTopic(String msg){
        System.out.println("[topicA]: recived msg:"+msg);
    }
}
