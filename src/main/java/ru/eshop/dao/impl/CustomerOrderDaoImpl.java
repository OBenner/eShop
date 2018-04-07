package ru.eshop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eshop.dao.CustomerOrderDao;
import ru.eshop.model.CustomerOrder;

import javax.persistence.EntityManager;

/**
 * The type Customer order dao.
 */
@Service
public class CustomerOrderDaoImpl implements CustomerOrderDao {

    @Autowired
    private EntityManager entityManager;


    public CustomerOrder update(CustomerOrder customerOrder) {

        return entityManager.merge(customerOrder);
    }
}
