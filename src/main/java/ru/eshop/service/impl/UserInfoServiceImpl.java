package ru.eshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eshop.dao.*;
import ru.eshop.model.*;
import ru.eshop.service.UserInfoService;

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

    @Transactional
    public CustomerOrder createOrder(String email, Long cartId) {
        User user = userDao.getUserByEmail(email);
        CustomerOrder customerOrder = (CustomerOrder) user.getOrders();
        customerOrder.setBillingAddress((BillingAddress) user.getBillingAddress());
        customerOrder.setPaymentInfo((PaymentInfo) user.getPaymentInfo());
        customerOrder.setShippingAddress((ShippingAddress) user.getShippingAddress());
        customerOrder.setCart(cartDao.findById(cartId));
        return new CustomerOrder(customerOrderDao.update(customerOrder)) ;
    }


    public User updateBillingAddress(BillingAddress billingAddress) {
        return null;
    }
}
