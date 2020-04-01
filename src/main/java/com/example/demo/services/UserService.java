package com.example.demo.services;

import com.example.demo.entities.User;
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

    @Autowired
    private SocketService socketService;

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

    public User createNewUser (User user){
        User dbUser = null;
        try {
            dbUser = userRepo.save(user);
            dbUser.action = "new-pet";
            socketService.sendToAll(dbUser, User.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dbUser;
    }

    public User login (String username, String password){
        User user = null;

        try {
            user = userRepo.findAllByUsernameAndPassword(username, password);
            System.out.println(user.getLast_name());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

}
