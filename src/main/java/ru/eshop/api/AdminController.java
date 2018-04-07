package ru.eshop.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.eshop.model.Product;
import ru.eshop.model.User;
import ru.eshop.service.ProductService;
import ru.eshop.service.UserService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * The type Admin controller.
 */
@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;


    /**
     * Add product product.
     *
     * @param product the product
     * @return the product
     */
    @RequestMapping(value = "addProduct",method = RequestMethod.POST,produces = APPLICATION_JSON_VALUE)
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }


    /**
     * Gets all users.
     *
     * @return the all users
     */
    @RequestMapping(value = "userList", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
