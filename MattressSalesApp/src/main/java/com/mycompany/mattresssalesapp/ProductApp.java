
package com.mycompany.mattresssalesapp;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author THABISO TJALE
 */
public class ProductApp extends JFrame {

    // Declare GUI components
    private JTextField txtCustomer;
    private JTextField txtPrice;
    private JComboBox<String> cmbProduct;
    private JButton btnProcess;

    // Constructor
    public ProductApp() {

        setTitle("Mattress Sales App");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create form
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 15));

        panel.setBorder(
            BorderFactory.createEmptyBorder(25, 25, 25, 25)
        );

        // Customer name
        panel.add(new JLabel("Customer Name:"));

        txtCustomer = new JTextField();
        panel.add(txtCustomer);

        // Product selection
        panel.add(new JLabel("Select Product:"));

        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        cmbProduct = new JComboBox<>(products);
        panel.add(cmbProduct);

        // Product price
        panel.add(new JLabel("Enter Price:"));

        txtPrice = new JTextField();
        panel.add(txtPrice);

        // Process button
        panel.add(new JLabel(""));

        btnProcess = new JButton("PROCESS");
        panel.add(btnProcess);

        add(panel);

        // Process button event
        btnProcess.addActionListener(e -> processSale());

        // Create menu
        createMenu();
    }

    // Create menu system
    private void createMenu() {

        JMenuBar menuBar = new JMenuBar();

        // File menu
        JMenu fileMenu = new JMenu("File");

        JMenuItem exitItem = new JMenuItem("Exit");

        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(exitItem);

        // Tools menu
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        processItem.addActionListener(e -> processSale());

        clearItem.addActionListener(e -> clearForm());

        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);
    }

    // Process sale
    private void processSale() {

        try {

            // Capture customer details
            String customer = txtCustomer.getText().trim();

            String product =
                (String) cmbProduct.getSelectedItem();

            if (customer.isEmpty()) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please enter customer name."
                );

                return;
            }

            // Capture price
            double price = Double.parseDouble(
                txtPrice.getText().trim()
            );

            if (!Double.isFinite(price) || price <= 0) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid positive price."
                );

                return;
            }

            // Create calculation object
            ProductCalculations calc =
                new ProductCalculations(price);

            // Calculate VAT, commission and total
            double vat = calc.GetVat();

            double commission = calc.GetCommission();

            double total = calc.GetTotal();

            // Prepare results
            String result =
                "Customer Name: " + customer +
                "\nProduct: " + product +
                "\nVAT: R " + String.format("%.2f", vat) +
                "\nCOMMISSION: R " +
                String.format("%.2f", commission) +
                "\nTOTAL: R " + String.format("%.2f", total);

            // Display results
            JOptionPane.showMessageDialog(
                this,
                result,
                "Sales Results",
                JOptionPane.INFORMATION_MESSAGE
            );

            // Save information to file
            saveToFile(customer, product, price,
                       vat, commission, total);

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter a valid numeric price."
            );
        }
    }

    // Save information to data.txt
    private void saveToFile(
        String customer,
        String product,
        double price,
        double vat,
        double commission,
        double total
    ) {

        try (PrintWriter writer =
            new PrintWriter(
                new FileWriter("data.txt", true)
            )) {

            writer.println("MATTRESS SALES REPORT");
            writer.println("********************************");
            writer.println("Customer Name: " + customer);
            writer.println("Product: " + product);
            writer.println("Price: R " + String.format("%.2f", price));
            writer.println("VAT: R " + String.format("%.2f", vat));
            writer.println("COMMISSION: R " +
                           String.format("%.2f", commission));
            writer.println("TOTAL: R " +
                           String.format("%.2f", total));
            writer.println("********************************");
            writer.println();

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(
                this,
                "Error saving data to file: " + ex.getMessage()
            );
        }
    }

    // Clear form
    private void clearForm() {

        txtCustomer.setText("");
        txtPrice.setText("");

        cmbProduct.setSelectedIndex(0);
    }

    // Main method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ProductApp app = new ProductApp();

            app.setVisible(true);
        });
    }
}
