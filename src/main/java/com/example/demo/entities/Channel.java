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
    private int admin_id;

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public Channel(Integer id, String title, Integer admin_id) {
        this.id = id;
        this.title = title;
        this.admin_id = admin_id;
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

}

