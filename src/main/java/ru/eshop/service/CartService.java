package ru.eshop.service;

import ru.eshop.model.Cart;

public interface CartService {
    Cart getCartById(int cartId);

    void update(Cart cart);
}
