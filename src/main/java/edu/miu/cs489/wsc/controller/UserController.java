package edu.miu.cs489.wsc.controller;

import edu.miu.cs489.wsc.model.User;
import edu.miu.cs489.wsc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public String login(String username, String password) {
        User user = service.login(username, password);
        if (user == null) {
            return "Invalid credentials";
        }
        return "Logged in successfully!";
    }
}
