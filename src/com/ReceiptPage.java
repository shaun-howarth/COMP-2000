package com;

import javax.swing.*;
import java.awt.*;

public class ReceiptPage extends JFrame {
    private JPanel mainPanel;
    private JTextArea listtextArea;
    private JButton homeBtn;

    public ReceiptPage() {

        setTitle("Receipt Page");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();

    }

    public static void main (String[] args) {

        ReceiptPage page = new ReceiptPage();
        page.setVisible(true);
    }


}
