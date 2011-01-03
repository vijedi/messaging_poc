package net.vijedi.messaging.rabbit;

import net.vijedi.messages.StatUpdateMessage;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: Tejus Parikh
 * Date: 12/29/10 3:31 PM
 */
public class SpringAmqpProducer {

    private String producerId;
    private AmqpTemplate template;
    private int sequence = 0;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-rabbit.xml");
        SpringAmqpProducer producer = context.getBean(SpringAmqpProducer.class);
        producer.produce();
    }

    private void produce() {
        while (true) {
            StatUpdateMessage message = new StatUpdateMessage(
                    producerId,
                    sequence,
                    ++sequence,
                    "testing message"
            );
            template.convertAndSend(message);

            System.out.println("Sent message: " + message);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                 System.out.println(e.getMessage());
            }
        }
    }

    public void setTemplate(AmqpTemplate template) {
        this.template = template;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }
}
