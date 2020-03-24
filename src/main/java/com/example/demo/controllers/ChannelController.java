package com.example.demo.controllers;

import com.example.demo.entities.Channel;
import com.example.demo.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ChannelController {

    @Autowired
    ChannelService channelService;


    @GetMapping("/channels")
    public List<Channel> getAllChannels() {
        return channelService.findAllChannels();
    }

    @GetMapping("/channels/{id}")
    public Channel getOneChannel(@PathVariable int id) {
        return channelService.findOneChannel(id);
    }
}
