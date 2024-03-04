package com.sample.elk.services;

import java.util.List;
import com.sample.elk.model.User;

public interface UserServiceI {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
