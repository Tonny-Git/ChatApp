package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    private String first_name;
    private String last_name;
    boolean is_active;

    /* we will use it later
    @Transient
    public List<Channel> userChannels;
    */


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "userfriends",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "friend_id") })
    @JsonIgnoreProperties("friends")
    private Set<User> friends = new HashSet<>();

    public Object[] getFriends(){
        return friends.toArray();
    }

    /*
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @JsonIgnoreProperties("userChannels")
    private Set<UserChannel> userChannels = new HashSet<>();

    public Object[] getUserChannels() {return userChannels.toArray();}

    public void setUserChannels(List<UserChannel> userChannels) {
        this.userChannels = new HashSet<> (userChannels);
    }
*/
    @Transient
    public String action;

    public User(){}
<<<<<<< HEAD
    public User(int id, String username, String password, String email, String first_name, String last_name, boolean is_active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.is_active = is_active;
=======

    public User(String username, String password, String email, String firstname, String lastname, boolean isactive) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstname;
        this.lastName = lastname;
        this.isActive = isactive;
>>>>>>> DEV

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setIsActive(boolean isActive) {
        this.is_active = isActive;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public boolean isIsActive() {
        return is_active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User that = (User) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
