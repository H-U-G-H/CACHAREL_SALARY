package com.cacharel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui
{
    final int COMPONENT_HEIGHT = 15;
    final int LABEL_WIDTH = 200;
    final int FIELD_WIDTH = 105;
    final int RADIO_WIDTH = 100;
    final int BUTTON_WIDTH = 105;

    public JPanel background = new JPanel(null);
    public JTextField planField; // SALES PLAN
    public JTextField soldField; // TOTAL SOLD
    public JTextField daysField; // DAYS COUNT
    public JTextField salaryField; // SALARY PER MONTH
    public JTextField paymentField; // NEXT PAYMENT
    public JRadioButton seniorRadioButton; // SENIOR
    public JRadioButton adminRadioButton; // ADMIN
    public JRadioButton sellerRadioButton; // SELLER

    public JPanel buildGui()
    {
        JLabel planLabel = new JLabel("SALES PLAN");
        planLabel.setBounds(10, 10, LABEL_WIDTH, COMPONENT_HEIGHT);
        background.add(planLabel);

        planField = new JTextField();
        planField.setToolTipText("ENTER SALES PLAN AMOUNT");
        planField.setBounds(150, 10, FIELD_WIDTH, COMPONENT_HEIGHT);
        background.add(planField);

        JLabel soldLabel = new JLabel("TOTAL SOLD");
        soldLabel.setBounds(10, 26, LABEL_WIDTH, COMPONENT_HEIGHT);
        background.add(soldLabel);

        soldField = new JTextField();
        soldField.setToolTipText("ENTER THE AMOUNT OF SALES");
        soldField.setBounds(150, 26, FIELD_WIDTH, COMPONENT_HEIGHT);
        background.add(soldField);

        JLabel daysLabel = new JLabel("DAYS COUNT");
        daysLabel.setBounds(10, 42, LABEL_WIDTH, COMPONENT_HEIGHT);
        background.add(daysLabel);

        daysField = new JTextField();
        daysField.setToolTipText("ENTER THE NUMBER OF WORKING DAYS");
        daysField.setBounds(150, 42, FIELD_WIDTH, COMPONENT_HEIGHT);
        background.add(daysField);

        JLabel salaryLabel = new JLabel("SALARY PER MONTH");
        salaryLabel.setBounds(10, 58, LABEL_WIDTH, COMPONENT_HEIGHT);
        background.add(salaryLabel);

        salaryField = new JTextField();
        salaryField.setEditable(false);
        salaryField.setToolTipText("NON-EDITABLE");
        salaryField.setBounds(150, 58, FIELD_WIDTH, COMPONENT_HEIGHT);
        background.add(salaryField);

        JLabel paymentLabel = new JLabel("NEXT PAYMENT");
        paymentLabel.setBounds(10, 74, LABEL_WIDTH, COMPONENT_HEIGHT);
        background.add(paymentLabel);

        paymentField = new JTextField();
        paymentField.setEditable(false);
        paymentField.setToolTipText("NON-EDITABLE");
        paymentField.setBounds(150, 74, FIELD_WIDTH, COMPONENT_HEIGHT);
        background.add(paymentField);

        seniorRadioButton = new JRadioButton("SENIOR", true);
        seniorRadioButton.setToolTipText("CHOOSE YOUR POSITION");
        seniorRadioButton.setBounds(265, 10, RADIO_WIDTH, COMPONENT_HEIGHT);
        background.add(seniorRadioButton);

        adminRadioButton = new JRadioButton("ADMIN", false);
        adminRadioButton.setToolTipText("CHOOSE YOUR POSITION");
        adminRadioButton.setBounds(265, 26, RADIO_WIDTH, COMPONENT_HEIGHT);
        background.add(adminRadioButton);

        sellerRadioButton = new JRadioButton("SELLER", false);
        sellerRadioButton.setToolTipText("CHOOSE YOUR POSITION");
        sellerRadioButton.setBounds(265, 42, RADIO_WIDTH, COMPONENT_HEIGHT);
        background.add(sellerRadioButton);

        ButtonGroup group = new ButtonGroup();
        group.add(seniorRadioButton);
        group.add(adminRadioButton);
        group.add(sellerRadioButton);

        JButton button = new JButton("CALCULATE");
        button.addActionListener(new Main.ButtonEventListener());
        button.setToolTipText("START THE CALCULATION PROCESS");
        button.setBounds(150, 100, BUTTON_WIDTH, COMPONENT_HEIGHT);
        background.add(button);

        return background;
    }

    public JMenuBar buildMenu()
    {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem clearMenuItem = new JMenuItem("Clear");
        clearMenuItem.addActionListener(new ClearMenuItemListener());
        fileMenu.add(clearMenuItem);
        menuBar.add(fileMenu);

        return menuBar;
    }

    class ClearMenuItemListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            planField.setText("");
            planField.setBackground(Color.WHITE);
            soldField.setText("");
            soldField.setBackground(Color.WHITE);
            daysField.setText("");
            daysField.setBackground(Color.WHITE);
            salaryField.setText("");
            salaryField.setBackground(Color.WHITE);
            paymentField.setText("");
            paymentField.setBackground(Color.WHITE);
        }
    }
}
