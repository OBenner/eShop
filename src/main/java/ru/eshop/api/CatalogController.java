package ru.eshop.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.eshop.model.Product;
import ru.eshop.service.ProductService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private ProductService productService;


    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public List<Product> getAllProduct() {
        return productService.getProductList();
    }


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,value = "{id}")
    public Product getProductDetails(@PathVariable Long id){
        return productService.getProductById(id);
    }


}
