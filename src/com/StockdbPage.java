package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockdbPage extends JFrame {
    private JPanel mainPanel;
    private JTextArea stockArea;
    private JButton homeBtn;

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
    }

    public static void main (String[] args) {

        StockdbPage page = new StockdbPage();
        page.setVisible(true);
    }



}
