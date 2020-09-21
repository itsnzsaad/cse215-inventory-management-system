package com.cse215.rrn.inventory;

public interface Stockable {
    //    This method will take the number of a product
    //    to be stocked, and add it with the number of
    //    the previously stocked product
    public void addStock(int stock);

    //    This method will take the number of a product
    //    to be removed from the stock, and subtract it
    //    from the number of previously stocked
    //    product.
    public void removeStock(int stock);

    //    This method will take the new number of a
    //    product to be stocked and delete the previous
    //    number
    public void editStock(int stock);

    //    This method will return a product from the
    //    stock
    public Product getProduct();
}
