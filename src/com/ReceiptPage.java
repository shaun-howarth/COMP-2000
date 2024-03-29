package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceiptPage extends JFrame {
    private JPanel mainPanel;
    private JTextArea receiptArea;
    private JButton closeBtn;
    private JPanel receiptPanel;


    public ReceiptPage() {

        setTitle("Receipt Page");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();


        //Hover cursor effect for all Jbuttons
        closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));


        // Event listener for home button: will go to Landing Page
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
            }
        });
    }


    public static void main (String[] args) {

        ReceiptPage page = new ReceiptPage();
        page.setVisible(true);
    }

}
