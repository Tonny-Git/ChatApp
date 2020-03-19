package com.example.demo.services;

import com.example.demo.entities.Channel;
import com.example.demo.repositories.ChannelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {
    @Autowired
    private ChannelRepo channelRepo;

    public List<Channel> findAllChannels() {
        List<Channel> channels = (List<Channel>) channelRepo.findAll();



        /*
        users.forEach(user -> {
            List<Channel> channels = channelRepo.findAllByUser(user.getId());
            user.setChannels(channels);
        });
        */

        return channels;
    }

    public Channel findOneChannel(int id) {
        Channel channel = channelRepo.findById(id);
        if (channel == null) return null;

        /*
        List<Channel> pets = channelRepo.findAllByUser(id); // use the same ID as the owner when we ask for the pets
        owner.setPets(pets);
        */

        return channel;
    }
}

