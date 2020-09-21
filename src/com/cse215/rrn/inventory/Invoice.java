package com.cse215.rrn.inventory;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;

public class Invoice {
    // Properties
    private ArrayList<Product> items = new ArrayList<>();
    private final LocalDateTime date;
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    // Constructors
    public Invoice() {
        this.date = LocalDateTime.now();
    }

    public Invoice(ArrayList<Product> items) {
        this.items = items;
        this.date = LocalDateTime.now();
    }

    //  This method will return a String containing the
    //  formatted date and time. Ex:
    //  2020-02-22 09:57:52
    public String getLocalDateTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // 2020-02-22 09:57:52

        return myDateObj.format(myFormatObj);
    }

    //    This method will return a String which has a
    //    format like this,
    //    Date - yyyy-MM-dd HH:mm:ss
    //    name -> price
    //    name -> price
    //    Price without discount
    //    Price after discount
    public String getInvoice() {
        StringBuilder output = new StringBuilder(getLocalDateTime() + "\n");

        for (Product item : items) {
            output.append("Name: ")
                    .append(item.getName())
                    .append(", Price: ")
                    .append(item.getPrice())
                    .append("\n");
        }

        output.append("Total price: ").append(this.calculatePriceWithoutDiscount()).append("\n");
        output.append("Price after discount: ").append(this.calculateDiscountedPrice());

        return output.toString();
    }

    //    This method will calculate the total price
    //    without any discounts, and return that sum.
    public double calculatePriceWithoutDiscount() {
        double price = 0;

        for (Product item : items) {
            price += +item.getPrice();
        }

        return price;
    }

    //    This method will check whether the fullhouse
    //    discount is available or not, and return a
    //    boolean value depending on that. Build an
    //    algorithm for this method by yourself.

    //    Hint: There is a method getclass() play
    //    around with this. Convert class names into a
    //    set, {0, Music} {1, Movies} {2, Game}. Then
    //    you can map it into an array, and keep count.
    //    Indexes of array means Music, Movies or
    //    games, and you can store the count in that
    public boolean isFullHouseDiscountAvailable() {
        boolean fullHouse = false;
        int numOfGames = 0;
        int numOfMusic = 0;
        int numOfMovies = 0;

        for (Product item : items) {
            String className = item.getClass().getSimpleName();

            if (className.equals("Game"))
                numOfGames++;
            else if (className.equals("Music"))
                numOfMusic++;
            else
                numOfMovies++;
        }

        if (numOfGames >= 2 && numOfMusic >= 2 && numOfMovies >= 2) {
            fullHouse = true;
        }
        return fullHouse;
    }

    public void addProduct(Product product) {
        items.add(product);
    }

    public void removeProduct(Product product) {
        items.remove(product);
    }


    //    In this method you must calculate the total
    //    discounted price for regular discount, check
    //    whether full house discount is available or
    //    not. If that is available then calculate the price
    //    after availing full house discount and then
    //    compare between the two prices and return
    //    the one which is less
    public String calculateDiscountedPrice() {
        double price;
        double discount;
        double priceWithoutDiscount = calculatePriceWithoutDiscount();
        double priceWithProductDiscount = 0;
        double priceWithFullHouseDiscount = 0;
        double priceWithFinalDiscount = 0;

        for (Product item : items) {
            priceWithProductDiscount += item.getPrice() * ((100 - item.getDiscount()) / 100);
        }

        if (isFullHouseDiscountAvailable()) {
            priceWithFullHouseDiscount = priceWithoutDiscount / 2;
        }
        if (
                isFullHouseDiscountAvailable()
                        && (priceWithFullHouseDiscount < priceWithProductDiscount)
        ) {
            priceWithFinalDiscount = priceWithFullHouseDiscount;
        } else {
            priceWithFinalDiscount = priceWithProductDiscount;
        }

        df2.setRoundingMode(RoundingMode.UP);

        return df2.format(priceWithFinalDiscount);
    }

    // Suppose the company is now renting out movies and games. Add this functionality to the
    // code. They are going to rent on a per hour basis
    public String rentItems(Date taken, Date returned) {
        StringBuilder output = new StringBuilder(returned + "\n");

        double rent = 0;

        DecimalFormat df = new DecimalFormat("#.##");


        for (Product item : items) {
            output.append("Name: ")
                    .append(item.getName())
                    .append(", Rent: ")
                    .append(Double.valueOf(df.format(item.getPrice() * .10)))
                    .append(" Per Hour")
                    .append("\n");

            rent += item.getPrice() * .10;
        }

        DecimalFormat formatter = new DecimalFormat("###,###");

        long diff = returned.getTime() - taken.getTime();

        int diffhours = (int) (diff / (60 * 60 * 1000));


        output.append("\nHours Taken: " + diffhours);

        output.append("\nTotal Rent: " + Double.valueOf(df.format(rent * diffhours)));

        return output.toString();
    }
}