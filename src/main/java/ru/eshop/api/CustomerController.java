package ru.eshop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.eshop.model.Customer;
import ru.eshop.service.CustomerService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping(method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE)
    public Customer create(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }


    @RequestMapping(method = RequestMethod.GET,produces = APPLICATION_JSON_VALUE)
    public List<Customer> getAllCustomer(){
        return  customerService.getAllCustomers();
    }


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,value = "{id}")
    public Customer getProductDetails(@PathVariable int id){
        return customerService.getCustomerById(id);
    }


}
