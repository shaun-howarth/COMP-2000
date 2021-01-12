package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;



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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();



        //Hover cursor effect for all Jbuttons

        homeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resetBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        //Fonts and other customisations

        messageLabel.setFont(new Font(null,Font.ITALIC,25));


        // Event listener for home button: will go to landing page

        homeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LandingPage s = new LandingPage();
                s.setVisible(true);
                dispose();
            }
        });

        // Event listener for admin login button: will go to stock DB
        // Only if login is successful


        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource()==loginBtn) {
                    String UserName = usernameField.getText();
                    String Password = String.valueOf(passwordField.getPassword());

                    if(logininfo.containsKey(UserName)) {
                        if(logininfo.get(UserName).equals(Password)) {
                            messageLabel.setForeground(Color.green);
                            messageLabel.setText("Login Successful");

                        }
                    }
                }
            }
        });




        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==resetBtn) {
                    usernameField.setText("");
                    passwordField.setText("");
                }

            }
        });


    }



    HashMap<String,String> logininfo = new HashMap<String,String>();

    AdminPage(HashMap<String,String> loginInfoOriginal) {
        logininfo = loginInfoOriginal;

    }







    public static void main(String[] args) {
        AdminPage adminPage = new AdminPage();
        adminPage.setVisible(true);

    }


}
