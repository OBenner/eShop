package ru.eshop.service;

import ru.eshop.model.Cart;

/**
 * The interface Cart service.
 */
public interface CartService {
    /**
     * Remove product from cart cart.
     *
     * @param userEmail the user email
     * @param itemId    the item id
     * @return the cart
     */
    Cart removeProductFromCart(String userEmail, Long itemId);

    /**
     * Gets cart.
     *
     * @param userEmail the user email
     * @return the cart
     */
    Cart getCart(String userEmail);

    /**
     * Add product to cart cart.
     *
     * @param userEmail the user email
     * @param itemId    the item id
     * @param quantity  the quantity
     * @return the cart
     */
    Cart addProductToCart(String userEmail, Long itemId, Integer quantity);

    /**
     * Update cart.
     *
     * @param itemId   the item id
     * @param quantity the quantity
     * @return the cart
     */
    Cart update(Long itemId, Integer quantity);

    /**
     * Gets cart by id.
     *
     * @param id the id
     * @return the cart by id
     */
    Cart getCartById(Long id);

}
