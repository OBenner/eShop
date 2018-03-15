package ru.eshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by omyag on 08.11.2017.
 */
@Entity
@Table(name = "CART")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items;

    @OneToOne(mappedBy = "cart", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CustomerOrder customerOrder;


    public Cart() {
    }

    public Cart(User user, List<CartItem> items) {
        this.user = user;
        this.items = items;
    }

    public Cart(Cart cart) {
        this.id = cart.id;
        this.user=cart.user;
        if (cart == null) {
            cart = new Cart();
        }

        for (CartItem item : cart.getItems()) {
            getItems().add(new CartItem(item));
        }
        this.customerOrder=cart.customerOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartItem> getItems() {
        if (items == null) {
            items = new ArrayList<CartItem>();
        }
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + user +
                ", items=" + Arrays.toString(items.toArray()) +
                ", customerOrder=" + customerOrder +
                '}';
    }
}
