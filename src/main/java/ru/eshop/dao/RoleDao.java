package ru.eshop.dao;

import org.springframework.stereotype.Service;
import ru.eshop.model.Role;

@Service
public interface RoleDao {
    Role findRoleByName(String name);
}
