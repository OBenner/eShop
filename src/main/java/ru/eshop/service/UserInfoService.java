package ru.eshop.service;

import ru.eshop.model.*;

import java.util.List;

/**
 * The interface User info service.
 */
public interface UserInfoService {


    /**
     * Gets user info.
     *
     * @param email the email
     * @return the user info
     */
    User getUserInfo(String email);

    /**
     * Add payment info user.
     *
     * @param email       the email
     * @param paymentInfo the payment info
     * @return the user
     */
    User addPaymentInfo(String email, PaymentInfo paymentInfo);

    /**
     * Update payment info user.
     *
     * @param paymentInfo the payment info
     * @return the user
     */
    User updatePaymentInfo(PaymentInfo paymentInfo);

    /**
     * Add shipping address user.
     *
     * @param email           the email
     * @param shippingAddress the shipping address
     * @return the user
     */
    User addShippingAddress(String email, ShippingAddress shippingAddress);

    /**
     * Update shipping address user.
     *
     * @param shippingAddress the shipping address
     * @return the user
     */
    User updateShippingAddress(ShippingAddress shippingAddress);

    /**
     * Add billing address user.
     *
     * @param email          the email
     * @param billingAddress the billing address
     * @return the user
     */
    User addBillingAddress(String email, BillingAddress billingAddress);

    /**
     * Update billing address user.
     *
     * @param billingAddressOldId the billing address old id
     * @param billingAddressNew   the billing address new
     * @return the user
     */
    User updateBillingAddress(String email,Long billingAddressOldId, BillingAddress billingAddressNew);



}
