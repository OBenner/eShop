package ru.eshop.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by omyag on 19.10.2017.
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {
    private static final long serialVersionUID = -454545114554445455L;


    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    //  @NotEmpty(message = "The product name must not be null.")
    @Column(name = "productName")
    private String productName;
    @Column(name = "productCategory")
    private String productCategory;
    @Column(name = "productDescription")
    private String productDescription;
    @Column(name = "productPrice")
    //  @Min(value = 0, message = "The product price must no be less then zero.")
    private double productPrice;
    @Column(name = "productCondition")
    private String productCondition;
    @Column(name = "productStatus")
    private String productStatus;
    @Column(name = "productManufacturer")
    private String productManufacturer;
    @Column(name = "unitInStock")
    //  @Min(value = 0, message = "The product unit must no be less then zero.")
    private int unitInStock;

    @Transient
    private MultipartFile productImage;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> cartItemList;

    public Product() {
    }

    public Product(int productId, String productName, String productCategory, String productDescription, double productPrice, String productCondition, String productStatus, String productManufacturer, int unitInStock, MultipartFile productImage, List<CartItem> cartItemList) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productCondition = productCondition;
        this.productStatus = productStatus;
        this.productManufacturer = productManufacturer;
        this.unitInStock = unitInStock;
        this.productImage = productImage;
        this.cartItemList = cartItemList;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescriprion(String productDescriprion) {
        this.productDescription = productDescriprion;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCondition() {
        return productCondition;
    }

    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }


    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }
}
