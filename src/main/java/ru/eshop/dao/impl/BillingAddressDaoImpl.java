package ru.eshop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eshop.dao.BillingAddressDao;
import ru.eshop.model.BillingAddress;

import javax.persistence.EntityManager;


/**
 * The type Billing address dao.
 */
@Service
public class BillingAddressDaoImpl implements BillingAddressDao {

    @Autowired
    private EntityManager entityManager;

    public BillingAddress create(BillingAddress billingAddress) {
        return entityManager.merge(billingAddress);
    }

    public BillingAddress getBillingAddressById(Long billingAddressId) {
        return entityManager.find(BillingAddress.class, billingAddressId);
    }
}
