package ru.eshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by omyag on 08.11.2017.
 */
@Entity
@Table(name = "CART_ITEM")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class CartItem  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @Column(name = "quantity")
    private Integer quantity;


    /**
     * Instantiates a new Cart item.
     */
    public CartItem() {
    }

    /**
     * Instantiates a new Cart item.
     *
     * @param product  the product
     * @param cart     the cart
     * @param quantity the quantity
     */
    public CartItem(Product product, Cart cart, Integer quantity) {
        this.product = product;
    //    this.cart = cart;
        this.quantity = quantity;
    }

    /**
     * Instantiates a new Cart item.
     *
     * @param item the item
     */
    public CartItem(CartItem item) {
        this.id=item.id;
        this.product= new Product(item.getProduct());
        this.quantity=item.quantity;

    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets product.
     *
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets product.
     *
     * @param product the product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets cart.
     *
     * @return the cart
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * Sets cart.
     *
     * @param cart the cart
     */
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }



    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", product=" + product +
                ", cart=" + cart +
                ", quantity=" + quantity +
                '}';
    }
}
