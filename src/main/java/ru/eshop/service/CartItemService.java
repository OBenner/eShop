package ru.eshop.service;

import ru.eshop.model.Cart;
import ru.eshop.model.CartItem;

public interface CartItemService {
    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);
}
