package ru.eshop.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.eshop.model.Role;
import ru.eshop.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The type Custom user details.
 */
public class CustomUserDetails implements UserDetails {

    private User user;

    /**
     * Instantiates a new Custom user details.
     *
     * @param user the user
     */
    public CustomUserDetails(User user) {
        this.user = user;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
        for (Role role : user.getRoles()) {
            result.add(new SimpleGrantedAuthority(role.getName()));
        }
        return result;
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getEmail();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

}
