package ru.eshop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eshop.dao.CustomerOrderDao;
import ru.eshop.model.CustomerOrder;

import javax.persistence.EntityManager;


@Service
public class CustomerOrderDaoImpl implements CustomerOrderDao {

    @Autowired
    private EntityManager entityManager;

@Transactional
    public void addCustomerOrder(CustomerOrder customerOrder) {
       entityManager.merge(customerOrder);
    }


}
