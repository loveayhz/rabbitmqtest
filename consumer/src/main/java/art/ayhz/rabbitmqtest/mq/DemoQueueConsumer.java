package art.ayhz.rabbitmqtest.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "demoQueue")
public class DemoQueueConsumer {

    /***
     * 消息消费
     * @RabbitHandler此注解标记的方法表示接受到消息队列后的处理方法
     * @param msg
     */
    @RabbitHandler
    public void recived(String msg){
        System.out.println("[demoQueue] recived msg:"+msg);
    }
}
