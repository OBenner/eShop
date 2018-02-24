package ru.eshop.dao;

import ru.eshop.model.Cart;

import java.io.IOException;

/**
 * Created by omyag on 08.11.2017.
 */
public interface CartDao {

    Cart getCartById(int cartId);

    Cart update(Cart cart);

    Cart validate(int cartId) throws IOException;
}
