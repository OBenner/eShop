package ru.eshop.dao;

import ru.eshop.model.ShippingAddress;

/**
 * The interface Shipping address dao.
 */
public interface ShippingAddressDao {

    /**
     * Create shipping address.
     *
     * @param shippingAddress the shipping address
     * @return the shipping address
     */
    ShippingAddress create(ShippingAddress shippingAddress);
}
