package edu.miu.cs489.wsc.controller;

import edu.miu.cs489.wsc.dto.UserCreationDTO;
import edu.miu.cs489.wsc.dto.UserDTO;
import edu.miu.cs489.wsc.model.User;
import edu.miu.cs489.wsc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<UserDTO> login(String username, String password) {
        User user = service.login(username, password);
        if (user == null) {
            return new ResponseEntity("Invalid credentials!", HttpStatus.UNAUTHORIZED);
        }
        return ResponseEntity.ok(user.toUserDTO());
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserCreationDTO userCreationDTO) {
        User user = service.create(userCreationDTO.toUser());
        return ResponseEntity.ok(user.toUserDTO());
    }
}
