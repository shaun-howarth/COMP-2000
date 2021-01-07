package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardPage extends JFrame {
    private JPanel mainPanel;
    private JButton receiptBtn;
    private JButton payBtn;
    private JTextArea verifytextArea;
    private JTextArea pricetextArea;


    public CardPage() {

        setTitle("Card Payment Page");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();


        //Hover cursor effect for all Jbuttons

        receiptBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        payBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));



        // Event listener for receipt button: goes to ReceiptPage with bought items

        receiptBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReceiptPage s = new ReceiptPage();
                s.setVisible(true);
            }
        });

        // Event listener for pay now button: Will show pop up message saying thank you for shopping
        //If Card is denied: Denied message will appear

        payBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPane, "Thank you for shopping!");
            }
        });
    }

    public static void main (String[] args) {

        CardPage page = new CardPage();
        page.setVisible(true);
    }


}
