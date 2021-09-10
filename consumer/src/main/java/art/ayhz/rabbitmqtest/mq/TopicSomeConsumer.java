package art.ayhz.rabbitmqtest.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topicC")
public class TopicSomeConsumer {
    @RabbitHandler
    public void reciveTopic(String msg){
        System.out.println("[topicC]: recived msg:"+msg);
    }
}
