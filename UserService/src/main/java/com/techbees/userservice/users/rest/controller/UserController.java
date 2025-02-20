package com.techbees.userservice.users.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment environment;

    @GetMapping("/status")
    public String status() {
        return "Users service is up in port : "+environment.getProperty("local.server.port");
    }
}
