package ru.eshop.dao;

import ru.eshop.model.CartItem;
import ru.eshop.model.CustomerOrder;
import ru.eshop.model.OrderInfo;
import ru.eshop.model.OrderItem;

import java.util.List;

/**
 * The interface Order dao.
 */
public interface OrderDao {
    /**
     * Create order item order item.
     *
     * @param cartItem the cart item
     * @return the order item
     */
    OrderItem createOrderItem(CartItem cartItem);

    /**
     * Gets all user orders.
     *
     * @return the all user orders
     */
    List<CustomerOrder> getAllUserOrders();


    /**
     * Gets order info by order id.
     *
     * @return the order info by order id
     */
    CustomerOrder getOrderByOrderId(Long orderId);


    List<OrderInfo> getNewCustomerOrder();

    OrderInfo createOrderInfo(OrderInfo orderInfo);

}
