package edu.miu.cs489.wsc.service.impl;

import edu.miu.cs489.wsc.model.User;
import edu.miu.cs489.wsc.repository.UserRepository;
import edu.miu.cs489.wsc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User login(String username, String password) {
        return repository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }
}
