package art.ayhz.rabbitmqtest.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.c")
public class FanoutCConsumer {
    @RabbitHandler
    public void recivedFanoutC(String msg){
        System.out.println("[fanout.c]: recived msg:"+msg);
    }
}
