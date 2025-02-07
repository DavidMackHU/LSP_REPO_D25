package org.howard.edu.lsp.assignment2;

public class Product {
    private int productID;
    private String name;
    private double price;
    private String category;
    private String priceRange;

    // Constructor
    public Product(int productID, String name, double price, String category, String priceRange) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.category = category;
        this.priceRange = priceRange;
    }

    // Getters and Setters
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }
}
