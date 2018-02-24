package ru.eshop.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eshop.dao.ProductDao;
import ru.eshop.model.Customer;
import ru.eshop.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


/**
 * Created by omyag on 23.10.2017.
 */
@Service
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public List<Product> getProductList() {
        return entityManager.createQuery("select i from Product i", Product.class).getResultList();
    }

    public Product getProductById(int productId) {
        return entityManager.find(Product.class, productId);
    }

    @Transactional
    public Product saveProduct(Product product) {
        return entityManager.merge(product);
    }


    @Transactional
    public void deleteProduct(Product product) {
        entityManager.remove(product);
    }
}
