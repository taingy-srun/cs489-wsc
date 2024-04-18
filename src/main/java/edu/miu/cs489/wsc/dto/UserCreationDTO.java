package edu.miu.cs489.wsc.dto;

import edu.miu.cs489.wsc.model.Role;
import edu.miu.cs489.wsc.model.User;

public record UserCreationDTO(String username, String password, Integer roleId) {

    public User toUser() {
        return new User(username, password, new Role(roleId, null));
    }
}
