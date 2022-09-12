package com.example.service;

import com.example.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    void updateUser(User user, Long id);
    User getUserById(Long id);
    void deleteUserById(Long id);

}
