package art.ayhz.rabbitmqtest.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    /**
     * 定义demoQueue队列
     * @return
     */
    @Bean
    public Queue demoString() {
        return new Queue("demoQueue");
    }


    //------------fanout 广播模式
    @Bean
    public Queue fanoutA(){
        return new Queue("fanout.a");
    }
    @Bean
    public Queue fanoutB(){
        return new Queue("fanout.b");
    }
    @Bean
    public Queue fanoutC(){
        return new Queue("fanout.c");
    }

    @Bean
    public Queue fanoutLQBZ(){
        return new Queue("lqbz");
    }

    //-----------定义fanout交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        //--定义一个fanout交换机
        return new FanoutExchange("fanoutExchange");
    }

    //将定义的fanout队列与fanoutExchange交换机绑定
    @Bean
    public Binding bindingExchangeWithA(){
        return BindingBuilder.bind(fanoutA()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingExchangeWithB(){
        return BindingBuilder.bind(fanoutB()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingExchangeWithC(){
        return BindingBuilder.bind(fanoutLQBZ()).to(fanoutExchange());
    }

    @Bean
    public Binding bindingExchangeWithHHH(){
        return BindingBuilder.bind(fanoutC()).to(fanoutExchange());
    }

    //------topic主题模式
    @Bean
    public Queue topicAQueue(){
        return new Queue("topicA");
    }
    @Bean
    public Queue topicBQueue(){
        return new Queue("topicB");
    }
    @Bean
    public Queue topicCQueue(){
        return new Queue("topicC");
    }
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }
    @Bean
    public Binding topicABinding(){
        return BindingBuilder.bind(topicAQueue()).to(topicExchange()).with("topic.msg");
    }
    @Bean
    public Binding topicBBinding(){
        return BindingBuilder.bind(topicBQueue()).to(topicExchange()).with("topic.#");
    }
    @Bean
    public Binding topicCBinding(){
        return BindingBuilder.bind(topicCQueue()).to(topicExchange()).with("topic.*.c");
    }

}