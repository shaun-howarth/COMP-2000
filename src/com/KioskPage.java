package com;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class KioskPage extends JFrame {
    private JPanel mainPanel;
    private JButton clearBtn;
    private JButton cashBtn;
    private JButton homeBtn;
    private JPanel kioskPanel;
    private JButton scanBtn;
    private JTable productsTable;
    private JButton productsBtn;
    private JTextArea listArea;
    private JButton cardBtn;
    private JTextField productField;
    private JTextField quantityField;
    private JButton printBtn;


    public KioskPage() {

        setTitle("Kiosk User Interface");
        setContentPane(mainPanel);
        setContentPane(kioskPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1400, 800));
        pack();


        //Hover cursor effect for all Jbuttons
        homeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cashBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cardBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        scanBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        productsBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));


        // Event listener for home button: to go to landing page
        homeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LandingPage s = new LandingPage();
                s.setVisible(true);
                dispose();
            }
        });


        // Event listener for pay cash button: to go to cash page
        cashBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CashPage s =new CashPage();
                s.setVisible(true);
            }
        });


        // Event listener for pay card button: to go to card page
        cardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CardPage s = new CardPage();
                s.setVisible(true);
            }
        });


        //Creates table
        // Defining Model object for Data that can be read in/written from Products JTable
        //Placing string values for Column header names in Stock table
        String[] columnIdentifiers = new String[]{"Name", "Price (£)", "Quantity Remaining", "Barcode"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnIdentifiers);
        productsTable.setModel(model);
        productsTable.getTableHeader().setReorderingAllowed(false);


        // Event listener for View Products button
        // Customers press the "View Products" buttons to see products they want to scan from the stock list
        productsBtn.addActionListener(new ActionListener() {
            @Override
            //Method used to read in data from text to JTable on GUI form.
            public void actionPerformed(ActionEvent e) {
                String filepath = "resources\\stock.txt";
                File file = new File(filepath);

                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String firstLine = br.readLine().trim();
                    String[] columnsName = firstLine.split(",");
                    DefaultTableModel model = (DefaultTableModel) productsTable.getModel();
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


        //Event Listener for scan product button
        scanBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel model = (DefaultTableModel) productsTable.getModel();

                //variables for if statement used to display values in kiosk listArea
                int Item = productsTable.getSelectedRow();
                double cost;
                double productTot;

                cost = Double.parseDouble(model.getValueAt(Item, 1).toString());
                productTot = cost * Double.parseDouble(quantityField.getText());


                if (productField.getText().isEmpty() || quantityField.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Missing Data");
                }

                else{
                    if(!listArea.getText().contains("  ==========JAVA-STORE==========\n"))
                    {
                        listArea.setText(listArea.getText()+"  ==========JAVA-STORE==========\n"+"PRODUCT      QUANTITY                              PRICE(£)                              BARCODE                         TOTAL\n\n" + productField.getText() + "  " + quantityField.getText() + "  " + productsTable.getValueAt(Item, 1) + "  " + productsTable.getValueAt(Item, 3) + "          " + productTot + "\n");
                    }
                    else{
                        listArea.setText(listArea.getText() + productField.getText() + "  " + quantityField.getText() + "  " + productsTable.getValueAt(Item, 1) + "  " + productsTable.getValueAt(Item, 3) + "          " + productTot + "\n");

                    }
                }
            }
        });


        //Event Listener used for clear button that removes selected products from basket listArea: if a customer had scanned an item they didn't want
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==clearBtn) {
                    listArea.setText("");
                }
            }
        });


        //Event Listener for productsTable
        productsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                DefaultTableModel model = (DefaultTableModel) productsTable.getModel();
                //Variable "selectedRowIndex" used to set the selected row value into productField
                int selectedRowIndex = productsTable.getSelectedRow();

                //product name being at column "0" in JTable to be displayed in productField when product is selected
                productField.setText(model.getValueAt(selectedRowIndex, 0).toString());
            }
        });


        printBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    public static void main (String[] args) {

        KioskPage page = new KioskPage();
        page.setVisible(true);
    }


}
