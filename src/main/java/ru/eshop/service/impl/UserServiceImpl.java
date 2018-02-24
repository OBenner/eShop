package ru.eshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eshop.dao.RoleDao;
import ru.eshop.dao.UserDao;
import ru.eshop.model.BillingAddress;
import ru.eshop.model.User;
import ru.eshop.model.ShippingAddress;
import ru.eshop.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    RoleDao roleDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(roleDao.findRoleByName("USER"));

        return new User(userDao.createUser(user));
    }

    public User getUserById(Long customerId) {

        return userDao.getUserById(customerId);
    }

    public List<User> getAllUsers() {

        return userDao.getAllUsers();
    }

    public User getUserInfo(String email) {
        return userDao.getUserByEmail(email);
    }

    public User addShippingAddress(String email, ShippingAddress shippingAddress) {
        User user = userDao.getUserByEmail(email);
        shippingAddress.setUser(user);
        user.getShippingAddress().add(shippingAddress);
        return new User(userDao.createUser(user));
    }

    public User addBillingAddress(BillingAddress billingAddress) {
        return null;
    }

}
