package ru.eshop.dao;

import ru.eshop.model.Cart;

import java.io.IOException;

/**
 * Created by omyag on 08.11.2017.
 */
public interface CartDao {

    /**
     * Update cart.
     *
     * @param cart the cart
     * @return the cart
     */
    Cart update(Cart cart);

    /**
     * Find by id cart.
     *
     * @param id the id
     * @return the cart
     */
    Cart findById(Long id);


    /**
     * Remove cart items cart.
     *
     * @param cart the cart
     * @return the cart
     */
    Cart removeCartItems(Cart cart);
}
