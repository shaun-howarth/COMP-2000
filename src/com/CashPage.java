package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashPage extends JFrame {
    private JPanel mainPanel;
    private JPanel cashPanel;
    private JButton payBtn;
    private JTextField textField1;


    public CashPage() {

        setTitle("Cash Page");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(400,400));
        pack();


        payBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));


        payBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Cash entered: Please await change if any!");
            }
        });
    }

    public static void main (String[] args) {
        CashPage page = new CashPage();
        page.setVisible(true);
    }
}
