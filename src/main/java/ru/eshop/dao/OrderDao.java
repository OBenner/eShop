package ru.eshop.dao;

import ru.eshop.model.CartItem;
import ru.eshop.model.OrderItem;

public interface OrderDao {
    OrderItem createOrderItem(CartItem cartItem);
}
