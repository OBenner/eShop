package ru.eshop.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eshop.dao.CartItemDao;
import ru.eshop.model.Cart;
import ru.eshop.model.CartItem;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class CartItemDaoImpl implements CartItemDao {

    @Autowired
    private EntityManager entityManager;

    public void addCartItem(CartItem cartItem) {
//        Session session = sessionFactory.getCurrentSession();
//        session.saveOrUpdate(cartItem);
//        session.flush();
    }

    public void removeCartItem(CartItem cartItem) {
//        Session session = sessionFactory.getCurrentSession();
//        session.delete(cartItem);
//        session.flush();
    }

    public void removeAllCartItems(Cart cart) {

        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem item : cartItems) {
            removeCartItem(item);
        }
    }

    public CartItem getCartItemByProductId(int productId) {
//        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("from CartItem where productId = ?");
//        query.setInteger(0, productId);
//        session.flush();
//        return (CartItem) query.uniqueResult();
        return null;
    }
}
