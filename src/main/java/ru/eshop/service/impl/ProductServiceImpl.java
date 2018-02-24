package ru.eshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eshop.dao.ProductDao;
import ru.eshop.model.Product;
import ru.eshop.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> getProductList() {
        return productDao.getProductList();
    }

    public Product getProductById(int productId) {
        return productDao.getProductById(productId);
    }


    public Product addProduct(Product product) {
       productDao.saveProduct(product);
       return product;
    }

    public void editProduct(Product product) {
        productDao.saveProduct(product);
    }

    public void deleteProduct(Product product) {
        productDao.deleteProduct(product);
    }
}
