package com.example.demo.controllers;

import com.example.demo.entities.Message;
import com.example.demo.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class MessageController {

    @Autowired
    MessageService messageService;


    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        return messageService.findAllMessages();
    }

    @GetMapping("/messages/{id}")
    public Message getOneMessage(@PathVariable int id) {
        return messageService.findOneMessage(id);
    }

    @PostMapping("/messages")
    public Message sendOneMessage(@RequestBody Message message) {
        System.out.println("THIS IS AN TEST");
        System.out.println(message);
        System.out.println("THIS IS AN TEST");
        return messageService.postMessage(message);
    }
}
