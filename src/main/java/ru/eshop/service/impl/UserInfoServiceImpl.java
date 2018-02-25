package ru.eshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eshop.dao.UserDao;
import ru.eshop.model.BillingAddress;
import ru.eshop.model.PaymentInfo;
import ru.eshop.model.ShippingAddress;
import ru.eshop.model.User;
import ru.eshop.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public User getUserInfo(String email) {
        return new User(userDao.getUserByEmail(email));
    }

    @Transactional
    public User addPaymentInfo(String email, PaymentInfo paymentInfo) {
        User user = userDao.getUserByEmail(email);
        paymentInfo.setUser(user);
        user.getPaymentInfo().add(paymentInfo);
        return new User(userDao.createUser(user));
    }

    public User updatePaymentInfo(PaymentInfo paymentInfo) {
        return null;
    }

    @Transactional
    public User addShippingAddress(String email, ShippingAddress shippingAddress) {
        User user = userDao.getUserByEmail(email);
        shippingAddress.setUser(user);
        user.getShippingAddress().add(shippingAddress);
        return new User(userDao.createUser(user));
    }

    public User updateShippingAddress(ShippingAddress shippingAddress) {
        return null;
    }

    @Transactional
    public User addBillingAddress(String email, BillingAddress billingAddress) {
        User user = userDao.getUserByEmail(email);
        billingAddress.setUser(user);
        user.getBillingAddress().add(billingAddress);
        return new User(userDao.createUser(user));
    }

    public User updateBillingAddress(BillingAddress billingAddress) {
        return null;
    }
}
