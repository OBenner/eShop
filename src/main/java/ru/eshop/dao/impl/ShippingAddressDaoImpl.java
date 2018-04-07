package ru.eshop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eshop.dao.ShippingAddressDao;
import ru.eshop.model.ShippingAddress;

import javax.persistence.EntityManager;


/**
 * The type Shipping address dao.
 */
@Service
public class ShippingAddressDaoImpl implements ShippingAddressDao {

    @Autowired
    private EntityManager entityManager;


    public ShippingAddress create(ShippingAddress shippingAddress) {

        return entityManager.merge(shippingAddress);
    }
}
