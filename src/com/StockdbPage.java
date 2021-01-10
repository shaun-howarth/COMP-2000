package com;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Logger;


public class StockdbPage extends JFrame {
    private JPanel mainPanel;
    private JButton homeBtn;
    private JTable stockTable;
    private JButton viewStockBtn;
    private JPanel stockPanel;
    private JPanel tablePanel;

    public StockdbPage() {

        setTitle("Stock Database Page");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();




        //Hover cursor effect for all Jbuttons

        homeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));


        // Event listener for home button: will go to Landing Page

        homeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LandingPage s = new LandingPage();
                s.setVisible(true);
                dispose();
            }
        });



        //Calling method "createTable" to display field names for stock DB table
        createTable();




        viewStockBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String filepath = "resources\\data.csv";
                File file = new File(filepath);

                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String firstLine = br.readLine().trim();
                    String[] columnsName = firstLine.split(",");
                    DefaultTableModel model = (DefaultTableModel) stockTable.getModel();
                    model.setColumnIdentifiers();


                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TextFileDataToJTable.class.getName()).log(level.SEVERE, null, ex);
                }



            }
        });




    }


    public JPanel getStockPanel (){
        return tablePanel;
    }



    private void createTable() {
        stockTable.setModel(new DefaultTableModel(
                null,
                new String[] {"Name", "Price", "Quantity", "Barcode"}
        ));

    }




    public static void main (String[] args) {

        StockdbPage page = new StockdbPage();
        page.setVisible(true);
    }



}
