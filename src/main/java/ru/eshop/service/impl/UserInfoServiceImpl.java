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

    @Transactional
    public CustomerOrder createOrder(String email) {
        CustomerOrder customerOrder = new CustomerOrder();
        User user = userDao.getUserByEmail(email);
        Cart cart = user.getCart();
//        Cart cart = cartDao.findById(cartId);
//        User user = cart.getUser();
        customerOrder.setUser(user);


        List<OrderItem> orderItems = new ArrayList<OrderItem>();

        for (CartItem item : user.getCart().getItems()) {
            orderItems.add(orderDao.createOrderItem(item));
        }
        Float total = 0.0F;
        for (OrderItem orderItem : orderItems) {
            orderItem.setCustomerOrder(customerOrder);
            total += orderItem.getProduct().getProductPrice() * orderItem.getQuantity();
        }
        customerOrder.setItems(orderItems);


        customerOrder.setBillingAddress(user.getBillingAddress().get(0));
        customerOrder.setPaymentInfo(user.getPaymentInfo().get(0));
        customerOrder.setShippingAddress(user.getShippingAddress().get(0));
        customerOrder.setTotal(total);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd  'at' HH:mm:ss ");
        customerOrder.setDate(dateFormat.format(new Date()));


        cart.getItems().clear();

        return new CustomerOrder(customerOrderDao.update(customerOrder));
    }

    public List<CustomerOrder> getAllUserOrders(String email) {
        User user = userDao.getUserByEmail(email);
        return user.getOrders();
    }


    public User updateBillingAddress(BillingAddress billingAddress) {
        return null;
    }
}
