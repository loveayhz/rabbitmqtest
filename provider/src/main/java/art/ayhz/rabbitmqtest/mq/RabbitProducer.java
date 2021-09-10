package art.ayhz.rabbitmqtest.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class RabbitProducer {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void sendDemoQueue(){
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss").format(date);
        System.out.println("[demoQueue] send msg:"+dateString);
        this.rabbitTemplate.convertAndSend("demoQueue",dateString);
    }

    public void sendFanout(){
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss").format(date);
        System.out.println("[fanout] send msg:"+dateString);
        this.rabbitTemplate.convertAndSend("fanoutExchange","",dateString);
    }

    public void sendFanoutJSON(Object obj){
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss").format(date)+obj;
        System.out.println("[fanout] send msg:"+dateString);
        this.rabbitTemplate.convertAndSend("fanoutExchange","",dateString);
    }

    public void sendTopicAB(){
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss").format(date);
        System.out.println("[topicAB] send msg:"+dateString);
        this.rabbitTemplate.convertAndSend("topicExchange","topic.msg",dateString);
    }

    public void sendTopicB(){
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss").format(date);
        System.out.println("[topicB] send msg:"+dateString);
        this.rabbitTemplate.convertAndSend("topicExchange","topic.aaaaa",dateString);

    }
    public void sendTopicBC(){
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss").format(date);
        System.out.println("[topicBC] send msg:"+dateString);
        this.rabbitTemplate.convertAndSend("topicExchange","topic.a.c",dateString);

    }
}
