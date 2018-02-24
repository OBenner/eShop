package ru.eshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.eshop.dao.UserDao;
import ru.eshop.model.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.getUserByEmail(s);
        if (user == null) {
            throw new UsernameNotFoundException(s);
        }
        return new CustomUserDetails(user);
    }



}
