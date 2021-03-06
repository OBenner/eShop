package ru.eshop.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The type Order item.
 */
@Entity
@Table(name = "ORDER_ITEM")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customerOrder_Id", nullable = true)
    @XmlTransient
    private CustomerOrder customerOrder;

    @Column(name = "quantity")
    private Integer quantity;


    /**
     * Instantiates a new Order item.
     */
    public OrderItem() {
    }

    /**
     * Instantiates a new Order item.
     *
     * @param item the item
     */
    public OrderItem(OrderItem item) {
        this.id = item.id;
        this.product = item.product;
        this.quantity = item.quantity;
        this.customerOrder=item.customerOrder;
    }

    /**
     * Instantiates a new Order item.
     *
     * @param item the item
     */
    public OrderItem(CartItem item) {
        this.product = item.getProduct();
        this.quantity = item.getQuantity();
        this.id = item.getId();

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
     * Gets customer order.
     *
     * @return the customer order
     */
    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    /**
     * Sets customer order.
     *
     * @param customerOrder the customer order
     */
    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
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
}
