package ru.eshop.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.eshop.dao.UserDao;

import ru.eshop.model.User;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * The type User dao.
 */
@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;


    public User createUser(User user) {

        return entityManager.merge(user);
//
    }


    public User getUserById(Long customerId) {
        return entityManager.find(User.class, customerId);
    }


    public List<User> getAllUsers() {
        return entityManager.createQuery("select i from User i", User.class).getResultList();

    }


    public User getUserByEmail(String email) {
        Query query = entityManager.createNamedQuery("selectUserByEmail", User.class);
        query.setParameter("email", email);
        List<User> result = query.getResultList();
        if (result.isEmpty()) {
            System.out.println("notFound");
            return null;
        } else {
            return result.get(0);

        }
     // return   entityManager.find(User.class, email);
    }

    public String deleteUser(User user) {
        entityManager.remove(user);
        return "User delete";
    }

}
