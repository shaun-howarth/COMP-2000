package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashPage extends JFrame {
    private JPanel mainPanel;
    private JPanel cashPanel;
    private JButton payBtn;
    private JTextField cashField;


    public CashPage() {

        setTitle("Cash Page");
        setContentPane(mainPanel);
        setContentPane(cashPanel);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setPreferredSize(new Dimension(400,400));
        pack();


        //Hover cursor effect for all Jbuttons
        payBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));


        //Event listener for Pay Now button
        payBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cashField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter cash amount!");
                } else {
                    JOptionPane.showMessageDialog(null, "Cash entered: Please await change if any!");
                }
            }
        });
    }

    public static void main (String[] args) {
        CashPage page = new CashPage();
        page.setVisible(true);
    }
}
