package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardPage extends JFrame {
    private JPanel mainPanel;
    private JPanel cardPanel;
    private JButton payBtn;
    private JTextArea textArea1;


    public CardPage() {
        setContentPane(mainPanel);
        setContentPane(cardPanel);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(400,400));
        pack();


        payBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));



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

