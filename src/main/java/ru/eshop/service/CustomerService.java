package ru.eshop.service;

import ru.eshop.model.BillingAddress;
import ru.eshop.model.Customer;
import ru.eshop.model.ShippingAddress;

import java.util.List;

public interface CustomerService {

    Customer addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUserName(String username);

    Customer addShippingAddress(ShippingAddress shippingAddress);

    Customer addBillingAddress(BillingAddress billingAddress);
}
