package net.vijedi.messaging.jms;

import net.vijedi.messages.StatUpdateMessage;
import net.vijedi.messaging.common.EventSender;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Topic;

/**
 * Author: Tejus Parikh
 * Date: 1/4/11 11:26 AM
 */
public class JmsEventSender implements EventSender<StatUpdateMessage> {

    private static final Log log = LogFactory.getLog(JmsEventSender.class);

    private JmsTemplate template;
    private Topic topic;

    @Override
    public void send(StatUpdateMessage message) {
        template.convertAndSend(topic, message);
    }

    public void setTemplate(JmsTemplate template) {
        this.template = template;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
