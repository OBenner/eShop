package ru.eshop.dao;

import org.springframework.stereotype.Service;
import ru.eshop.model.Role;

/**
 * The interface Role dao.
 */
@Service
public interface RoleDao {
    /**
     * Find role by name role.
     *
     * @param name the name
     * @return the role
     */
    Role findRoleByName(String name);
}
