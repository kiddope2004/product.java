/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.mattresssalesapp;

/**
 *
 * @author THABISO TJALE
 */
public interface IProducalculationinterfaces {
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
    
}
