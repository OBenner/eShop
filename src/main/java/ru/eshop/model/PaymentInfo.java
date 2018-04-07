package ru.eshop.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The type Payment info.
 */
@Entity
@Table(name = "PAYMENT_INFO")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "cvv")
    private String cvv;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    /**
     * Instantiates a new Payment info.
     */
    public PaymentInfo() {
    }

    /**
     * Instantiates a new Payment info.
     *
     * @param paymentInfo the payment info
     */
    public PaymentInfo(PaymentInfo paymentInfo) {
        this.id=paymentInfo.id;
        this.cardNumber=paymentInfo.cardNumber;
        this.cvv=paymentInfo.cvv;
        this.firstName=paymentInfo.firstName;
        this.lastName=paymentInfo.lastName;
        this.phoneNumber=paymentInfo.phoneNumber;
        this.user=paymentInfo.user;
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
     * Gets card number.
     *
     * @return the card number
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets card number.
     *
     * @param cardNumber the card number
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Gets cvv.
     *
     * @return the cvv
     */
    public String getCvv() {
        return cvv;
    }

    /**
     * Sets cvv.
     *
     * @param cvv the cvv
     */
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets phone number.
     *
     * @param phoneNumber the phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}