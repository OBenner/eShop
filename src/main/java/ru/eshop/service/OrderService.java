package ru.eshop.service;

import ru.eshop.model.CustomerOrder;
import ru.eshop.model.OrderInfo;

import java.util.List;

public interface OrderService {

    /**
     * Gets order info by order id.
     *
     * @param orderId the order id
     * @return the order info by order id
     */
    OrderInfo getOrderInfoByOrderId(Long orderId);

    /**
     * Create order customer order.
     *
     * @param email the email
     * @return the customer order
     */
    CustomerOrder createOrder(String email);

    /**
     * Gets all user orders.
     *
     * @param email the email
     * @return the all user orders
     */
    List<CustomerOrder> getAllUserOrders(String email);


    List<OrderInfo> getNewCustomerOrderInInfo();
}
