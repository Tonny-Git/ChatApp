package com.example.demo.entities;

import javafx.scene.text.Text;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

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

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private String message_date;
    private String message;

    private boolean read;
    private int sender_id;

    @Column(nullable = true)
    private Integer channel_id;

    private int receiver_id;

    public Message() {

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

    public void setMessage_date(String message_date) {
        this.message_date = message_date;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public void setChannel_id(Integer channel_id) {
        this.channel_id = channel_id;
    }

    public void setReceiver_id(int receiver_id) {
        this.receiver_id = receiver_id;
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

    public String getMessage_date() {
        return message_date;
    }

    public String getMessage() {
        return message;
    }

    public boolean isRead() {
        return read;
    }

    public int getSender_id() {
        return sender_id;
    }

    public Integer getChannel_id() {
        return channel_id;
    }

    public int getReceiver_id() {
        return receiver_id;
    }


}
