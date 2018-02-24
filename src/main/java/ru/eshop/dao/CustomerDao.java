package ru.eshop.dao;

import ru.eshop.model.Customer;

import java.util.List;

public interface CustomerDao {
    Customer addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUserName(String username);
}
