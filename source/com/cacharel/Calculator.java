package com.cacharel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator
{
    JFrame frame = new JFrame("SALARY CALCULATOR");
    JPanel background = new JPanel(null);
    JTextField soldField; // TOTAL SOLD
    JTextField daysField; // DAYS COUNT
    JTextField salaryField; // SALARY PER MONTH
    JTextField paymentField; // NEXT PAYMENT
    JCheckBox isPlanCompleted; // IS PLAN COMPLETED
    JRadioButton adminRadioButton; // ADMIN
    JRadioButton sellerRadioButton; // SELLER

    private final static int COMPONENT_HEIGHT = 15;
    private final static int LABEL_WIDTH = 200;
    private final static int FIELD_WIDTH = 105;
    private final static int RADIO_WIDTH = 100;
    private final static int BOX_WIDTH = 200;
    private final static int BUTTON_WIDTH = 105;

    public static void main(String[] args)
    {
        new Calculator().go();
    }

    public void go()
    {
        JLabel soldLabel = new JLabel("TOTAL SOLD");
        soldLabel.setBounds(10, 10, LABEL_WIDTH, COMPONENT_HEIGHT);
        background.add(soldLabel);

        soldField = new JTextField();
        soldField.setToolTipText("ENTER THE AMOUNT OF SALES");
        soldField.setBounds(150, 10, FIELD_WIDTH, COMPONENT_HEIGHT);
        background.add(soldField);

        JLabel daysLabel = new JLabel("DAYS COUNT");
        daysLabel.setBounds(10, 26, LABEL_WIDTH, COMPONENT_HEIGHT);
        background.add(daysLabel);

        daysField = new JTextField();
        daysField.setToolTipText("ENTER THE NUMBER OF WORKING DAYS");
        daysField.setBounds(150, 26, FIELD_WIDTH, COMPONENT_HEIGHT);
        background.add(daysField);

        JLabel salaryLabel = new JLabel("SALARY PER MONTH");
        salaryLabel.setBounds(10, 42, LABEL_WIDTH, COMPONENT_HEIGHT);
        background.add(salaryLabel);

        salaryField = new JTextField();
        salaryField.setEditable(false);
        salaryField.setToolTipText("NON-EDITABLE");
        salaryField.setBounds(150, 42, FIELD_WIDTH, COMPONENT_HEIGHT);
        background.add(salaryField);

        JLabel paymentLabel = new JLabel("NEXT PAYMENT");
        paymentLabel.setBounds(10, 58, LABEL_WIDTH, COMPONENT_HEIGHT);
        background.add(paymentLabel);

        paymentField = new JTextField();
        paymentField.setEditable(false);
        paymentField.setToolTipText("NON-EDITABLE");
        paymentField.setBounds(150, 58, FIELD_WIDTH, COMPONENT_HEIGHT);
        background.add(paymentField);

        adminRadioButton = new JRadioButton("ADMIN", true);
        adminRadioButton.setToolTipText("CHOOSE YOUR POSITION");
        adminRadioButton.setBounds(265, 42, RADIO_WIDTH, COMPONENT_HEIGHT);
        background.add(adminRadioButton);

        sellerRadioButton = new JRadioButton("SELLER", false);
        sellerRadioButton.setToolTipText("CHOOSE YOUR POSITION");
        sellerRadioButton.setBounds(265, 58, RADIO_WIDTH, COMPONENT_HEIGHT);
        background.add(sellerRadioButton);

        ButtonGroup group = new ButtonGroup();
        group.add(adminRadioButton);
        group.add(sellerRadioButton);

        isPlanCompleted = new JCheckBox("IS PLAN COMPLETED");
        isPlanCompleted.setToolTipText("MARK WHETHER THE SALES PLAN IS COMPLETED");
        isPlanCompleted.setBounds(265, 10, BOX_WIDTH, COMPONENT_HEIGHT);
        background.add(isPlanCompleted);

        JButton button = new JButton("CALCULATE");
        button.addActionListener(new ButtonEventListener());
        button.setToolTipText("START THE CALCULATION PROCESS");
        button.setBounds(150, 100, BUTTON_WIDTH, COMPONENT_HEIGHT);
        background.add(button);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem clearMenuItem = new JMenuItem("Clear");
        clearMenuItem.addActionListener(new ClearMenuItemListener());
        fileMenu.add(clearMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        frame.getContentPane().add(background);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setBounds(500, 200, 445, 200);
    }

    public class ClearMenuItemListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
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

    public class ButtonEventListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            try
            {
                double totalSold = Double.parseDouble(soldField.getText());
                int days = Integer.parseInt(daysField.getText());
                soldField.setBackground(Color.WHITE);
                daysField.setBackground(Color.WHITE);
                salaryField.setBackground(new Color(200, 255, 200));
                paymentField.setBackground(new Color(200, 255, 200));

                boolean isSeller = sellerRadioButton.isSelected();
                boolean hasCompleted = isPlanCompleted.isSelected();
                Settings settings =
                        new Settings(0.13,
                        new PositionSettings(12000, 12.5, 120, 0.05, 0.04),
                        new PositionSettings(18000, 12.5, 140, 0.06, 0.05));
                Computer computer = new Computer(settings);
                Position position = isSeller ? new Position(settings.sellerSettings) : new Position(settings.adminSettings);
                double salaryAfterTax = computer.calculate(position, hasCompleted, totalSold, days);

                salaryField.setText(Double.toString(salaryAfterTax));
                paymentField.setText(Double.toString(salaryAfterTax - position.getPrepaid()));
            }
            catch (Exception exception)
            {
                soldField.setText("MUST BE FILLED");
                soldField.setBackground(new Color(255, 200, 200));
                daysField.setText("MUST BE FILLED");
                daysField.setBackground(new Color(255, 200, 200));
                salaryField.setText("");
                salaryField.setBackground(Color.WHITE);
                paymentField.setText("");
                paymentField.setBackground(Color.WHITE);

                JFrame errorWindow = new JFrame();
                errorWindow.setResizable(false);
                JPanel errorPanel = new JPanel();
                JLabel errorLabel = new JLabel("ERROR");
                errorPanel.add(errorLabel);
                errorWindow.getContentPane().add(BorderLayout.CENTER, errorPanel);
                errorWindow.setBounds(643, 275, 100, 75);
                errorWindow.setVisible(true);
            }
        }
    }
}
