package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "userxchannel")
public class UserChannel {

    @EmbeddedId
    private UserChannelKey id;
    private boolean admin;

    public UserChannel() {

    }

    public UserChannel(User user, Channel channel, boolean admin) {
        this.user = user;
        this.channel = channel;
        this.admin = admin;
    }

    @ManyToOne (fetch = FetchType.LAZY)
    @MapsId("member_id")
    @JoinColumn(name = "member_id")
    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("channel_id")
    @JoinColumn(name = "channel_id")
    Channel channel;

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isAdmin() {
        return admin;
    }
}
