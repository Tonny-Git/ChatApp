package com.example.demo.services;

import com.example.demo.entities.UserChannelRel;
import com.example.demo.repositories.UserChannelRelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserChannelRelService {
    @Autowired
    UserChannelRelRepo userChannelRelRepo;

    public void deleteRelation(int userId, int channelId) {
        userChannelRelRepo.deleteByUserIdAndChannelId(userId, channelId);
    }
}
