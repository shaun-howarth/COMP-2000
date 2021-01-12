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

    public StockdbPage() {

        setTitle("Stock Database Page");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();




        //Hover cursor effect for all Jbuttons

        homeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        viewStockBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));


        // Event listener for home button: will go to Landing Page

        homeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LandingPage s = new LandingPage();
                s.setVisible(true);
                dispose();
            }
        });




        //Action listener for "view stock button" to read in stock.txt flat data file into JTable

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



        // Defining Model object for Data that can be read into Stock JTable

        DefaultTableModel model = new DefaultTableModel();
        stockTable.setModel(model);
        stockTable.getTableHeader().setReorderingAllowed(false);




        //Mouse Listener for Add stock item button

        addBtn.addMouseListener(new MouseAdapter() {
            @Override

            //Method used to pass through and add/write data to "stock.txt" file when JText fields are filled.

            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
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

                        //Message warning to show JText Fields are null upon leaving JTextFields blank when clicking add item button.
                        JOptionPane.showMessageDialog(null,"Product item added to Database");
                    } catch (Exception event) {
                        event.printStackTrace();
                    }

                }
            }
        });



    }


    public static void main (String[] args) {

        StockdbPage page = new StockdbPage();
        page.setVisible(true);
    }



}
