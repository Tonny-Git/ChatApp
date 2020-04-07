package com.example.demo.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "channels")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    public Channel(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    @Transient
    public String action;

    public Channel() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "channel")
    //private Set<UserChannel> userChannels;
    /*
    public Object[] getUserChannels (){
        return userChannels.toArray();
    }*/
}
