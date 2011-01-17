package net.vijedi.messaging.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: Tejus Parikh
 * Date: 1/5/11 10:46 AM
 */
public class AmqpExample {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-rabbit.xml");
        EventProducer producer = context.getBean(EventProducer.class);
        producer.produce();
    }
}
