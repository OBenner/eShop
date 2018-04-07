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
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_category")
    private String productCategory;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "product_price")
    private Float productPrice;
    @Column(name = "product_condition")
    private String productCondition;
    @Column(name = "product_status")
    private String productStatus;
    @Column(name = "product_manufacturer")
    private String productManufacturer;
    @Column(name = "unit_in_stock")
    private Long unitInStock;


    /**
     * Instantiates a new Product.
     */
    public Product() {
    }


    /**
     * Instantiates a new Product.
     *
     * @param product the product
     */
    public Product(Product product) {

        this.productId=product.getProductId();
        this.productName = product.getProductName();
        this.productCategory = product.getProductCategory();
        this.productDescription = product.getProductDescription();
        this.productPrice = product.getProductPrice();
        this.productCondition = product.getProductCondition();
        this.productStatus = product.getProductStatus();
        this.productManufacturer = product.getProductManufacturer();
        this.unitInStock = product.getUnitInStock();
    }

    /**
     * Gets product id.
     *
     * @return the product id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * Sets product id.
     *
     * @param productId the product id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * Gets product name.
     *
     * @return the product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets product name.
     *
     * @param productName the product name
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Gets product category.
     *
     * @return the product category
     */
    public String getProductCategory() {
        return productCategory;
    }

    /**
     * Sets product category.
     *
     * @param productCategory the product category
     */
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    /**
     * Gets product description.
     *
     * @return the product description
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * Sets product description.
     *
     * @param productDescription the product description
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * Gets product price.
     *
     * @return the product price
     */
    public Float getProductPrice() {
        return productPrice;
    }

    /**
     * Sets product price.
     *
     * @param productPrice the product price
     */
    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * Gets product condition.
     *
     * @return the product condition
     */
    public String getProductCondition() {
        return productCondition;
    }

    /**
     * Sets product condition.
     *
     * @param productCondition the product condition
     */
    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }

    /**
     * Gets product status.
     *
     * @return the product status
     */
    public String getProductStatus() {
        return productStatus;
    }

    /**
     * Sets product status.
     *
     * @param productStatus the product status
     */
    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    /**
     * Gets product manufacturer.
     *
     * @return the product manufacturer
     */
    public String getProductManufacturer() {
        return productManufacturer;
    }

    /**
     * Sets product manufacturer.
     *
     * @param productManufacturer the product manufacturer
     */
    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    /**
     * Gets unit in stock.
     *
     * @return the unit in stock
     */
    public Long getUnitInStock() {
        return unitInStock;
    }

    /**
     * Sets unit in stock.
     *
     * @param unitInStock the unit in stock
     */
    public void setUnitInStock(Long unitInStock) {
        this.unitInStock = unitInStock;
    }
}
