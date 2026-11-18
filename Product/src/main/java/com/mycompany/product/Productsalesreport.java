/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.product;

/**
 *
 * @author THABISO TJALE
 */
import java.util.Scanner;

public class Productsalesreport {

 public static void main(String[] args) {
 Scanner input = new Scanner(System.in);

 // Single-dimensional array for product names
 String[] products = {
 "Cozy Nights Monarch mattress",
 "Restonic Barbados mattress",
 "Sealy Phuket mattress"
 };

 // Two-dimensional array: 3 products x 3 months
 int[][] sales = new int[3][3];

 // Input - exactly like screenshot
 for (int i = 0; i < 3; i++) {
 for (int j = 0; j < 3; j++) {
 System.out.print("Enter number of sales for month " + (j + 1)
 + " for " + products[i] + ": ");
 sales[i][j] = input.nextInt();
 }
 System.out.println();
 }

 // Use the Product class
 Product product = new Product(products, sales); {

 int total = product.GetTotalProductsSold();
 // Round average to whole number: 17
 int average = (int) Math.round(product.GetAverageProductsSold());
 String popular = product.GetMostPopularProduct();

 // Output 
 System.out.println("PRODUCT SALES REPORT - 2026");
 System.out.println();
 System.out.println("******************************************");
 System.out.println("TOTAL PRODUCT SALES: " + total);
 System.out.println("AVERAGE PRODUCT SALES: " + average);
 System.out.println("MOST POPULAR PRODUCT: " + popular);
 
 }
 }
}
 
 

    

