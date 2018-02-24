package ru.eshop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eshop.dao.CartDao;
import ru.eshop.model.Cart;
import ru.eshop.service.CustomerOrderService;

import javax.persistence.EntityManager;
import java.io.IOException;

@Service
public class CartDaoImpl implements CartDao {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CustomerOrderService customerOrderService;

    public Cart getCartById(int cartId) {
//        Session session = sessionFactory.getCurrentSession();
//entityManager.
        return null;
    }

    public Cart update(Cart cart) {

        int cartId = cart.getCartId();
        double grandTotal = customerOrderService.getCustomerOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);

       return entityManager.merge(cart);
    }

    public Cart validate(int cartId) throws IOException {
        Cart cart = getCartById(cartId);
        if (cart == null || cart.getCartItems().size() == 0) {
            throw new IOException(cartId + "");
        }
        update(cart);
        return cart;
    }
}
