package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardPage extends JFrame {
    private JPanel mainPanel;
    private JPanel cardPanel;
    private JButton payBtn;
    private JTextArea cardArea;


    public CardPage() {

        setTitle("Card Page");
        setContentPane(mainPanel);
        setContentPane(cardPanel);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(400,400));
        pack();


        //Hover cursor effect for all Jbuttons
        payBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));


        //Event listener for Pay Now button
        payBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Card Accepted: Thank You for shopping!");
            }
        });
    }

    public static void main (String[] args) {
        CardPage page = new CardPage();
        page.setVisible(true);
    }


}

