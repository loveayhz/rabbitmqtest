package art.ayhz.rabbitmqtest.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "lqbz")
public class FanoutCLQBZonsumer {
    @RabbitHandler
    public void recivedFanoutC(String msg){
        System.out.println("[lqbz]: recived msg:"+msg);
    }
}
