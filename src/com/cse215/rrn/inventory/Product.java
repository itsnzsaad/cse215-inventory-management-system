package com.cse215.rrn.inventory;

public abstract class Product {
    // Properties
    private String name;
    private int productId;
    private double price;
    private String genre;
    private int yearPublished;
    private double discount;

    // Unique ID for every instance
    private static int productIdCount = 0;

    // Constructor
    public Product(
        String name,
        double price,
        String genre,
        int yearPublished,
        double discount
    ) {
        this.name = name;
        this.price = price;
        this.genre = genre;
        this.yearPublished = yearPublished;
        this.discount = discount;

        this.productId = productIdCount++;
    }

    // Getters
    public String getName() {
        return name;
    }
    public int getProductId() {
        return productId;
    }
    public double getPrice() {
        return price;
    }
    public String getGenre() {
        return genre;
    }
    public int getYearPublished() {
        return yearPublished;
    }
    public double getDiscount() {
        return discount;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    // Override the default toString() method
    @Override
    public String toString() {
        return "Product [name = " + name
                + ", productId = " + productId
                + ", price = " + price
                + ", genre = " + genre
                + ", yearPublished =" + yearPublished
                + ", discount =" + discount + "]";
    }

    // Abstract Classes
    //    This method is an abstract method, and you
    //    will implement this method in the child
    //    classes(Game, Music, Movies) of this class
    public abstract String getInfo();
}
