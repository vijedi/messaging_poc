package net.vijedi.messaging.rabbit;

import net.vijedi.messages.StatUpdateMessage;
import net.vijedi.messaging.common.EventSender;
import org.springframework.amqp.core.AmqpTemplate;

/**
 * Author: Tejus Parikh
 * Date: 1/5/11 9:28 AM
 */
public class AmqpEventSender implements EventSender<StatUpdateMessage> {
    private AmqpTemplate template;

    @Override
    public void send(StatUpdateMessage message) {
        template.convertAndSend(message);
    }

    public void setTemplate(AmqpTemplate template) {
        this.template = template;
    }
}
