package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentPage extends JFrame {
    private JPanel mainPanel;
    private JButton cashBtn;
    private JButton cardBtn;
    private JTextArea totaltextArea;


    public PaymentPage() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();


        //Hover cursor effect for all Jbuttons

        cashBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cardBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Event listener for cash payment button: goes to CashPage with price amount

        cashBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CashPage s = new CashPage();
                s.setVisible(true);
            }
        });

        // Event listener for card payment button: goes to CardPage with price amount

        cardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardPage s = new CardPage();
                s.setVisible(true);
            }
        });
    }


    public static void main (String[] args) {

        PaymentPage page = new PaymentPage();
        page.setVisible(true);
    }



}
