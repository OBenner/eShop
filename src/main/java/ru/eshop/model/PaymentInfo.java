package ru.eshop.model;


import javax.persistence.*;

@Entity
@Table(name = "PAYMENT_INFO")
public class PaymentInfo {
    @Id
    @Column(name = "id", insertable = false,updatable = false)
    @GeneratedValue
    private int id;
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

    @ManyToOne
    @JoinColumn(name = "customerId",nullable = false)
    private Customer customer;

    public PaymentInfo() {
    }

    public PaymentInfo(int id, String cardNumber, String cvv, String firstName, String lastName, String phoneNumber, Customer customer) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.customer = customer;
    }

    public PaymentInfo(PaymentInfo paymentInfoEntity) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}