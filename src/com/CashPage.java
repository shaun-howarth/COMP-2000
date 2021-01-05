package com;

import javax.swing.*;
import java.awt.*;

public class CashPage extends JFrame {
    private JPanel mainPanel;
    private JButton receiptBtn;
    private JButton payBtn;
    private JTextField cashField;
    private JTextArea pricetextArea;
    private JTextArea changetextArea;


    public CashPage() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();

    }

    public static void main (String[] args) {

        CashPage page = new CashPage();
        page.setVisible(true);
    }



}
