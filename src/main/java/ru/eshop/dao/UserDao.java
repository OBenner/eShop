package ru.eshop.dao;

import ru.eshop.model.User;

import java.util.List;

/**
 * The interface User dao.
 */
public interface UserDao {


    /**
     * Create user user.
     *
     * @param user the user
     * @return the user
     */
    User createUser(User user);

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
     * Gets user by email.
     *
     * @param username the username
     * @return the user by email
     */
    User getUserByEmail(String username);

    /**
     * Delete user string.
     *
     * @param user the user
     * @return the string
     */
    String deleteUser(User user);
}
