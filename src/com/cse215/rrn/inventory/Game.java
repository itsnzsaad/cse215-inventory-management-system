package com.cse215.rrn.inventory;

public class Game extends StockableProduct{
    // Properties
    private String developer;

    // Constructors
    public Game(
            String name,
            double price,
            int yearPublished,
            String genre,
            double discount,
            int numberOfItemsStocked,
            String developer
    ) {
        super(
                name,
                price,
                genre,
                yearPublished,
                discount,
                numberOfItemsStocked
        );
        this.developer = developer;
    }

    // Getters
    public String getDeveloper() {
        return this.developer;
    }

    // Setters
    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    // Override the default toString() method
    @Override
    public String toString() {
        return "Game[ developer = " + developer + "]";
    }

    // Implement abstract methods from Product Class
    @Override
    public String getInfo() {
        String string = "Name: " + super.getName();
        string += "\nProduct Id: " + super.getProductId();
        string += "\nYear Published: " + super.getYearPublished();
        string += "\nGenre: " + super.getGenre();
        string += "\nDiscount: " + super.getDiscount();
        string += "\nPrice: " + super.getPrice();
        string += "\nDeveloper's Name: " + getDeveloper();
        string += "\nIn Stock: " + super.getNumberOfItemsStocked();
        string += "\n";

        return string;
    }
}