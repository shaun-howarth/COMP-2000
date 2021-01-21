package com;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
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
    private JButton removeBtn;
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
        setPreferredSize(new Dimension(800, 600));
        pack();


        //Hover cursor effect for all Jbuttons
        homeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cashBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        removeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        scanBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));


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




        DefaultTableModel model = new DefaultTableModel();
        productsTable.setModel(model);
        productsTable.getTableHeader().setReorderingAllowed(false);




        scanBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                TableModel model1 = productsTable.getModel();
                int[] indexes = productsTable.getSelectedRows();
                Object[] row = new Object[13];
                DefaultTableModel model2 = (DefaultTableModel) listArea.();
                for (int i = 0; i < indexes.length; i++) {
                    row[0] = model1.getValueAt(indexes[i], 0);
                    row[1] = model1.getValueAt(indexes[i], 1);
                    row[2] = model1.getValueAt(indexes[i], 2);
                    row[3] = model1.getValueAt(indexes[i], 3);
                    row[4] = model1.getValueAt(indexes[i], 4);
                    row[5] = model1.getValueAt(indexes[i], 5);
                    row[6] = model1.getValueAt(indexes[i], 6);
                    row[7] = model1.getValueAt(indexes[i], 7);
                    row[8] = model1.getValueAt(indexes[i], 8);
                    row[9] = model1.getValueAt(indexes[i], 9);
                    row[10] = model1.getValueAt(indexes[i], 10);
                    row[11] = model1.getValueAt(indexes[i], 11);
                    row[12] = model1.getValueAt(indexes[i], 12);
                    model2.addRow(row);
                }
            }
        });

    }


    public static void main (String[] args) {

        KioskPage page = new KioskPage();
        page.setVisible(true);
    }


}
