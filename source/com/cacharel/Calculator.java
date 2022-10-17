package com.cacharel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator
{
    JFrame frame = new JFrame("SALARY CALCULATOR");
    JPanel background = new JPanel(null); // нрйюг нр дхяоервепю йнлонмнбйх
    JTextField soldField; // онке "TOTAL SOLD"
    JTextField daysField; // онке "DAYS COUNT"
    JTextField salaryField; // онке "SALARY PER MONTH"
    JTextField paymentField; // онке "NEXT PAYMENT"
    JCheckBox isPlanCompleted; // вейанйя "IS PLAN COMPLETED"
    JRadioButton adminRadioButton; // пюдхнймнойю "ADMIN"
    JRadioButton sellerRadioButton; // пюдхнймнойю "SELLER"

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
        soldField.setToolTipText("ENTER THE AMOUNT OF SALES"); // бяокшбючыюъ ондяйюгйю
        soldField.setBounds(150, 10, FIELD_WIDTH, COMPONENT_HEIGHT);
        background.add(soldField);

        JLabel daysLabel = new JLabel("DAYS COUNT");
        daysLabel.setBounds(10, 26, LABEL_WIDTH, COMPONENT_HEIGHT);
        background.add(daysLabel);

        daysField = new JTextField();
        daysField.setToolTipText("ENTER THE NUMBER OF WORKING DAYS"); // бяокшбючыюъ ондяйюгйю
        daysField.setBounds(150, 26, FIELD_WIDTH, COMPONENT_HEIGHT);
        background.add(daysField);

        JLabel salaryLabel = new JLabel("SALARY PER MONTH");
        salaryLabel.setBounds(10, 42, LABEL_WIDTH, COMPONENT_HEIGHT);
        background.add(salaryLabel);

        salaryField = new JTextField();
        salaryField.setEditable(false); // гюопер мю педюйрхпнбюмхе рейярнбнцн онкъ
        salaryField.setToolTipText("NON-EDITABLE"); // бяокшбючыюъ ондяйюгйю
        salaryField.setBounds(150, 42, FIELD_WIDTH, COMPONENT_HEIGHT);
        background.add(salaryField);

        JLabel paymentLabel = new JLabel("NEXT PAYMENT");
        paymentLabel.setBounds(10, 58, LABEL_WIDTH, COMPONENT_HEIGHT);
        background.add(paymentLabel);

        paymentField = new JTextField();
        paymentField.setEditable(false); // гюопер мю педюйрхпнбюмхе рейярнбнцн онкъ
        paymentField.setToolTipText("NON-EDITABLE"); // бяокшбючыюъ ондяйюгйю
        paymentField.setBounds(150, 58, FIELD_WIDTH, COMPONENT_HEIGHT);
        background.add(paymentField);

        adminRadioButton = new JRadioButton("ADMIN", true);
        adminRadioButton.setToolTipText("CHOOSE YOUR POSITION"); // бяокшбючыюъ ондяйюгйю
        adminRadioButton.setBounds(265, 42, RADIO_WIDTH, COMPONENT_HEIGHT);
        background.add(adminRadioButton);

        sellerRadioButton = new JRadioButton("SELLER", false);
        sellerRadioButton.setToolTipText("CHOOSE YOUR POSITION"); // бяокшбючыюъ ондяйюгйю
        sellerRadioButton.setBounds(265, 58, RADIO_WIDTH, COMPONENT_HEIGHT);
        background.add(sellerRadioButton);

        ButtonGroup group = new ButtonGroup();
        group.add(adminRadioButton);
        group.add(sellerRadioButton);

        isPlanCompleted = new JCheckBox("IS PLAN COMPLETED");
        isPlanCompleted.setToolTipText("MARK WHETHER THE SALES PLAN IS COMPLETED"); // бяокшбючыюъ ондяйюгйю
        isPlanCompleted.setBounds(265, 10, BOX_WIDTH, COMPONENT_HEIGHT);
        background.add(isPlanCompleted);

        JButton button = new JButton("CALCULATE");
        button.addActionListener(new ButtonEventListener());
        button.setToolTipText("START THE CALCULATION PROCESS"); // бяокшбючыюъ ондяйюгйю
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // гюбепьемхе опнцпюллш опх гюйпшрхх нймю
        frame.setResizable(false); // гюопер мю хглемемхе пюглепю нймю
        frame.setVisible(true); // бхдхлнярэ нймю (дю/мер)
        frame.setBounds(500, 200, 445, 200); // цкюбмне нймн
    }

    public class ClearMenuItemListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            soldField.setText("");
            soldField.setBackground(Color.WHITE); // жбер тнмю
            daysField.setText("");
            daysField.setBackground(Color.WHITE); // жбер тнмю
            salaryField.setText("");
            salaryField.setBackground(Color.WHITE); // жбер тнмю
            paymentField.setText("");
            paymentField.setBackground(Color.WHITE); // жбер тнмю
        }
    }

    public class ButtonEventListener implements ActionListener
    {
        double totalSold; // оепелеммюъ дкъ упюмемхъ дюммшу хг онкъ "TOTAL SOLD"
        int days; // оепелеммюъ дкъ упюмемхъ дюммшу хг онкъ "DAYS COUNT"
        int prepaid; // юбюмя
        double percent; // опнжемр нр бшпсвйх
        double hourlyPayment; // онвюянбюъ нокюрю

        public void actionPerformed(ActionEvent event)
        {
            try
            {
                totalSold = Double.parseDouble(soldField.getText());
                days = Integer.parseInt(daysField.getText());
                soldField.setBackground(Color.WHITE); // жбер тнмю
                daysField.setBackground(Color.WHITE); // жбер тнмю
                salaryField.setBackground(new Color(200, 255, 200)); // жбер тнмю
                paymentField.setBackground(new Color(200, 255, 200)); // жбер тнмю



                if (sellerRadioButton.isSelected())
                {
                    prepaid = 12000;
                    hourlyPayment = 12.5 * 120;
                    if (isPlanCompleted.isSelected())
                    {
                        percent = 0.05;
                    }
                    else
                    {
                        percent = 0.04;
                    }
                }

                if (adminRadioButton.isSelected())
                {
                    prepaid = 18000;
                    hourlyPayment = 12.5 * 140;
                    if (isPlanCompleted.isSelected())
                    {
                        percent = 0.06;
                    }
                    else
                    {
                        percent = 0.05;
                    }
                }

                double temp = (totalSold * percent);
                temp = temp + (days * hourlyPayment);
                temp = temp - (temp * 0.13);
                salaryField.setText(Double.toString(temp));
                paymentField.setText(Double.toString(temp - prepaid));
            }
            catch (Exception exception)
            {
                soldField.setText("MUST BE FILLED");
                soldField.setBackground(new Color(255, 200, 200)); // жбер тнмю
                daysField.setText("MUST BE FILLED");
                daysField.setBackground(new Color(255, 200, 200)); // жбер тнмю
                salaryField.setText("");
                salaryField.setBackground(Color.WHITE); // жбер тнмю
                paymentField.setText("");
                paymentField.setBackground(Color.WHITE); // жбер тнмю

                JFrame errorWindow = new JFrame();
                errorWindow.setResizable(false); // гюопер мю хглемемхе пюглепю нймю
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
