package ru.eshop.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The type Billing address.
 */
@Entity
@Table(name = "BILLING_ADDRESS")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
//@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BillingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "apartment_number")
    private String apartmentNumber;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "country")
    private String country;
    @Column(name = "zip_code")
    private String zipCode;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    @XmlTransient
    private User user;

    /**
     * Instantiates a new Billing address.
     */
    public BillingAddress() {
    }

    /**
     * Instantiates a new Billing address.
     *
     * @param billingAddressInfo the billing address info
     */
    public BillingAddress(BillingAddress billingAddressInfo) {
        this.id=billingAddressInfo.id;
        this.apartmentNumber=billingAddressInfo.apartmentNumber;
        this.city=billingAddressInfo.city;
        this.country=billingAddressInfo.country;
        this.state=billingAddressInfo.state;
        this.streetName=billingAddressInfo.streetName;
        this.zipCode=billingAddressInfo.zipCode;
        this.user=billingAddressInfo.user;
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
     * Gets street name.
     *
     * @return the street name
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets street name.
     *
     * @param streetName the street name
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Gets apartment number.
     *
     * @return the apartment number
     */
    public String getApartmentNumber() {
        return apartmentNumber;
    }

    /**
     * Sets apartment number.
     *
     * @param apartmentNumber the apartment number
     */
    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets country.
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     *
     * @param country the country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets zip code.
     *
     * @return the zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets zip code.
     *
     * @param zipCode the zip code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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
