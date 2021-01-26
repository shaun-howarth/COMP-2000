package com;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StockdbPage extends JFrame {
    private JPanel mainPanel;
    private JButton homeBtn;
    private JTable stockTable;
    private JButton viewStockBtn;
    private JPanel stockPanel;
    private JPanel tablePanel;
    private JButton addBtn;
    private JTextField nameField;
    private JTextField priceField;
    private JTextField quantityField;
    private JTextField barcodeField;
    private JLabel welcomeLabel;
    private JButton removeBtn;
    private JButton updateBtn;
    private JButton emptyBtn;


    public StockdbPage(String UserName) {

        setTitle("Stock Database Page");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1500, 300));
        pack();


        // Customisation of text for welcomeLabel for logged in user
        welcomeLabel.setText("Hello "+UserName);
        welcomeLabel.setFont(new Font(null,Font.ITALIC,25));


        //Hover cursor effect for all Jbuttons
        homeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        viewStockBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        emptyBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        updateBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        removeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));



        // Event listener for home button: will go to Landing Page
        homeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LandingPage s = new LandingPage();
                s.setVisible(true);
                dispose();
            }
        });

        //Creates table
        // Defining Model object for Data that can be read in/written from Stock JTable
        //Placing named for Column header names in Stock table
        String[] columnIdentifiers = new String[]{"Name", "Price (£)", "Quantity Remaining", "Barcode"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnIdentifiers);
        stockTable.setModel(model);
        stockTable.getTableHeader().setReorderingAllowed(false);



        //Event listener for "view stock button" to read in stock.txt flat data file into JTable
        viewStockBtn.addActionListener(new ActionListener() {
            @Override
            //Method used to read in data from text to JTable on GUI form.
            public void actionPerformed(ActionEvent e) {
                String filepath = "resources\\stock.txt";
                File file = new File(filepath);

                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String firstLine = br.readLine().trim();
                    String[] columnsName = firstLine.split(",");
                    DefaultTableModel model = (DefaultTableModel) stockTable.getModel();
                    model.setColumnIdentifiers(columnsName);

                    Object[] tableLines = br.lines().toArray();

                    for (int i =0; i <tableLines.length; i++) {
                        String line = tableLines[i].toString().trim();
                        String[] dataRow = line.split("/");
                        model.addRow(dataRow);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(TextField.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        emptyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==emptyBtn) {
                    nameField.setText("");
                    priceField.setText("");
                    quantityField.setText("");
                    barcodeField.setText("");
                    JOptionPane.showMessageDialog(null, "Fields Clear: You can now enter new product details to create a new product row within the table!");
                }
            }
        });



        //Event Listener for Add stock item button
        addBtn.addMouseListener(new MouseAdapter() {
            @Override

            //Method used to pass through and add/write data to "stock.txt" file when JText fields are filled.
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //Message warning to show JText Fields are null upon leaving JTextFields blank when clicking add item button.
                if (nameField.getText().isEmpty() || priceField.getText().isEmpty() || quantityField.getText().isEmpty() || barcodeField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All Fields must be filled");
                } else {

                    try {
                        model.addRow(new Object[]{nameField.getText(), priceField.getText(), quantityField.getText(), barcodeField.getText()});

                        //BufferWriter instruction used to take string values entered into JText fields
                        BufferedWriter bw = null;
                        bw = new BufferedWriter(new FileWriter("resources\\stock.txt", true));
                        bw.write(nameField.getText() + "/" + priceField.getText() + "/" + quantityField.getText() + "/" + barcodeField.getText());
                        bw.newLine();
                        bw.flush();
                        bw.close();

                        JOptionPane.showMessageDialog(null,"Product item added to Database");
                    } catch (Exception event) {
                        event.printStackTrace();
                    }

                }
            }
        });





        removeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) stockTable.getModel();

                //delete row
                if (stockTable.getSelectedRowCount() == 1) {
                    //if single row is selected then delete
                    model.removeRow(stockTable.getSelectedRow());
                    JOptionPane.showMessageDialog(null, "Product removed from Stock Table!");

                } else {
                    if (stockTable.getRowCount() == 0) {
                        // if table is empty with (no data): display error message
                        JOptionPane.showMessageDialog(null, "Table is Empty!");
                    } else {
                        // if table is not empty or a row hasn't been selected or multiple rows have been selected
                        JOptionPane.showMessageDialog(null, "Please select an individual row for Deletion!");
                    }
                }
            }
        });


        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultTableModel model = (DefaultTableModel) stockTable.getModel();
                int i = stockTable.getSelectedRow();

                if (i >=0)
                {
                    model.setValueAt(nameField.getText(), i, 0);
                    model.setValueAt(priceField.getText(), i, 1);
                    model.setValueAt(quantityField.getText(), i, 2);
                    model.setValueAt(barcodeField.getText(), i, 3);
                    JOptionPane.showMessageDialog(null, "Product Information Updated: Please note, whatever input was made into each of the text fields above will be printed into Product Row!");
                }else {
                    JOptionPane.showMessageDialog(null, "Error!");
                }
            }
        });


        stockTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                DefaultTableModel model = (DefaultTableModel) stockTable.getModel();
                int selectedRowIndex = stockTable.getSelectedRow();

                nameField.setText(model.getValueAt(selectedRowIndex, 0).toString());
                priceField.setText(model.getValueAt(selectedRowIndex, 1).toString());
                quantityField.setText(model.getValueAt(selectedRowIndex, 2).toString());
                barcodeField.setText(model.getValueAt(selectedRowIndex, 3).toString());

            }
        });

    }








    public StockdbPage() {
    }

    public static void main (String[] args) {

        StockdbPage page = new StockdbPage();
        page.setVisible(true);
    }


}
