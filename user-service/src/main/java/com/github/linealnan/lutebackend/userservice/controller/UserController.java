package com.github.linealnan.lutebackend.userservice.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.logging.Logger;
import org.springframework.core.env.Environment;

@RestController
@RequestMapping("/")
public class UserController {

    Logger logger = java.util.logging.Logger.getLogger(UserController.class.getName());

    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String home() {
        String home = "User-Service running at port: " + env.getProperty("local.server.port");
        logger.info(home);
        return home;
    }
}
