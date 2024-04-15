package edu.miu.cs489.wsc.dto;

import edu.miu.cs489.wsc.model.Role;

public record UserDTO(Integer userId, String username, Role role) {
}
