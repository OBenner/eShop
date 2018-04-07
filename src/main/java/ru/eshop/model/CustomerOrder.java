package ru.eshop.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

/**
 * The type Customer order.
 */
@Entity
@Table(name = "CUSTOMER_ORDER")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "total")
    private Float total;


    @Column(name = "date")
    private String date;


    @OneToOne
    @JoinColumn(name = "customerId")
    @XmlTransient
    private User user;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "billingAddressId")
    @XmlTransient
    private BillingAddress billingAddress;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "payment_info_id", nullable = false)
    @XmlTransient
    private PaymentInfo paymentInfo;


    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   // @XmlTransient
    private List<OrderItem> items;

    @OneToOne(mappedBy = "customerOrder", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    @XmlTransient
    private OrderInfo orderInfo;

    /**
     * Instantiates a new Customer order.
     */
    public CustomerOrder() {
    }

    /**
     * Instantiates a new Customer order.
     *
     * @param customerOrder the customer order
     */
    public CustomerOrder(CustomerOrder customerOrder) {
        if (customerOrder == null) {
            customerOrder = new CustomerOrder();
        }
        for (OrderItem item : customerOrder.getItems()) {
            getItems().add(new OrderItem(item));
        }
        this.billingAddress = customerOrder.billingAddress;
        this.shippingAddress = customerOrder.shippingAddress;
        this.paymentInfo = customerOrder.paymentInfo;
        this.id = customerOrder.id;
        this.user = customerOrder.user;
        this.total = customerOrder.total;
        this.date=customerOrder.date;
        this.orderInfo=customerOrder.orderInfo;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets total.
     *
     * @return the total
     */
    public Float getTotal() {
        return total;
    }

    /**
     * Sets total.
     *
     * @param total the total
     */
    public void setTotal(Float total) {
        this.total = total;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets billing address.
     *
     * @return the billing address
     */
    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    /**
     * Sets billing address.
     *
     * @param billingAddress the billing address
     */
    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * Gets shipping address.
     *
     * @return the shipping address
     */
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    /**
     * Sets shipping address.
     *
     * @param shippingAddress the shipping address
     */
    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * Gets payment info.
     *
     * @return the payment info
     */
    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    /**
     * Sets payment info.
     *
     * @param paymentInfo the payment info
     */
    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    public List<OrderItem> getItems() {
        if (items == null) {
            items = new ArrayList<OrderItem>();
        }
        return items;
    }

    /**
     * Sets items.
     *
     * @param items the items
     */
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }


    /**
     * Gets order info.
     *
     * @return the order info
     */
    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    /**
     * Sets order info.
     *
     * @param orderInfo the order info
     */
    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }
}
