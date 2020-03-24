package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.entities.UserChannel;
import com.example.demo.repositories.UserChannelRepo;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserChannelRepo userChannelRepo;

    //@Autowired
    //private FriendRepo friendRepo;

    public List<User> findAllUsers() {
        List<User> users = (List<User>) userRepo.findAll();

        return users;
    }

    public User findOneUser(int id) {
        User user = userRepo.findById(id);
        if (user == null) return null;

        // Load user channels
        //List<UserChannel> userChannels = userChannelRepo.findByUserId(user.getId());
        //user.setUserChannels(userChannels);


        return user;
    }

    public User createNewUser(User user) {
        return userRepo.save(user);
    }

    public boolean login(String username, String password) {
        List<User> users = (List<User>) userRepo.findAll();

        /*
        users.forEach(usr->{
            if (usr.getUserName().equalsIgnoreCase(username) &&
               usr.getPassword().equals(password)) {
                user = usr;
           }
        });


        if (user == null)
            return false;
        else
            return true;

         */

        return true;
    }

}
