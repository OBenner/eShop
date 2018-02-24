package ru.eshop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eshop.dao.PaymentInfoDao;
import ru.eshop.model.PaymentInfo;

import javax.persistence.EntityManager;


@Service
public class PaymentInfoDaoImpl implements PaymentInfoDao {
    @Autowired
    private EntityManager entityManager;


    public PaymentInfo create(PaymentInfo paymentInfo) {
        return entityManager.merge(paymentInfo);
    }
}
