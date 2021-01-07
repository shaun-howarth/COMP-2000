package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage extends JFrame {
    private JPanel mainPanel;
    private JButton loginBtn;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton homeBtn;


    public AdminPage() {

        setTitle("Admin Login Page: to view Stock Database");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();


        //Hover cursor effect for all Jbuttons

        homeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));


        // Event listener for home button: will go to landing page

        homeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LandingPage s = new LandingPage();
                s.setVisible(true);
            }
        });

        // Event listener for admin login button: will go to stock DB
        // Only if login is successful

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StockdbPage s = new StockdbPage();
                s.setVisible(true);
            }
        });
    }





    public static void main (String[] args) {

        AdminPage page = new AdminPage();
        page.setVisible(true);
    }



}
