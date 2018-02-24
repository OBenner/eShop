package ru.eshop.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Authorities {


    @Id
    @GeneratedValue
    private int authoritiesId;
    private String username;
    private String authority;

    public Authorities() {
    }

    public Authorities(int authoritiesId, String username, String authority) {
        this.authoritiesId = authoritiesId;
        this.username = username;
        this.authority = authority;
    }

    public int getAuthoritiesId() {
        return authoritiesId;
    }

    public void setAuthoritiesId(int authoritiesId) {
        this.authoritiesId = authoritiesId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
