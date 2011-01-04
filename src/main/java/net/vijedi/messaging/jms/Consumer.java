package net.vijedi.messaging.jms;


import net.vijedi.messages.StatUpdateMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;

/**
 * Author: Tejus Parikh
 * Date: 1/4/11 1:01 PM
 */
public class Consumer implements javax.jms.MessageListener {

    private static final Log log = LogFactory.getLog(Consumer.class);

    private MessageConverter messageConverter;
    private String instanceId;

    @Override
    public void onMessage(Message message) {

        try {
            StatUpdateMessage sum = (StatUpdateMessage) messageConverter.fromMessage(message);
            if(log.isInfoEnabled()) {log.info("Received: " + sum); }
        } catch (JMSException e) {
            log.error("Could not parse message", e);
        }

    }
    
    public void setMessageConverter(MessageConverter messageConverter) {
        this.messageConverter = messageConverter;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }
}
