package ru.eshop.service;

import ru.eshop.model.Product;

import java.util.List;

/**
 * The interface Product service.
 */
public interface ProductService {

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
    Product getProductById(Long id);

    /**
     * Add product product.
     *
     * @param product the product
     * @return the product
     */
    Product addProduct(Product product);

    /**
     * Edit product.
     *
     * @param product the product
     */
    void editProduct(Product product);

    /**
     * Delete product.
     *
     * @param product the product
     */
    void deleteProduct(Product product);
}
