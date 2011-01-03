package net.vijedi.messaging.rabbit;

import net.vijedi.messages.StatUpdateMessage;

/**
 * Author: Tejus Parikh
 * Date: 1/3/11 3:38 PM
 */
public class StatMessageUpdateHandler {
    public void handleMessage(StatUpdateMessage message) {
        System.out.println("Received: " + message);
    }
}
