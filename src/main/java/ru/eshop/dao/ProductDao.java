package ru.eshop.dao;

import ru.eshop.model.Product;

import java.util.List;

/**
 * Created by omyag on 23.10.2017.
 */
public interface ProductDao {

    /**
     * Gets product list.
     *
     * @return the product list
     */
    List<Product> getProductList();

    /**
     * Gets product by id.
     *
     * @param id the id
     * @return the product by id
     */
    Product getProductById(long id);

    /**
     * Save product product.
     *
     * @param product the product
     * @return the product
     */
    Product saveProduct(Product product);

    /**
     * Delete product.
     *
     * @param product the product
     */
    void deleteProduct(Product product);
}
