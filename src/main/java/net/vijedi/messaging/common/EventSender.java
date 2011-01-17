package net.vijedi.messaging.common;

/**
 * Author: Tejus Parikh
 * Date: 1/5/11 9:10 AM
 */
public interface EventSender<T> {

    void send(T message );
}
