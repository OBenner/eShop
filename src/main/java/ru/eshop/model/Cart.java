package ru.eshop.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by omyag on 08.11.2017.
 */
@Entity
@Table(name = "CART")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;


    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CartItem> items;


    public Cart() {

    }

    public Cart(User user, List<CartItem> items) {

        this.user = user;
        this.items = items;

    }

    public Cart(Cart cart) {
        if (cart == null) {
            cart = new Cart();

        }

        for (CartItem item : cart.getItems()) {
            getItems().add(new CartItem(item));
        }
        this.id = cart.id;
        this.user = cart.user;
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




    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + user +
                ", items=" + Arrays.toString(items.toArray()) +
                //   ", customerOrder=" + customerOrder +
                '}';
    }
}
