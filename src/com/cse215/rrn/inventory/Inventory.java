package com.cse215.rrn.inventory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Inventory implements Iterable<StockableProduct> {
    // Properties
    private ArrayList<StockableProduct> items = new ArrayList<StockableProduct>();

    // Constructors
    public Inventory() {}

    // Implementing Iterator
    public Iterator<StockableProduct> iterator() {
        return this.items.iterator();
    }

    //    This method will take an object of
    //    StockableProduct as parameter and add that
    //    object to the items list.
    public void addItem(StockableProduct item) {
        items.add(item);
    }

    //    This method will take productId as parameter,
    //    Search for the object by product id and then
    //    remove that object from the items list.
    public void removeItem(int productId) {
       items.removeIf(item -> item.getProductId() == productId);
    }

    //    This method will take productId as parameter,
    //    and return a Product form the stock of that
    //    StockableProduct.
    //
    //    Hint: you have to decrement the
    //    numberOfItemsStocked, which is the count
    //    of stock of that specific product. You can use
    //    the removeStock method to do so.
    public Product getItem(int productId) {
        Product product = null;

        for(StockableProduct i : items) {
            if (i.getProductId() == productId) {
                product = i.getProduct();
                i.removeStock(1);
                break;
            }
        }

        return product;
    }

    //    This method will take productId and number
    //    of items to be stocked of a product as parameter.

    //    You have to search for that product, then add
    //    the number of items to be stocked to the
    //    numberOfItemsStocked field.
    public void addProductStock(int productId, int numberOfNewStock) {
       for(StockableProduct item: items) {
           if(item.getProductId() == productId) {
               item.addStock(numberOfNewStock);
               break ;
           }
       }
    }

    //    This method will sort the Inventory by price of
    //    products.
    public void sortByPrice(){
        Comparator c = StockableProduct.priceComparator;
        Collections.sort(items, c);
    }


    //    This method will sort the Inventory by
    //    available stock of products.
    public void sortByAvailableStock() {
       Comparator c = StockableProduct.stockComparator;
        Collections.sort(items, c);
    }
}
