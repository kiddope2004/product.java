
package com.mycompany.product;

/**
 *
 * @author THABISO TJALE
 */
public class Product {

    // Product names and monthly sales
    private String[] productNames;
    private int[][] productSales;

    // Constructor
    public Product(String[] productNames, int[][] productSales) {
        this.productNames = productNames;
        this.productSales = productSales;
    }

    // Calculate total products sold
    public int GetTotalProductsSold() {
        int total = 0;

        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {
                total += productSales[i][j];
            }
        }

        return total;
    }

    // Calculate average products sold
    public double GetAverageProductsSold() {
        int total = GetTotalProductsSold();
        int count = 0;

        for (int i = 0; i < productSales.length; i++) {
            count += productSales[i].length;
        }

        if (count == 0) {
            return 0;
        }

        return (double) total / count;
    }

    // Find the most popular product
    public String GetMostPopularProduct() {
        int maxSale = -1;
        String popularProduct = "";

        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {

                if (productSales[i][j] > maxSale) {
                    maxSale = productSales[i][j];
                    popularProduct = productNames[i];
                }
            }
        }

        return popularProduct + " (" + maxSale + ")";
    }

    // Main method
    public static void main(String[] args) {

        String[] productNames = {
            "Cozy Nights Monarch",
            "Product B",
            "Product C"
        };

        int[][] productSales = {
            {10, 15, 25},
            {12, 18, 20},
            {5, 8, 14}
        };

        Product product = new Product(productNames, productSales);

        System.out.println("===== PRODUCT SALES REPORT =====");

        System.out.println("Total Products Sold: "
                + product.GetTotalProductsSold());

        System.out.println("Average Products Sold: "
                + product.GetAverageProductsSold());

        System.out.println("Most Popular Product: "
                + product.GetMostPopularProduct());
    }
}
