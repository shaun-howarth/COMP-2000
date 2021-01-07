package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KioskPage extends JFrame {
    private JPanel mainPanel;
    private JButton removeBtn;
    private JButton paymentBtn;
    private JTextArea scannedtextArea;
    private JTextArea pricetextArea;
    private JButton homeBtn;


    public KioskPage() {

        setTitle("Kiosk User Interface");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();


        //Hover cursor effect for all Jbuttons

        homeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        paymentBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        removeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

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

        paymentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaymentPage s = new PaymentPage();
                s.setVisible(true);
            }
        });
    }


    public static void main (String[] args) {

        KioskPage page = new KioskPage();
        page.setVisible(true);
    }


}
