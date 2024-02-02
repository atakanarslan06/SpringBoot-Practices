package src.main.java.com.springexamp.rabbitmq.config;

import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.naming.Binding;
import java.util.Queue;

@Configuration
public class RabbitMqConfiguration {

    @Value("${sr.rabbit.queue.name}")
    private String queueName;

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    public Queue queue(){
        return new Queue(queueName);

    }
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchangeName);
    }
    @Bean
    Binding binding(final Queue queue, final DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(routingName);
    }

}
