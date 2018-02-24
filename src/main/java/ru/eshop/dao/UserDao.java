package ru.eshop.dao;

import ru.eshop.model.User;

import java.util.List;

public interface UserDao {
    User createUser(User user);

    User getUserById(Long customerId);

    List<User> getAllUsers();

    User getUserByEmail(String username);
}
