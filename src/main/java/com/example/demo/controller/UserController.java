package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String newUser(@RequestBody User user) {
        return String.format("user %s created with id %d", user.getName(), userService.save(user));
    }

    @GetMapping("/user/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public User getUser(@PathVariable Integer userId) {
        return userService.findOne(userId);
    }

    @PostMapping("/user/update")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody User user) {
        User updatedUser =  userService.update(user);
        updatedUser.setSurname("surname updated");
        return updatedUser;
    }
}
