package com;

import javax.swing.*;
import java.awt.*;

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

    }


    public static void main (String[] args) {

        PaymentPage page = new PaymentPage();
        page.setVisible(true);
    }



}
