package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.websocket.OnError;
import java.util.HashSet;
import java.util.List;
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
    private String firstname;
    private String lastname;
    boolean isactive;

    /* we will use it later
    @Transient
    public List<Channel> userChannels;
    */


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
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

    public User(){}
    public User(int id, String username, String password, String email, String firstname, String lastname, boolean isactive) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.isactive = isactive;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public boolean isIsactive() {
        return isactive;
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
