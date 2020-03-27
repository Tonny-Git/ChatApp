package com.example.demo.entities;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserChannelKey implements Serializable {

    @Column(name = "member_id")
    int member_id;

    @Column(name = "channel_id")
    int channel_id;

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public int getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(int channel_id) {
        this.channel_id = channel_id;
    }

    public UserChannelKey(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserChannelKey)) return false;
        UserChannelKey that = (UserChannelKey) o;
        return getMember_id() == that.getMember_id() &&
                getChannel_id() == that.getChannel_id();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMember_id(), getChannel_id());
    }

    @Override
    public String toString() {
        return "Member: " + member_id + " (" + channel_id + ")";
    }
}