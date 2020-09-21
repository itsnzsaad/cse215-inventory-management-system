package com.cse215.rrn.inventory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        /* *****************************************
            Start: Task 1
        ***************************************** */
        horizontalLine("Task 1", true);
        // Test objects provided
        // --------------------------------------
        Music m1 = new Music("submarine", 20, 2011, "Indie", 10, 100, "Alex Turner");
        Music m2 = new Music("AM", 10, 2013, "Indie", 5.5, 10, "Arctic Monkeys");
        Music m3 = new Music("Tranquility Base Hotel and Casino", 23, 2018, "Indie", 7.5, 500, "Arctic Monkeys");
        Music m4 = new Music("Rust in Peace", 33, 1990, "Metal", 2.5, 10, "Megadeth");
        Music m5 = new Music("Abbey Road", 25, 1969, "Rock", 7.8, 5, "The Beatles");
        Music m6 = new Music("The Dark Side of the Moon", 35, 1973, "Progressive Rock", 2.5, 10, "Pink Floyd");

        Movie v1 = new Movie("Good Will Hunting", 12, 1997, "Drama", 5.4, 123, "Gus Van Sant");
        Movie v2 = new Movie("Life Is Beautiful", 20, 1997, "Comedy-Drama", 2.6, 126, "Roberto Benigni");
        Movie v3 = new Movie("what's eating gilbert grape", 20, 1993, "Drama", 6.4, 122, "Lasse Hallstrom");
        Movie v4 = new Movie("The Godfather", 15, 1972, "Crime", .01, 125, "Francis Ford Coppola");
        Movie v5 = new Movie("The Rainmaker", 5, 1997, "Crime", 12, 127, "Francis Ford Coppola");
        Movie v6 = new Movie("Apocalypse Now", 24, 1979, "Drama", 4.9, 121, "Francis Ford Coppola");
        Movie v7 = new Movie("Leon the Professional", 21, 1994, "Drama", 2.7, 124, "Luc Besson");

        Game g1 = new Game("Red Dead Redemption 2", 29, 2018, "Survival", 3.7, 560, "RockStar");
        Game g2 = new Game("God of War", 12, 2018, "Action", 5.6, 567, "Javaground");
        Game g3 = new Game("Grand Theft Auto V", 13, 2017, "Action", 2.3, 565, "RockStar");

        // The only object of Inventory class
        Inventory inventory = new Inventory();

        // Adding provided items to Inventory object
        // ---------------------------------------------
        inventory.addItem(m1);
        inventory.addItem(m2);
        inventory.addItem(m3);
        inventory.addItem(m4);
        inventory.addItem(m5);
        inventory.addItem(m6);

        inventory.addItem(v1);
        inventory.addItem(v2);
        inventory.addItem(v3);
        inventory.addItem(v4);
        inventory.addItem(v5);
        inventory.addItem(v6);
        inventory.addItem(v7);

        inventory.addItem(g1);
        inventory.addItem(g2);
        inventory.addItem(g3);

        for (StockableProduct i : inventory) {
            System.out.println(i.getInfo());
        }
        horizontalLine("Task 1", false);
        /* *****************************************
            End: Task 1
        ***************************************** */



        /* *****************************************
            Start: Task 2
        ***************************************** */
        horizontalLine("Task 2", true);
        // Create an invoice, and add
        // m1,m2,v1,v2,g1 to the invoice
        // object. Print the invoice.

        // Hint: getInvoice()

        // 2020-02-22 09:57:52
        // Name: submarine, Price: 20.0
        // Name: AM, Price: 10.0
        // Name: Good Will Hunting, Price: 12.0
        // Name: Life Is Beautiful, Price: 20.0
        // Name: Red Dead Redemption 2, Price: 29.0
        // Total price: 91.0
        // Price after discount: 86.21

        ArrayList<Product> productsForInvoice_task2 = new ArrayList<Product>();

        productsForInvoice_task2.add(inventory.getItem(0));
        productsForInvoice_task2.add(inventory.getItem(1));
        productsForInvoice_task2.add(inventory.getItem(6));
        productsForInvoice_task2.add(inventory.getItem(7));
        productsForInvoice_task2.add(inventory.getItem(13));

        Invoice invoice_task2 = new Invoice(productsForInvoice_task2);

        System.out.println(invoice_task2.getInvoice());

        horizontalLine("Task 2", false);
        /* *****************************************
            End: Task 2
        ***************************************** */



        /* *****************************************
            Start: Task 3
        ***************************************** */
        horizontalLine("Task 3", true);
        // Create an invoice, add
        // m1,m2,v1,v2,g1,g2, and do
        //  same as above

        // Hint: getInvoice()

        // 2020-02-22 10:01:26
        // Name: submarine, Price: 20.0
        // Name: AM, Price: 10.0
        // Name: Good Will Hunting, Price: 12.0
        // Name: Life Is Beautiful, Price: 20.0
        // Name: Red Dead Redemption 2, Price: 29.0
        // Name: God of War, Price: 12.0
        // Total price: 103.0
        // Price after discount: 51.5

        ArrayList<Product> productsForInvoice_task3 = new ArrayList<Product>();

        productsForInvoice_task3.add(inventory.getItem(0));
        productsForInvoice_task3.add(inventory.getItem(1));
        productsForInvoice_task3.add(inventory.getItem(6));
        productsForInvoice_task3.add(inventory.getItem(7));
        productsForInvoice_task3.add(inventory.getItem(13));
        productsForInvoice_task3.add(inventory.getItem(14));

        Invoice invoice_task_3 = new Invoice(productsForInvoice_task3);

        System.out.println(invoice_task_3.getInvoice());

        horizontalLine("Task 3", false);
        /* *****************************************
            End: Task 3
        ***************************************** */


        /* *****************************************
            Start: Task 4
        ***************************************** */
        horizontalLine("Task 4", true);
        // Find available games, in the
        // inventory object.

        // Red Dead Redemption 2
        // God of War
        // Grand Theft Auto V

        for (StockableProduct i : inventory) {
            if (i.getClass().getName().contains("Game")) {
                if (i.getNumberOfItemsStocked() > 0) {
                    System.out.println(i.getName());
                }
            }
        }
        horizontalLine("Task 4", false);
        /* *****************************************
            End: Task 4
        ***************************************** */


        /* *****************************************
            Start: Task 5
        ***************************************** */
        horizontalLine("Task 5", true);
        // Find the cheapest available
        // Music Album, print name and
        // price of the album

        // Name: AM, Price: 10.0

        inventory.sortByPrice();

        for (StockableProduct i : inventory) {
            if (i.getClass().getName().contains("Music")) {
                System.out.println("Name: " + i.getName() + ", Price: " + i.getPrice());
                break;
            }
        }

        horizontalLine("Task 5", false);
        /* *****************************************
            End: Task 5
        ***************************************** */



        /* *****************************************
            Start: Task 6
        ***************************************** */
        horizontalLine("Task 6", true);
        // Find All movies directed by
        // “Francis Ford Coppola”
        // Hint: you have the getInfo()
        // method, use string split and
        // string contains operations to
        // extract director name from
        // there

        // The Rainmaker
        // The Godfather
        // Apocalypse Now

        for (StockableProduct i : inventory) {
            if (i.getClass().getName().contains("Movie")) {
                if (i.getInfo().toLowerCase().contains(("Francis Ford Coppola").toLowerCase())) {
                    System.out.println(i.getName());
                }
            }
        }

        horizontalLine("Task 6", false);
        /* *****************************************
            End: Task 6
        ***************************************** */




        /* *****************************************
            Start: Bonus
        ***************************************** */
        horizontalLine("Bonus", true);
        // Suppose the company is now renting out movies and games. Add this functionality to the
        // code. They are going to rent on a per hour basis

        ArrayList<Product> productsForInvoice_task_bonus = new ArrayList<Product>();

        productsForInvoice_task_bonus.add(inventory.getItem(0));
        productsForInvoice_task_bonus.add(inventory.getItem(1));
        productsForInvoice_task_bonus.add(inventory.getItem(6));
        productsForInvoice_task_bonus.add(inventory.getItem(7));
        productsForInvoice_task_bonus.add(inventory.getItem(13));
        productsForInvoice_task_bonus.add(inventory.getItem(14));

        Invoice invoice_task_bonus = new Invoice(productsForInvoice_task_bonus);

        System.out.println(invoice_task_bonus.rentItems(
                StringToDate("2020-06-04 12:00:00"),
                StringToDate("2020-06-04 15:00:00")
        ));


        horizontalLine("Bonus", false);
        /* *****************************************
            End: Bonus
        ***************************************** */
    }

    // Horizontal Line
    public static void horizontalLine(String title, boolean start) {
        String string = "";
        if (start) string += "\n";
        string += "----------";
        if (start) string += " Start: ";
        else string += "  End: ";
        string += title;
        string += " ----------";
        System.out.println(string);
    }

    // Turn String to Date
    public static Date StringToDate(String s) {
        Date result = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result = dateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
