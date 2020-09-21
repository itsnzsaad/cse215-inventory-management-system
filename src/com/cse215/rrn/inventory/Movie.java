package com.cse215.rrn.inventory;

public class Movie extends StockableProduct{
    // Properties
    private String director ;

    // Constructors
    public Movie(
            String name,
            double price,
            int yearPublished,
            String genre,
            double discount,
            int numberOfItemsStocked,
            String director
    ) {
        super(
                name,
                price,
                genre,
                yearPublished,
                discount,
                numberOfItemsStocked
        );
        this.director = director;
    }

    // Getters
    public String getDirector() {
        return director;
    }

    // Setters
    public void setDirector(String director) {
        this.director = director;
    }

    // Override the default toString() method
    @Override
    public String toString() {
        return "Movie [director = " + director + "]";
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
        string += "\nDirector's Name: " + getDirector();
        string += "\nIn Stock: " + super.getNumberOfItemsStocked();
        string += "\n";

        return string;
    }
}

