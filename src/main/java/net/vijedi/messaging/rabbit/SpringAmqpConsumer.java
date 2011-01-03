package net.vijedi.messaging.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: Tejus Parikh
 * Date: 12/29/10 4:00 PM
 */
public class SpringAmqpConsumer {

    private RabbitTemplate template;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-rabbit.xml");
    }

}
