package ru.eshop.service;

import ru.eshop.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductList();

    Product getProductById(Long id);

    Product addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);
}
