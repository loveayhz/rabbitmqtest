package art.ayhz.rabbitmqtest.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topicB")
public class TopicAnyConsumer {
    @RabbitHandler
    public void reciveTopic(String msg){
        System.out.println("[topicB]: recived msg:"+msg);
    }
}
