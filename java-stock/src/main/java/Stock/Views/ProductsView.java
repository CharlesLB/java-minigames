package Stock.Views;

import Stock.Models.Product;
import Stock.Utils.Screen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ProductsView extends JFrame {
    private JPanel container;
    private JTable table;
    private JButton removeButton;
    private JButton addButton;
    private JTextField nameInput;
    private JTextField valueInput;
    private JTextField quantityInput;
    private JTextArea descriptionTextArea;
    private JLabel nameLabel;
    private JLabel valueLabel;
    private JLabel quantityLabel;
    private JLabel descriptionLabel;

    private List<Product> products = new ArrayList<>();

    public ProductsView() throws HeadlessException {
        createProductsTable();
        setupListeners();
        render();
    }

    private void render() {
        setContentPane(container);
        setTitle("Stock Control | Products");
        setSize(Screen.width, Screen.height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createProductsTable() {
        String[] columns = { "Name", "Value", "Quantity", "Description" };

        table.setModel(new DefaultTableModel(null, columns));
    }

    private void setupListeners() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    addProduct();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeProduct();
            }
        });
    }

    private void addProduct() {
        try {
            String name = nameInput.getText();
            Double value = Double.parseDouble(valueInput.getText());
            int quantity = Integer.parseInt(quantityInput.getText());
            String description = descriptionTextArea.getText();

            if (name.isEmpty() || value.isNaN() || quantity <= 0 || description.isEmpty()) {
                printError("Invalid Value!");
            }

            Product product = new Product(name, value, quantity, description);
            products.add(product);

            String[] newRow = { name, Double.toString(value), Integer.toString(quantity), description };

            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            tableModel.addRow(newRow);

            resetForm();
        } catch (Exception ex) {
            printError("Invalid Value!");
        }
    }

    private void removeProduct() {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

        if (table.getSelectedRowCount() == 0) {
            printError("No rows selected");
            return;
        }

        if (table.getRowCount() == 0) {
            printError("There is no data in the table");
            return;
        }

        printList();

        products.remove(table.getSelectedRow());
        tableModel.removeRow(table.getSelectedRow());
    }

    private void printList() {
        for (Product product : products) {
            System.out.println(product.getName());
        }
    }

    private void resetForm() {
        nameInput.setText("");
        valueInput.setText("");
        quantityInput.setText("");
        descriptionTextArea.setText("");
    }

    private void printError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.INFORMATION_MESSAGE);
    }
}
