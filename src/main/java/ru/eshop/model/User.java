package ru.eshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "user")
@NamedQueries(
        @NamedQuery(name = "selectUserByEmail", query = "from User u where u.email=:email")
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_email")
    private String email;

    @Column(name = "customer_phone")
    private String phone;


    @Column(name = "password")
    private String password;


    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<PaymentInfo> paymentInfo;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<BillingAddress> billingAddress;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<ShippingAddress> shippingAddress;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<CustomerOrder> orders;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private Cart cart;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    @JsonManagedReference
    private Set<Role> roles;


    public User() {
    }

    public User(User entity) {
        this.id = entity.getId();
        this.email = entity.getEmail();
        this.cart = entity.getCart();
        this.name = entity.getName();
        this.password = entity.getPassword();
        this.phone = entity.getPhone();
        for (ShippingAddress shippingInfoEntity : entity.getShippingAddress()) {
            getShippingAddress().add(new ShippingAddress(shippingInfoEntity));
        }
        for (BillingAddress billingAddressInfo : entity.getBillingAddress()) {
            getBillingAddress().add(new BillingAddress(billingAddressInfo));
        }
        for (PaymentInfo paymentInfo : entity.getPaymentInfo()) {
            getPaymentInfo().add(new PaymentInfo(paymentInfo));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PaymentInfo> getPaymentInfo() {
        if (this.paymentInfo == null) {
            this.paymentInfo = new ArrayList<PaymentInfo>();
        }
        return paymentInfo;
    }

    public void setPaymentInfo(List<PaymentInfo> paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public List<BillingAddress> getBillingAddress() {
        if (this.billingAddress == null) {
            this.billingAddress = new ArrayList<BillingAddress>();
        }
        return billingAddress;
    }

    public void setBillingAddress(List<BillingAddress> billingAddress) {
        this.billingAddress = billingAddress;
    }

    public List<ShippingAddress> getShippingAddress() {
        if (this.shippingAddress == null) {
            this.shippingAddress = new ArrayList<ShippingAddress>();
        }
        return shippingAddress;
    }

    public void setShippingAddress(List<ShippingAddress> shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<CustomerOrder> getOrders() {
        if (this.orders == null) {
            this.orders = new ArrayList<CustomerOrder>();
        }
        return orders;
    }

    public void setOrders(List<CustomerOrder> orders) {
        this.orders = orders;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Set<Role> getRoles() {
        if (roles == null) {
            roles = new HashSet<Role>();
        }
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", paymentInfo=" + Arrays.toString(paymentInfo.toArray())  +
                ", billingAddress=" + Arrays.toString(billingAddress.toArray())  +
                ", shippingAddress=" + Arrays.toString(shippingAddress.toArray()) +
                ", orders=" + orders +
                ", cart=" + cart +
                ", roles=" + roles +
                '}';
    }
}