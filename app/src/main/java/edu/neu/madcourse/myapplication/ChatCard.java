package edu.neu.madcourse.myapplication;

public class ChatCard {
    private String sender;
    private String receiver;
    private String sticker;
    private String time;

    public ChatCard(){}

    public ChatCard(String sender, String receiver, String sticker, String time) {
        this.sender = sender;
        this.receiver = receiver;
        this.sticker = sticker;
        this.time = time;
    }

    public String getSender() {
        return this.sender;
    }

    public String getReceiver() {
        return this.receiver;
    }

    public String getSticker() {
        return this.sticker;
    }

    public String getTime() {
        return this.time;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setSticker(String sticker) {
        this.sticker = sticker;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
