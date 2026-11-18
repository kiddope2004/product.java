
package com.mycompany.product;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author THABISO TJALE
 */
public class GetAverageSales_withValidData_ReturnsCorrectValue {

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {

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
        double result = report.GetAverageProductsSold();

        // Assert
        assertEquals(20.0, result, 0.001);
    }
}
