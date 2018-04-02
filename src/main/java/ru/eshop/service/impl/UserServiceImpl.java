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

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    RoleDao roleDao;

    @Autowired
    PasswordEncoder passwordEncoder;


    // сделать проверку на существующий в базе email
    @Transactional
    public User addUser(User user) {
        User existemail = userDao.getUserByEmail(user.getName());
        if (existemail == null || existemail.getName().equals(user.getName()) || existemail.getEmail().equals(user.getEmail()))
        {
            System.out.println("User Exist");
            return null;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(roleDao.findRoleByName("USER"));

        return new User(userDao.createUser(user));
    }

    @Transactional
    public User getUserById(Long customerId) {

        return userDao.getUserById(customerId);
    }

    @Transactional
    public List<User> getAllUsers() {

        return userDao.getAllUsers();
    }

    @Transactional
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

//    public User doesUserExist(String email) throws UserNotFoundException {
//        List<User> users = (List<User>) userDAO.findByEmail(email);
//        if(users.size() == 0) {
//            throw new UserNotFoundException("User does not exist in the database.");
//        }
//        return users.get(0);
//    }
}
