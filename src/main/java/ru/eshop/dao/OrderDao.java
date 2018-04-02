package ru.eshop.dao;

import ru.eshop.model.CartItem;
import ru.eshop.model.CustomerOrder;
import ru.eshop.model.OrderItem;

import java.util.List;

public interface OrderDao {
    OrderItem createOrderItem(CartItem cartItem);

    List<CustomerOrder> getAllUserOrders();
}
