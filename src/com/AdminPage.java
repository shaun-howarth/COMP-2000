package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import static java.util.Map.entry;


public class AdminPage extends JFrame {
    private JPanel mainPanel;
    private JButton loginBtn;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton homeBtn;
    private JPanel adminPanel;
    private JLabel messageLabel;
    private JButton resetBtn;


    public AdminPage() {

        setTitle("Admin Login Page: to view Stock Database");
        setContentPane(mainPanel);
        setContentPane(adminPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 400));
        pack();


        //Hover cursor effect for all Jbuttons
        homeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resetBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));


        //Customisation for messageLabel for user logging in
        messageLabel.setFont(new Font(null,Font.ITALIC,20));


        // Event listener for home button: will go to landing page
        homeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LandingPage s = new LandingPage();
                s.setVisible(true);
                dispose();
            }
        });


        // Event listener for Reset fields button: to remove characters from username & password field
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==resetBtn) {
                    usernameField.setText("");
                    passwordField.setText("");
                }
            }
        });


        // Event listener for admin login button: will go to open StockdbPage
        // Only if login is successful
        loginBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if(e.getSource()==loginBtn) {
                    //Assigning username and password attributes to get the text that's entered into username & password field
                    String UserName = usernameField.getText();
                    String Password = String.valueOf(passwordField.getPassword());

                    //If password values from any of the two Key username values from the HashMap are correct
                    //The admin user will be logged in
                    if(logininfo.containsKey(UserName)) {
                        if(logininfo.get(UserName).equals(Password)) {
                            messageLabel.setForeground(Color.green);
                            messageLabel.setText("Login Successful!");
                            StockdbPage stockdbPage = new StockdbPage(UserName);
                            stockdbPage.setVisible(true);
                            dispose();
                        }
                        else {
                            messageLabel.setForeground(Color.red);
                            messageLabel.setText("Wrong Password.");
                        }
                    }
                    else {
                        messageLabel.setForeground(Color.red);
                        messageLabel.setText("Username not found.");
                    }
                }
            }
        });
    }


    //HashMap being repeated for AdminPage class
    Map<String, String> logininfo = Map.ofEntries(
            entry("jasmith", "canErty6"),
            entry("apbellow", "Y$67975f")
    );


    //Constructor passing in "loginfo" HASHMAP
    AdminPage(Map<String, String> loginInfoOriginal) {
        logininfo = loginInfoOriginal;

    }


    public static void main(String[] args) {
        AdminPage adminPage = new AdminPage();
        adminPage.setVisible(true);
    }

}
