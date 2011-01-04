package net.vijedi.messages;

/**
 * Author: Tejus Parikh
 * Date: 12/29/10 2:54 PM
 *
 * This is a simple statistics message used to communicate
 * the number of success and attempts.
 *
 * It includes an optional text message for any additional information
 */
public class StatUpdateMessage {
    private String senderId;
    private int trials;
    private int successes;
    private String textMessage;

    public StatUpdateMessage() {
        
    }

    public StatUpdateMessage(String senderId, int trials, int successes, String textMessage) {
        this.senderId = senderId;
        this.trials = trials;
        this.successes = successes;
        this.textMessage = textMessage;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public int getTrials() {
        return trials;
    }

    public void setTrials(int trials) {
        this.trials = trials;
    }

    public int getSuccesses() {
        return successes;
    }

    public void setSuccesses(int successes) {
        this.successes = successes;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    @Override
    public String toString() {
        return "StatUpdateMessage{" +
                "senderId='" + senderId + '\'' +
                ", trials=" + trials +
                ", successes=" + successes +
                ", textMessage='" + textMessage + '\'' +
                '}';
    }
}
