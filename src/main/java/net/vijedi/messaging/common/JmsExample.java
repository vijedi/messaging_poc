package net.vijedi.messaging.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: Tejus Parikh
 * Date: 1/5/11 10:47 AM
 */
public class JmsExample {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-amq.xml");
        EventProducer producer = context.getBean(EventProducer.class);
        producer.produce();
    }
}
