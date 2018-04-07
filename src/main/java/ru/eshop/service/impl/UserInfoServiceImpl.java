package ru.eshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eshop.dao.*;
import ru.eshop.model.*;
import ru.eshop.service.CartService;
import ru.eshop.service.UserInfoService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type User info service.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private ShippingAddressDao shippingAddressDao;

    @Autowired
    private PaymentInfoDao paymentInfoDao;

    @Autowired
    private BillingAddressDao billingAddressDao;
    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartDao cartDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CartService cartService;

    @Transactional
    public User getUserInfo(String email) {
        return new User(userDao.getUserByEmail(email));
    }

    @Transactional
    public User addPaymentInfo(String email, PaymentInfo paymentInfo) {
        User user = userDao.getUserByEmail(email);
        paymentInfo.setUser(user);
        user.getPaymentInfo().add(paymentInfo);
        paymentInfoDao.create(paymentInfo);
        return userDao.createUser(user);
    }

    public User updatePaymentInfo(PaymentInfo paymentInfo) {
        return null;
    }

    @Transactional
    public User addShippingAddress(String email, ShippingAddress shippingAddress) {
        User user = userDao.getUserByEmail(email);
        shippingAddress.setUser(user);
        user.getShippingAddress().add(shippingAddress);
        shippingAddressDao.create(shippingAddress);
        return userDao.createUser(user);
    }

    public User updateShippingAddress(ShippingAddress shippingAddress) {

        return null;
    }

    @Transactional
    public User addBillingAddress(String email, BillingAddress billingAddress) {
        User user = userDao.getUserByEmail(email);
        billingAddress.setUser(user);
        user.getBillingAddress().add(billingAddress);
        billingAddressDao.create(billingAddress);
        return userDao.createUser(user);
    }




    public User updateBillingAddress(String email,Long billingAddressOldId, BillingAddress billingAddressNew) {
        BillingAddress billingAddress= billingAddressDao.getBillingAddressById(billingAddressOldId);
        User user = billingAddress.getUser();
        billingAddress = new BillingAddress(billingAddressNew);
        billingAddress.setUser(user);
        return user;
    }



}
