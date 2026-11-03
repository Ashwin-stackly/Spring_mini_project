package com.example.inventory.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class Product {

    private int productId;

    @NotBlank(message = "Product name is mandatory")
    private String productName;

    private String category;

    @Min(value = 0, message = "Stock cannot be negative")
    private int stock;

    @Positive(message = "Price should be greater than zero")
    private double price;

    public Product() {}

    public Product(int productId, String productName, String category, int stock, double price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.stock = stock;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}