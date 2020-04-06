package com.example.demo.services;

import com.example.demo.configs.MyUserDetailsService;
import com.example.demo.entities.Channel;
import com.example.demo.entities.User;
import com.example.demo.entities.UserChannelRel;
import com.example.demo.repositories.ChannelRepo;
import com.example.demo.repositories.UserChannelRelRepo;
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
    private UserChannelRelRepo userChannelRelRepo;

    @Autowired
    private SocketService socketService;

    @Autowired
    private ChannelRepo channelRepo;

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
            System.out.println(user.getLastName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
    public User findCurrentUser() {
        // the login session is stored between page reloads,
        // and we can access the current authenticated user with this
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return addChannelToCurrentUser(userRepo.findByUsername(username));
    }
    public User registerUser(User user) {
        return myUserDetailsService.addUser(user.getUsername(), user.getPassword(), user.getEmail(), user.getFirstName(), user.getLastName());
    }

    //Needs to retrieve admin also later.
    public User addChannelToCurrentUser(User user) {
        List<UserChannelRel> foundUserChannels = userChannelRelRepo.findByUserId(user.getId());
        List<Channel> channels = null;
        for (UserChannelRel foundUserChannel : foundUserChannels) {
            channels.add(channelRepo.findById(foundUserChannel.getChannelId()));
        }
        user.setUserChannels(channels);
        return user;
    }

}
