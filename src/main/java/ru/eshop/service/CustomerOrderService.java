package ru.eshop.service;

import ru.eshop.model.CustomerOrder;

public interface CustomerOrderService {
    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);
}
