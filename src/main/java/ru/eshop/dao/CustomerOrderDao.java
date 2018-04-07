package ru.eshop.dao;

import ru.eshop.model.CustomerOrder;

/**
 * The interface Customer order dao.
 */
public interface CustomerOrderDao {

    /**
     * Update customer order.
     *
     * @param customerOrder the customer order
     * @return the customer order
     */
    CustomerOrder update(CustomerOrder customerOrder);
}
