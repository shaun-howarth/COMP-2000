package com;

import javax.swing.*;
import java.awt.*;

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

    }

    public static void main (String[] args) {

        AdminPage page = new AdminPage();
        page.setVisible(true);
    }



}
