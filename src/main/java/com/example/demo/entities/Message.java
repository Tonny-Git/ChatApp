package com.example.demo.entities;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;


@Entity
@Table(name = "messages")
public class Message {

    @Transient
    private User sender;

    @Transient
    private User receiver;

    @Transient
    private Channel channel;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String messageDate;
    private String message;
    private boolean direct;
    private boolean read;
    private int senderId;

    //@Column(nullable = true)
    private int channelId;
    private int receiverId;

    @Transient
    public String action;

    public Message (){}

    public Message(String messageDate, String message, Boolean read, int senderId, int channelId, int receiverId, boolean direct) {
        this.messageDate = messageDate;
        this.message = message;
        this.read = read;
        this.senderId = senderId;
        this.channelId = channelId;
        this.receiverId = receiverId;
        this.direct = direct;
    }

    public Message(User sender, User receiver, Channel channel, int id, String message_date, String message,boolean direct, boolean read, int sender_id, Integer channel_id, int receiver_id) {
        this.sender = sender;
        this.receiver = receiver;
        this.channel = channel;
        this.id = id;
        this.messageDate = message_date;
        this.message = message;
        this.direct = direct ;
        this.read = read;
        this.senderId = sender_id;
        this.channelId = channel_id;
        this.receiverId = receiver_id;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public Channel getChannel() {
        return channel;
    }

    public int getId() {
        return id;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRead() {
        return read;
    }

    public int getSenderId() {
        return senderId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setDirect(boolean direct) {
        this.direct = direct;
    }

    public boolean isDirect() {
        return direct;
    }


}
