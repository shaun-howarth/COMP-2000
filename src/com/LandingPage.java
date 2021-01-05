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


        //Hover cursor effect for all Jbuttons

        kioskBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Event listener for Kiosk interface button: to go to kiosk page

        kioskBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                KioskPage s = new KioskPage();
                s.setVisible(true);


            }
        });

        // Event listener for Admin Login button: to go to Admin login page

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminPage s = new AdminPage();
                s.setVisible(true);
            }
        });
    }



    public static void main(String[] args){

        LandingPage page = new LandingPage();
        page.setVisible(true);

    }


}
