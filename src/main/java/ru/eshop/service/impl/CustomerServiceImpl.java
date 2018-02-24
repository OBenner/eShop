package ru.eshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eshop.dao.CustomerDao;
import ru.eshop.model.BillingAddress;
import ru.eshop.model.Customer;
import ru.eshop.model.ShippingAddress;
import ru.eshop.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public Customer addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
        return customer;
    }

    public Customer getCustomerById(int customerId) {

        return customerDao.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers() {

        return customerDao.getAllCustomers();
    }

    public Customer getCustomerByUserName(String username) {
        return customerDao.getCustomerByUserName(username);
    }

    public Customer addShippingAddress(ShippingAddress shippingAddress) {
       //Customer = customerDao.getCustomerById()

        return null;
    }

    public Customer addBillingAddress(BillingAddress billingAddress) {
        return null;
    }

}
