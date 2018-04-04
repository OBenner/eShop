package ru.eshop.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CUSTOMER_ORDER")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@XmlRootElement
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
    private User user;


    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "billingAddressId")
    private BillingAddress billingAddress;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "shippingAddressId")
    private ShippingAddress shippingAddress;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "payment_info_id", nullable = false)
    private PaymentInfo paymentInfo;


    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)

    private List<OrderItem> items;


    public CustomerOrder() {
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public List<OrderItem> getItems() {
        if (items == null) {
            items = new ArrayList<OrderItem>();
        }
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }


}
