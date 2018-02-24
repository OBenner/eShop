package ru.eshop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eshop.dao.RoleDao;
import ru.eshop.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Service
public class RoleDaoImpl implements RoleDao {
    @Autowired
    EntityManager entityManager;

    public Role findRoleByName(String name) {
        TypedQuery<Role> query = entityManager.createNamedQuery("findRoleByName", Role.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
