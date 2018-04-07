package ru.eshop.dao;

import ru.eshop.model.BillingAddress;

/**
 * The interface Billing address dao.
 */
public interface BillingAddressDao {
    /**
     * Create billing address.
     *
     * @param billingAddress the billing address
     * @return the billing address
     */
    BillingAddress create(BillingAddress billingAddress);

    BillingAddress getBillingAddressById(Long billingAddressId);
}
