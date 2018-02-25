package ru.eshop.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eshop.dao.ProductDao;
import ru.eshop.model.Product;

import javax.persistence.EntityManager;
import java.util.List;


/**
 * Created by omyag on 23.10.2017.
 */
@Service
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private EntityManager entityManager;


    public List<Product> getProductList() {
        return entityManager.createQuery("select i from Product i", Product.class).getResultList();
    }

    public Product getProductById(long productId) {
        return entityManager.find(Product.class, productId);
    }


    public Product saveProduct(Product product) {
        return entityManager.merge(product);
    }



    public void deleteProduct(Product product) {
        entityManager.remove(product);
    }
}
