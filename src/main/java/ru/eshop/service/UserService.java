package ru.eshop.service;

import ru.eshop.model.BillingAddress;
import ru.eshop.model.User;
import ru.eshop.model.ShippingAddress;

import java.util.List;

public interface UserService {

    User addUser(User user);

    User getUserById(Long customerId);

    List<User> getAllUsers();

    User  getUserInfo(String email);

    User addShippingAddress(String email,ShippingAddress shippingAddress);

    User addBillingAddress(BillingAddress billingAddress);
}
