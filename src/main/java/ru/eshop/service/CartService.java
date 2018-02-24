package ru.eshop.service;

import ru.eshop.model.Cart;

public interface CartService {
    Cart removeProductFromCart(String userEmail, Long itemId);
    Cart getCart(String userEmail);
    Cart addProductToCart(String userEmail, Long itemId, Integer quantity);
    Cart update(Long itemId, Integer quantity);

}
