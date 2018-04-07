package ru.eshop.dao.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eshop.dao.CartDao;
import ru.eshop.model.Cart;
import ru.eshop.model.CartItem;
import ru.eshop.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * The type Cart dao.
 */
@Service
public class CartDaoImpl implements CartDao {

    @Autowired
    private EntityManager entityManager;


    public Cart update(Cart cart) {

       return entityManager.merge(cart) ;
    }

    public Cart findById(Long id) {
        return entityManager.find(Cart.class,id);
    }



@Transactional
    public Cart removeCartItems(Cart cart){

        List<CartItem> cartItems = cart.getItems();

        for (CartItem item : cartItems){
            removeCartItem(item);
        }
        return entityManager.merge(cart);
    }

    /**
     * Remove cart item.
     *
     * @param cartItem the cart item
     */
    public void removeCartItem(CartItem cartItem){
       entityManager.remove(cartItem);
    }
}
