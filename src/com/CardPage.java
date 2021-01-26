package com;

import javax.swing.*;
import java.awt.*;

public class CardPage extends JFrame {
    private JPanel mainPanel;



    public CardPage() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(400,400));
        pack();
    }

    public static void main (String[] args) {
        CardPage page = new CardPage();
        page.setVisible(true);
    }


}

