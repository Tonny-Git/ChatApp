package com.example.demo.services;

import com.example.demo.configs.MyUserDetailsService;
import com.example.demo.entities.User;
import com.example.demo.entities.UserChannel;
import com.example.demo.repositories.UserChannelRepo;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

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

    //Gammal kåd ta bort eller ändra
    public User login (String username, String password){
        User user = null;

        try {
            user = userRepo.findAllByUsernameAndPassword(username, password);
            System.out.println(user.getLastName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    //Nya login metod
    public User findCurrentUser() {
        // the login session is stored between page reloads,
        // and we can access the current authenticated user with this
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepo.findByUsername(username);
    }

    //Nya register metod
    public User registerUser(User user) {
        return myUserDetailsService.addUser(user.getUsername(), user.getPassword(), user.getEmail(), user.getFirstName(), user.getLastName());
    }

}
