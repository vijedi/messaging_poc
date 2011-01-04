package net.vijedi.messaging.jms;

import com.google.gson.Gson;
import net.vijedi.messages.StatUpdateMessage;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Author: Tejus Parikh
 * Date: 1/4/11 2:56 PM
 */
public class StatMessageConverter implements MessageConverter {
    private Gson gson;

    public StatMessageConverter() {
        gson = new Gson();
    }

    @Override
    public Message toMessage(Object o, Session session) throws JMSException, MessageConversionException {
        String json = gson.toJson(o);
        return session.createTextMessage(json);
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        StatUpdateMessage sum = null;
        if(message instanceof TextMessage) {
            TextMessage tm = (TextMessage) message;
            sum = gson.fromJson(tm.getText(), StatUpdateMessage.class);
        } else {
            throw new MessageConversionException("Received message is not a text message");
        }
        return sum;
    }
}
