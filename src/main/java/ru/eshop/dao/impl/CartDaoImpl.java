package ru.eshop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eshop.dao.CartDao;
import ru.eshop.model.Cart;

import javax.persistence.EntityManager;

@Service
public class CartDaoImpl implements CartDao {

    @Autowired
    private EntityManager entityManager;


    public Cart update(Cart cart) {

       return entityManager.merge(cart);
    }

    public Cart findById(Long id) {
        return entityManager.find(Cart.class,id);
    }


}
