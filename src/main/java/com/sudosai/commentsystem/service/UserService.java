package com.sudosai.commentsystem.service;

import com.sudosai.commentsystem.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User saveUser(User user);
}
