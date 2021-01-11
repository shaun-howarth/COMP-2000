package com;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public StockdbPage() {

        setTitle("Stock Database Page");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();




        //Hover cursor effect for all Jbuttons

        homeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        viewStockBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));


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




    }



    public static void main (String[] args) {

        StockdbPage page = new StockdbPage();
        page.setVisible(true);
    }



}
