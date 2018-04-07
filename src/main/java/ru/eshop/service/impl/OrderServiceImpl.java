package ru.eshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eshop.dao.CustomerOrderDao;
import ru.eshop.dao.OrderDao;
import ru.eshop.dao.UserDao;
import ru.eshop.model.*;
import ru.eshop.service.OrderService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Transactional
    public OrderInfo getOrderInfoByOrderId(Long orderId) {
        CustomerOrder customerOrder = orderDao.getOrderByOrderId(orderId);
        OrderInfo orderInfo = customerOrder.getOrderInfo();
        return orderInfo;
    }

    @Transactional
    public CustomerOrder createOrder(String email) {
        CustomerOrder customerOrder = new CustomerOrder();
        User user = userDao.getUserByEmail(email);
        Cart cart = user.getCart();


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
        CustomerOrder order = new CustomerOrder(customerOrderDao.update(customerOrder));
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCustomerOrder(order);
        orderInfo.setOrderCondition("Create");
        OrderInfo info = orderDao.createOrderInfo(orderInfo);
        return order;
    }

    @Transactional
    public List<CustomerOrder> getAllUserOrders(String email) {
        User user = userDao.getUserByEmail(email);
        return user.getOrders();
    }

    @Transactional
    public List<OrderInfo> getNewCustomerOrderInInfo() {
        return orderDao.getNewCustomerOrder();
    }
}
