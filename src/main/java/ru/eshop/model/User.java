package ru.eshop.model;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * The type User.
 */
@Entity
@Table(name = "user")
@NamedQueries(
        @NamedQuery(name = "selectUserByEmail", query = "from User u where u.email=:email")
)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
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
    @XmlTransient
    private List<PaymentInfo> paymentInfo;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @XmlTransient
    private List<BillingAddress> billingAddress;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @XmlTransient
    private List<ShippingAddress> shippingAddress;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @XmlTransient
    private List<CustomerOrder> orders;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    @XmlTransient
    private Cart cart;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    @XmlTransient
    private Set<Role> roles;


    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param entity the entity
     */
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
        for (CustomerOrder customerOrder : entity.getOrders()) {
            getOrders().add(new CustomerOrder(customerOrder));
        }

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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets payment info.
     *
     * @return the payment info
     */
    public List<PaymentInfo> getPaymentInfo() {
        if (this.paymentInfo == null) {
            this.paymentInfo = new ArrayList<PaymentInfo>();
        }
        return paymentInfo;
    }

    /**
     * Sets payment info.
     *
     * @param paymentInfo the payment info
     */
    public void setPaymentInfo(List<PaymentInfo> paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    /**
     * Gets billing address.
     *
     * @return the billing address
     */
    public List<BillingAddress> getBillingAddress() {
        if (this.billingAddress == null) {
            this.billingAddress = new ArrayList<BillingAddress>();
        }
        return billingAddress;
    }

    /**
     * Sets billing address.
     *
     * @param billingAddress the billing address
     */
    public void setBillingAddress(List<BillingAddress> billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * Gets shipping address.
     *
     * @return the shipping address
     */
    public List<ShippingAddress> getShippingAddress() {
        if (this.shippingAddress == null) {
            this.shippingAddress = new ArrayList<ShippingAddress>();
        }
        return shippingAddress;
    }

    /**
     * Sets shipping address.
     *
     * @param shippingAddress the shipping address
     */
    public void setShippingAddress(List<ShippingAddress> shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    /**
     * Gets orders.
     *
     * @return the orders
     */
    public List<CustomerOrder> getOrders() {
        if (this.orders == null) {
            this.orders = new ArrayList<CustomerOrder>();
        }
        return orders;
    }

    /**
     * Sets orders.
     *
     * @param orders the orders
     */
    public void setOrders(List<CustomerOrder> orders) {
        this.orders = orders;
    }

    /**
     * Gets cart.
     *
     * @return the cart
     */
    public Cart getCart() {
//        if (cart.getStatus().equals("end"))
//            return new Cart();
//        else
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
     * Gets roles.
     *
     * @return the roles
     */
    public Set<Role> getRoles() {
        if (roles == null) {
            roles = new HashSet<Role>();
        }
        return roles;
    }

    /**
     * Sets roles.
     *
     * @param roles the roles
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", phone='" + phone + '\'' +
//                ", password='" + password + '\'' +
//                ", paymentInfo=" + Arrays.toString(paymentInfo.toArray()) +
//                ", billingAddress=" + Arrays.toString(billingAddress.toArray()) +
//                ", shippingAddress=" + Arrays.toString(shippingAddress.toArray()) +
//                ", orders=" +Arrays.toString(orders.toArray())  +
//                ", cart=" + cart +
//                ", roles=" + roles +
//                '}';
//    }
}