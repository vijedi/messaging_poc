package net.vijedi.messaging.common;

import net.vijedi.messages.StatUpdateMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Author: Tejus Parikh
 * Date: 1/3/11 3:38 PM
 *
 * This class is what processes received messages.
 * It is configured to work through Spring AMQP's
 * asynchronous messaging api.
 */
public class StatMessageEventHandler {

    private static final Log log = LogFactory.getLog(StatMessageEventHandler.class);

    private String instanceId;

    /**
     * Handle the incoming stat update message. In this case,
     * print to the log that we have received it.
     *
     * @param message
     */
    public void handleMessage(StatUpdateMessage message) {

        if(instanceId.equals(message.getSenderId())) {
            if(log.isInfoEnabled()) {log.info("Dropping: " + message);}
        } else {
            if(log.isInfoEnabled()) {log.info("Received: " + message);}
        }
    }

    /**
     * The instanceId is vm specific and used to determine
     * which messages have come from this host and
     * should be dropped.
     *
     * @param instanceId
     */
    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }
}
