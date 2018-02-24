package ru.eshop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eshop.dao.CustomerDao;

import ru.eshop.model.Customer;


import javax.persistence.EntityManager;
import java.util.List;

@Service
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Customer addCustomer(Customer customer) {

//        Users newUser = new Users();
//        newUser.setUsername(customer.getUsername());
//        newUser.setPassword(customer.getPassword());
//        newUser.setEnabled(true);
//        newUser.setCustomerId(customer.getCustomerId());
//
//        Authorities newAuthority = new Authorities();
//        newAuthority.setUsername(customer.getUsername());
//        newAuthority.setAuthority("ROLE_USER");
//        entityManager.merge(newUser);
//        entityManager.merge(newAuthority);
        return entityManager.merge(customer);
//        customer.getBillingAddress().setCustomer(customer);
//        customer.getShippingAddress().setCustomer(customer);
//
//        session.saveOrUpdate(customer);
//        session.saveOrUpdate(customer.getBillingAddress());
//        session.saveOrUpdate(customer.getShippingAddress());
//
//        Users newUser = new Users();
//        newUser.setUsername(customer.getUsername());
//        newUser.setPassword(customer.getPassword());
//        newUser.setEnabled(true);
//        newUser.setCustomerId(customer.getCustomerId());
//
//        Authorities newAuthority = new Authorities();
//        newAuthority.setUsername(customer.getUsername());
//        newAuthority.setAuthority("ROLE_USER");
//        session.saveOrUpdate(newUser);
//        session.saveOrUpdate(newAuthority);
//
//        Cart newCart = new Cart();
//        newCart.setCustomer(customer);
//        customer.setCart(newCart);
//        session.saveOrUpdate(customer);
//        session.saveOrUpdate(newCart);
//
//        session.flush();
    }

    @Transactional
    public Customer getCustomerById(int customerId) {
        return entityManager.find(Customer.class, customerId);
    }

    @Transactional
    public List<Customer> getAllCustomers() {
        return entityManager.createQuery("select i from Customer i", Customer.class).getResultList();
    }

    public Customer getCustomerByUserName(String username) {
        return entityManager.find(Customer.class, username);
    }


}
