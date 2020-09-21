package com.cse215.rrn.inventory;
import java.util.Comparator;

public abstract class StockableProduct extends Product implements Stockable {
    // Properties
    private int numberOfItemsStocked;

    // Constructor
    public StockableProduct(
            String name,
            double price,
            String genre,
            int yearPublished,
            double discount,
            int numberOfItemsStocked
    ) {
        super(
                name,
                price,
                genre,
                yearPublished,
                discount
        );
        this.numberOfItemsStocked = numberOfItemsStocked;
    }

    // Getters
    public int getNumberOfItemsStocked() {
        return numberOfItemsStocked;
    }

    // Setters
    public void setNumberOfItemsStocked(int numberOfItemsStocked) {
        this.numberOfItemsStocked = numberOfItemsStocked;
    }


    // Override methods implemented from Stockable interface
    // This method will take the number of a product
    // to be stocked, and add it with the number of
    // the previously stocked product.
    @Override
    public void addStock(int stock) {
        this.numberOfItemsStocked += stock;
    }
    // This method will take the number of a product
    // to be removed from the stock, and subtract it
    // from the number of previously stocked
    // product.
    @Override
    public void removeStock(int stock) {
        this.numberOfItemsStocked -= stock;
    }
    // This method will take the new number of a
    // product to be stocked and delete the previous
    // number.
    @Override
    public void editStock(int stock) {
        this.numberOfItemsStocked = stock;
    }
    // This method will return a product from the
    // stock.
    @Override
    public Product getProduct() {
        return this;
    }

    // Override methods extended from Product class
    @Override
      public abstract  String getInfo();

    // Comparators
    public static Comparator<StockableProduct> priceComparator = new Comparator<StockableProduct>(){
        @Override
        public int compare(StockableProduct i1, StockableProduct i2){
            return Double.compare(i1.getPrice(), i2.getPrice());
        }
    };
    public static Comparator<StockableProduct> stockComparator = new Comparator<StockableProduct>(){
        @Override
        public int compare(StockableProduct i1, StockableProduct i2){
            return Double.compare(i1.getNumberOfItemsStocked(), i2.getNumberOfItemsStocked());
        }
    };

    // Override the default toString() method
    @Override
    public String toString() {
        return "StockableProduct [numberOfItemsStocked = " +  + numberOfItemsStocked + "]";
    }
}