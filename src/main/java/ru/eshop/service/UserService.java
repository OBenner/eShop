package ru.eshop.service;

import ru.eshop.model.BillingAddress;
import ru.eshop.model.User;
import ru.eshop.model.ShippingAddress;

import java.io.IOException;
import java.util.List;

/**
 * The interface User service.
 */
public interface UserService {

    /**
     * Add user user.
     *
     * @param user the user
     * @return the user
     */
    User addUser(User user);

    /**
     * Gets user by id.
     *
     * @param customerId the customer id
     * @return the user by id
     */
    User getUserById(Long customerId);

    /**
     * Gets all users.
     *
     * @return the all users
     */
    List<User> getAllUsers();

    /**
     * Delete user.
     *
     * @param user the user
     */
    void   deleteUser(User user);

}
