package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getOneUser(@PathVariable int id) {
        return userService.findOneUser(id);
    }

    @PostMapping("/auth/register")
    public User createNewUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/users/login")
    public  User loginUser(@RequestBody User user) {
        return userService.login(user.getUsername(), user.getPassword());
    }
}
