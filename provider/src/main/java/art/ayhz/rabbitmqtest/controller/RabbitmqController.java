package art.ayhz.rabbitmqtest.controller;

import art.ayhz.rabbitmqtest.mq.RabbitProducer;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitmqController {
    @Autowired
    private RabbitProducer rabbitProducer;

    @GetMapping("/sendDemoQueue")
    public Object senddemoQueue(){
        rabbitProducer.sendDemoQueue();
        return "success";
    }
    @GetMapping("/sendfanoutExchange")
    public Object sendfanoutExchange(){
        rabbitProducer.sendFanout();
        return "success";
    }

    @GetMapping("/sendfanoutJson")
    public Object sendfanoutJson(){
        User user=new User("zs","123456","18908354606");
        rabbitProducer.sendFanoutJSON(user);
        return "success";
    }

    @GetMapping("/sendTopicAB")
    public Object sendTopicAB(){
        rabbitProducer.sendTopicAB();
        return "success";
    }

    @GetMapping("/sendTopicB")
    public Object sendTopicB(){
        rabbitProducer.sendTopicB();
        return "success";
    }

    @GetMapping("/sendTopicBC")
    public Object sendTopicBC(){
        rabbitProducer.sendTopicBC();
        return "success";
    }
}

@Data
@AllArgsConstructor
class User{
    private String name;
    private String passwd;
    private String phone;

}