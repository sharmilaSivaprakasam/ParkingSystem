package com.webapp.parkingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.parkingsystem.domain.User;
import com.webapp.parkingsystem.service.UserService;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public void signUp(@RequestBody User userDetails) {
        userService.signUp(userDetails);
    }

    @PostMapping("/login")
    public void login(@RequestBody User userDetails) {
        userService.login(userDetails);
    }
}
