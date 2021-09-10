package art.ayhz.rabbitmqtest.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.a")
public class FanoutAConsumer {
    @RabbitHandler
    public void recivedFanoutA(String msg){
        System.out.println("[fanout.a]: recived msg:"+msg);
    }
}
