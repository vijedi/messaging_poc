package net.vijedi.messaging.common;

import net.vijedi.messages.StatUpdateMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Author: Tejus Parikh
 * Date: 1/5/11 9:10 AM
 */
public class EventProducer {

    private static final Log log = LogFactory.getLog(EventProducer.class);

    /**
     * Default time between message sends. Set to 10 seconds
     * to prevent excessive noise.
     */
    private final static long MESSAGE_FREQUENCY = 10000;
    
    private EventSender<StatUpdateMessage> eventSender;
    private int sequence;
    private String producerId;
    
    public void produce() {
        
        while(true) {
            // Create a simple message
            StatUpdateMessage message = new StatUpdateMessage(
                    producerId,
                    sequence,
                    ++sequence,
                    "testing message"
            );

            // Send to the abstracted event sender
            eventSender.send(message);
            
            if (log.isInfoEnabled()) {
                log.info("Sent message: " + message);
            }

            try {
                Thread.sleep(MESSAGE_FREQUENCY);
            } catch (InterruptedException e) {
                log.warn("You bothered me while I was napping!");
            }
        }

    }

    public void setEventSender(EventSender<StatUpdateMessage> eventSender) {
        this.eventSender = eventSender;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }
}
