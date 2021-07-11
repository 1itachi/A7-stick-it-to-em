package edu.neu.madcourse.myapplication;

public class ChatCard {
    private String sender;
    private String receiver;
    private String Sticker;
    private String time;

    public ChatCard(String sender, String receiver, String sticker, String time) {
        this.sender = sender;
        this.receiver = receiver;
        Sticker = sticker;
        this.time = time;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getSticker() {
        return Sticker;
    }

    public String getTime() {
        return time;
    }

}
