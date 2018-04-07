package ru.eshop.dao;

import ru.eshop.model.PaymentInfo;


/**
 * The interface Payment info dao.
 */
public interface PaymentInfoDao {

    /**
     * Create payment info.
     *
     * @param paymentInfo the payment info
     * @return the payment info
     */
    PaymentInfo create(PaymentInfo paymentInfo);
}
