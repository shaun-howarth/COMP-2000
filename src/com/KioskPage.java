package com;

import javax.swing.*;
import java.awt.*;

public class KioskPage extends JFrame {
    private JPanel mainPanel;
    private JButton removeBtn;
    private JButton paymentBtn;
    private JTextArea scannedtextArea;
    private JTextArea pricetextArea;
    private JButton homeBtn;


    public KioskPage(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();
    }

    public static void main (String[] args){

        KioskPage page = new KioskPage();
        page.setVisible(true);
    }


}
