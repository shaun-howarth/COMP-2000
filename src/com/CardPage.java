package com;

import javax.swing.*;
import java.awt.*;

public class CardPage extends JFrame {
    private JPanel mainPanel;
    private JButton receiptBtn;
    private JButton payBtn;
    private JTextArea verifytextArea;
    private JTextArea pricetextArea;


    public CardPage() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();

    }

    public static void main (String[] args) {

        CardPage page = new CardPage();
        page.setVisible(true);
    }


}
