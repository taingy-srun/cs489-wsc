package edu.miu.cs489.wsc.service;

import edu.miu.cs489.wsc.model.User;

public interface UserService {

    User login(String username, String password);
}
