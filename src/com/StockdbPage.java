package com;

import javax.swing.*;
import java.awt.*;

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

    }

    public static void main (String[] args) {

        StockdbPage page = new StockdbPage();
        page.setVisible(true);
    }



}
