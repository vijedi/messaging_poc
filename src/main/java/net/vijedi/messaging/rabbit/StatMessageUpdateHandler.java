package net.vijedi.messaging.rabbit;

import net.vijedi.messages.StatUpdateMessage;

/**
 * Author: Tejus Parikh
 * Date: 1/3/11 3:38 PM
 */
public class StatMessageUpdateHandler {
    private String instanceId;

    public void handleMessage(StatUpdateMessage message) {
        if(instanceId.equals(message.getSenderId())) {
            System.out.println("Dropping: " + message);
        } else {
            System.out.println("Received: " + message);
        }
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }
}
