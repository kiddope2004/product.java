
package com.mycompany.product;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author THABISO TJALE
 */
public class GetTotalProductSales_withValidData_ReturnsCorrectValue {

    @Test
    public void GetTotalProductsSales_WithValidData_ReturnsCorrectValue() {

        // Arrange
        String[] productNames = {
            "Laptop",
            "Phone",
            "Tablet"
        };

        int[][] productSales = {
            {10},
            {20},
            {30}
        };

        Product report = new Product(productNames, productSales);

        // Act
        int result = report.GetTotalProductsSold();

        // Assert
        assertEquals(60, result);
    }
}
