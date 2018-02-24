package ru.eshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CUSTOMER_ORDER")
public class CustomerOrder  {

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

    public CustomerOrder() {
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
}
