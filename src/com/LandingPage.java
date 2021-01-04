package com;

import javax.swing.*;
import java.awt.*;

public class LandingPage extends JFrame {
    private JPanel mainPanel;

    public LandingPage() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();
    }

    public static void main(String[] args){

        LandingPage page = new LandingPage();
        page.setVisible(true);

    }


}
