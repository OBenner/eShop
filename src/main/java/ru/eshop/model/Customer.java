package ru.eshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 5659845114554445455L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private int customerId;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "customerEmail")
    private String customerEmail;

    @Column(name = "customerPhone")
    private String customerPhone;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<PaymentInfo> paymentInfo;

    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

    @OneToOne
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;
    @OneToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;


    public Customer() {
    }

    public Customer(int customerId, String customerName, String customerEmail, String customerPhone, String username, String password, boolean enabled, List<PaymentInfo> paymentInfo, BillingAddress billingAddress, ShippingAddress shippingAddress, Cart cart) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.username = username;
        this.password = password;
        this.enabled = enabled;

        for (PaymentInfo paymentInfoEntity : getPaymentInfo()) {
            getPaymentInfo().add(new PaymentInfo(paymentInfoEntity));

        }
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.cart = cart;

    }




    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<PaymentInfo> getPaymentInfo() {
        if (paymentInfo == null) {
            setPaymentInfo(new ArrayList<PaymentInfo>());
        }
        return paymentInfo;
    }

    public void setPaymentInfo(List<PaymentInfo> paymentInfo) {
        this.paymentInfo = paymentInfo;
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}