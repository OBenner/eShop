package ru.eshop.service;

import ru.eshop.model.Cart;
import ru.eshop.model.CartItem;

/**
 * The interface Cart item service.
 */
public interface CartItemService {
    /**
     * Add cart item.
     *
     * @param cartItem the cart item
     */
    void addCartItem(CartItem cartItem);

    /**
     * Remove cart item.
     *
     * @param cartItem the cart item
     */
    void removeCartItem(CartItem cartItem);

    /**
     * Remove all cart items.
     *
     * @param cart the cart
     */
    void removeAllCartItems(Cart cart);

    /**
     * Gets cart item by product id.
     *
     * @param productId the product id
     * @return the cart item by product id
     */
    CartItem getCartItemByProductId(int productId);
}
