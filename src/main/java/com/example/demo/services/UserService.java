package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<User> findAllUsers(){
        List<User> users = (List<User>) userRepo.findAll();

        /*
        users.forEach(user -> {
            List<Channel> channels = channelRepo.findAllByUser(user.getId());
            user.setChannels(channels);
        });
        */

        return users;
    }

    public User findOneUser(int id) {
        User user = userRepo.findById(id);
        if(user == null) return null;

        /*
        List<Channel> pets = channelRepo.findAllByUser(id); // use the same ID as the owner when we ask for the pets
        owner.setPets(pets);
        */

        return user;
    }

    public User createNewUser (User user){
        User dbUser = null;
        try {
            dbUser = userRepo.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbUser;
    }

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

}
