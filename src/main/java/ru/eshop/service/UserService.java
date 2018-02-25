package ru.eshop.service;

import ru.eshop.model.BillingAddress;
import ru.eshop.model.User;
import ru.eshop.model.ShippingAddress;

import java.io.IOException;
import java.util.List;

public interface UserService {

    User addUser(User user);

    User getUserById(Long customerId);

    List<User> getAllUsers();

    void   deleteUser(User user);

}
