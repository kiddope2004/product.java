
package com.mycompany.mattresssalesapp;

/**
 *
 * @author THABISO TJALE
 */
public class ProductCalculations extends IProductCalculations {

    private double price;

    // Constructor
    public ProductCalculations(double price) {
        this.price = price;
    }

    // Calculate VAT (15%)
    
    public double GetVat() {
        return price * 0.15;
    }

    // Calculate Commission (5%)
    
    public double GetCommission() {
        return price * 0.05;
    }

    // Calculate Total
    
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}


