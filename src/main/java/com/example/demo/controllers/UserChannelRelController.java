package com.example.demo.controllers;

import com.example.demo.entities.UserChannelRel;
import com.example.demo.services.UserChannelRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class UserChannelRelController {
    @Autowired
    private UserChannelRelService userChannelRelService;

    @Transactional
    @DeleteMapping("/relation")
    public void deleteRelation(@RequestBody UserChannelRel userChannelRel) {
        userChannelRelService.deleteRelation(userChannelRel.getUserId(), userChannelRel.getChannelId());
    }
}
