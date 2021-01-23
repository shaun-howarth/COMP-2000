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


    public KioskPage() {

        setTitle("Kiosk User Interface");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1200, 800));
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


        // Event listener for payment button: to go to payment page
        cashBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        //Creates table
        // Defining Model object for Data that can be read in/written from Products JTable
        //Placing named for Column header names in Stock table
        String[] columnIdentifiers = new String[]{"Name", "Price (£)", "Quantity Remaining", "Barcode"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnIdentifiers);
        productsTable.setModel(model);
        productsTable.getTableHeader().setReorderingAllowed(false);



        // Event listener for View Products button
        // Customers press the "View Products" buttons to see products they want to scan from the stock list

        productsBtn.addActionListener(new ActionListener() {
            @Override
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





        scanBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                DefaultTableModel model = (DefaultTableModel) productsTable.getModel();
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
                        listArea.setText(listArea.getText()+"  ==========JAVA-STORE==========\n"+"PRODUCT    PRICE(£)    QUANTITY    TOTAL\n" + productField.getText() + "                    " + quantityField.getText() + "                    " + productsTable.getValueAt(Item, 1) + "                    " + productTot + "\n");
                    }
                    else{
                        listArea.setText(listArea.getText() + productField.getText() + "                    " + quantityField.getText() + "                    " + productsTable.getValueAt(Item, 1) + "                    " + productTot + "\n");

                    }


                }

            }
        });


    }


    public static void main (String[] args) {

        KioskPage page = new KioskPage();
        page.setVisible(true);
    }


}
