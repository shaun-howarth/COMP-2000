package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingPage extends JFrame {
    private JPanel mainPanel;
    private JButton kioskBtn;
    private JButton loginBtn;
    private JButton exitBtn;

    public LandingPage() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();

        // Continue with Event listener

    }

    public static void main(String[] args){

        LandingPage page = new LandingPage();
        page.setVisible(true);

    }


}
