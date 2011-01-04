package net.vijedi.messaging.jms;

import net.vijedi.messages.StatUpdateMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

/**
 * Author: Tejus Parikh
 * Date: 1/4/11 11:26 AM
 */
public class Producer {

    private static final Log log = LogFactory.getLog(Producer.class);

    private JmsTemplate template;
    private String instanceId;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-amq.xml");
        Producer producer = context.getBean(Producer.class);
        producer.produce();
    }

    private void produce() {
        int sequence = 0;
        StatUpdateMessage message = new StatUpdateMessage(instanceId, sequence, ++sequence, "random text");

        if(log.isInfoEnabled()) {log.info("Sending message: " + message);}

        template.convertAndSend(message);
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public void setTemplate(JmsTemplate template) {
        this.template = template;
    }
}
