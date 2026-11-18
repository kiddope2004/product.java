
package com.mycompany.mattresssalesapp;

import java.util.Scanner;

/**
 *
 * @author THABISO TJALE
 */
public class MattressSalesApp {

    static Scanner input = new Scanner(System.in);

    // Mattress products
    static String[] products = {
        "Single Mattress",
        "Three Quarter Mattress",
        "Double Mattress",
        "Queen Mattress",
        "King Mattress",
        "Luxury Orthopaedic Mattress"
    };

    // Mattress prices
    static double[] prices = {
        1800.00, 2400.00, 3200.00,
        4200.00, 5500.00, 6800.00
    };

    // Available stock
    static int[] stock = {10, 10, 10, 10, 10, 10};

    // Sales information
    static double totalSales = 0;
    static int totalItemsSold = 0;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("       MATTRESS SALES APP");
            System.out.println("================================");
            System.out.println("1. View Mattresses");
            System.out.println("2. Make a Sale");
            System.out.println("3. View Stock");
            System.out.println("4. Sales Report");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!input.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                input.nextLine();
                choice = 0;
                continue;
            }

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    viewMattresses();
                    break;

                case 2:
                    makeSale();
                    break;

                case 3:
                    viewStock();
                    break;

                case 4:
                    salesReport();
                    break;

                case 5:
                    System.out.println(
                        "Thank you for using Mattress Sales App!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Please try again."
                    );
            }

        } while (choice != 5);

        input.close();
    }

    // Display available mattresses
    static void viewMattresses() {

        System.out.println("\n----- AVAILABLE MATTRESSES -----");

        for (int i = 0; i < products.length; i++) {

            System.out.println(
                (i + 1) + ". " + products[i] +
                " - R" + String.format("%.2f", prices[i])
            );
        }
    }

    // Process mattress sale
    static void makeSale() {

        System.out.print("\nEnter customer name: ");
        String customer = input.nextLine().trim();

        if (customer.isEmpty()) {
            System.out.println("Customer name cannot be empty.");
            return;
        }

        viewMattresses();

        System.out.print("\nSelect mattress number: ");

        if (!input.hasNextInt()) {
            System.out.println("Invalid product selection.");
            input.nextLine();
            return;
        }

        int productChoice = input.nextInt();
        input.nextLine();

        if (productChoice < 1 || productChoice > products.length) {
            System.out.println("Invalid product selection.");
            return;
        }

        int index = productChoice - 1;

        System.out.print("Enter quantity: ");

        if (!input.hasNextInt()) {
            System.out.println("Please enter a valid quantity.");
            input.nextLine();
            return;
        }

        int quantity = input.nextInt();
        input.nextLine();

        if (quantity <= 0) {
            System.out.println(
                "Quantity must be greater than zero."
            );
            return;
        }

        if (quantity > stock[index]) {
            System.out.println("Insufficient stock!");
            System.out.println(
                "Available stock: " + stock[index]
            );
            return;
        }

        // Calculate sale
        double amount = prices[index] * quantity;

        // Use ProductCalculations class
        ProductCalculations calc =
            new ProductCalculations(amount);

        double vat = calc.GetVat();
        double commission = calc.GetCommission();
        double total = calc.GetTotal();

        // Update stock and sales
        stock[index] -= quantity;
        totalSales += total;
        totalItemsSold += quantity;

        // Display receipt
        System.out.println("\n========== SALES RECEIPT ==========");
        System.out.println("Customer: " + customer);
        System.out.println("Product: " + products[index]);
        System.out.println("Quantity: " + quantity);

        System.out.println(
            "Unit Price: R" +
            String.format("%.2f", prices[index])
        );

        System.out.println(
            "Subtotal: R" +
            String.format("%.2f", amount)
        );

        System.out.println(
            "VAT (15%): R" +
            String.format("%.2f", vat)
        );

        System.out.println(
            "Commission (5%): R" +
            String.format("%.2f", commission)
        );

        System.out.println("-----------------------------------");

        System.out.println(
            "TOTAL: R" + String.format("%.2f", total)
        );

        System.out.println("===================================");

        System.out.println("Sale completed successfully!");
    }

    // Display available stock
    static void viewStock() {

        System.out.println("\n--------- STOCK REPORT ---------");

        for (int i = 0; i < products.length; i++) {

            System.out.println(
                products[i] + " | Stock: " + stock[i]
            );
        }
    }

    // Display sales report
    static void salesReport() {

        System.out.println("\n========= SALES REPORT =========");

        System.out.println(
            "Total Items Sold: " + totalItemsSold
        );

        System.out.println(
            "Total Sales: R" +
            String.format("%.2f", totalSales)
        );

        System.out.println("================================");
    }
}
