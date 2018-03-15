package ru.eshop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "CUSTOMER_ORDER")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "total")
    private Float total;
    @Column(name = "date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date date;
    @OneToOne
    @JoinColumn(name = "customerId")
    @JsonBackReference
    private User user;
    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;

    @ManyToOne
    @JoinColumn(name = "payment_info_id", nullable = false)
    private PaymentInfo paymentInfo;

    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    public CustomerOrder() {
    }

    public CustomerOrder(CustomerOrder customerOrder) {
        if (customerOrder == null) {
            customerOrder = new CustomerOrder();
        }
        this.billingAddress = customerOrder.billingAddress;
        this.shippingAddress = customerOrder.shippingAddress;
        this.paymentInfo = customerOrder.paymentInfo;
        this.cart = customerOrder.cart;
        this.date = new java.util.Date ();
        this.id=customerOrder.id;
        this.total=customerOrder.total;
        this.user=customerOrder.user;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }


}
