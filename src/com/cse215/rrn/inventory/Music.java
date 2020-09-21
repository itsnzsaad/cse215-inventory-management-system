package com.cse215.rrn.inventory;

public class Music extends StockableProduct{
    // Properties
    private String artistName;

    // Constructors
    public Music(
            String name,
            double price,
            int yearPublished,
            String genre,
            double discount,
            int numberOfItemsStocked,
            String artistName
    ) {
        super(
                name,
                price,
                genre,
                yearPublished,
                discount,
                numberOfItemsStocked
        );
        this.artistName = artistName ;
    }

    // Getters
    public String getArtistName() {
        return this.artistName;
    }

    // Setters
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    // Override the default toString() method
    @Override
    public String toString() {
        return "Music [artistName = " + artistName + "]";
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
        string += "\nArtist's Name: " + getArtistName();
        string += "\nIn Stock: " + super.getNumberOfItemsStocked();
        string += "\n";

        return string;
    }
}