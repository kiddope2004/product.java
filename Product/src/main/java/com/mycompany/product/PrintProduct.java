
package com.mycompany.product;

/**
 *
 * @author THABISO TJALE
 */
public class PrintProduct {

    private Product report;

    // Constructor
    public PrintProduct(Product report) {
        this.report = report;
    }

    // Print total product sales
    public void PrintTotalProductSales() {
        System.out.println(
            "Total Products Sold: "
            + report.GetTotalProductsSold());
    }

    // Print average product sales
    public void PrintAverageProductSales() {
        System.out.println(
            "Average Products Sold: "
            + report.GetAverageProductsSold());
    }

    // Print most popular product
    public void PrintMostPopularProduct() {

        System.out.println(
            "Most Popular Product: "
            + report.GetMostPopularProduct());
    }

}
