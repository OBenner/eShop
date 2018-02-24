package ru.eshop.dao;

import ru.eshop.model.Product;

import java.util.List;

/**
 * Created by omyag on 23.10.2017.
 */
public interface ProductDao {

    List<Product> getProductList();

    Product getProductById(long id);

    Product saveProduct(Product product);

    void deleteProduct(Product product);
}
