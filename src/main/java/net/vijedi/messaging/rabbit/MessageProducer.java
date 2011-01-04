package net.vijedi.messaging.rabbit;

import net.vijedi.messages.StatUpdateMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: Tejus Parikh
 * Date: 12/29/10 3:31 PM
 *
 * Class to create and send messages.
 */
public class MessageProducer {

    private static final Log log = LogFactory.getLog(MessageProducer.class);
    
    /**
     * Default time between message sends. Set to 10 seconds
     * to prevent excessive noise.
     */
    private final static long MESSAGE_FREQUENCY = 10000;
    private String producerId;
    private AmqpTemplate template;
    private int sequence = 0;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-rabbit.xml");
        MessageProducer producer = context.getBean(MessageProducer.class);
        producer.produce();
    }

    /**
     * Produces a message then places it on the exchange
     */
    private void produce() {

        // Loop until the process has been killed
        while (true) {
            
            // Create a simple message
            StatUpdateMessage message = new StatUpdateMessage(
                    producerId,
                    sequence,
                    ++sequence,
                    "testing message"
            );
            
            // Spring AMQP helper method that uses the 
            // configured message converter to serialize 
            // the message
            template.convertAndSend(message);

            if(log.isInfoEnabled()) { log.info("Sent message: " + message);}

            try {
                Thread.sleep(MESSAGE_FREQUENCY);
            } catch (InterruptedException e) {
                 log.warn("You bothered me while I was napping!");
            }
        }
    }

    /**
     * This class uses the AMQP Template to send messages
     * @param template
     */
    public void setTemplate(AmqpTemplate template) {
        this.template = template;
    }

    /**
     * The producerId is tied to the instance and is used by
     * the consumer to ignore messages coming from itself
     * 
     * @param producerId
     */
    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }
}
