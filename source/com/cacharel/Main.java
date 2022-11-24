package com.cacharel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Main
{
    static Gui gui = new Gui();
    JFrame mainWindow = new JFrame("SALARY CALCULATOR");

    public static void main(String[] args)
    {
        Main main = new Main();
        main.go();
    }

    public void go()
    {
        mainWindow.getContentPane().add(gui.buildGui());
        mainWindow.setJMenuBar(gui.buildMenu());
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
        mainWindow.setVisible(true);
        mainWindow.setBounds(500, 200, 445, 200);
    }

    public static class ButtonEventListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            try
            {
                double salesPlan = Double.parseDouble(gui.planField.getText());
                double totalSold = Double.parseDouble(gui.soldField.getText());
                int days = Integer.parseInt(gui.daysField.getText());
                gui.soldField.setBackground(Color.WHITE);
                gui.daysField.setBackground(Color.WHITE);
                gui.salaryField.setBackground(new Color(200, 255, 200));
                gui.paymentField.setBackground(new Color(200, 255, 200));

                boolean isSeller = gui.sellerRadioButton.isSelected();
                boolean isAdmin = gui.adminRadioButton.isSelected();
                boolean isSenior = gui.seniorRadioButton.isSelected();

                boolean hasCompleted;
                if(Integer.parseInt(gui.soldField.getText()) >= Integer.parseInt(gui.planField.getText())) hasCompleted = true;
                else hasCompleted = false;

                Settings settings =
                        new Settings(0.13,
                        new PositionSettings(12000, 12.5, 120, 0.05, 0.04),
                        new PositionSettings(18000, 12.5, 140, 0.06, 0.05),
                        new PositionSettings(24000, 12.5, 170, 0.015, 0.015));
                Calculator calculator = new Calculator(settings);

                Position position = null; // ВЫБОР ДОЛЖНОСТИ
                if(isSeller) position = new Position(settings.sellerSettings);
                if(isAdmin) position = new Position(settings.adminSettings);
                if(isSenior) position = new Position(settings.seniorSettings);

                double salaryAfterTax = calculator.calculate(position, hasCompleted, salesPlan, totalSold, days);

                String salary = new DecimalFormat("#0.00").format(salaryAfterTax);
                gui.salaryField.setText(salary);
                String salaryMinusPrepaid = new DecimalFormat("#0.00").format(salaryAfterTax - position.getPrepaid());
                gui.paymentField.setText(salaryMinusPrepaid);
            }
            catch (Exception exception)
            {
                gui.soldField.setText("MUST BE FILLED");
                gui.soldField.setBackground(new Color(255, 200, 200));
                gui.daysField.setText("MUST BE FILLED");
                gui.daysField.setBackground(new Color(255, 200, 200));
                gui.salaryField.setText("");
                gui.salaryField.setBackground(Color.WHITE);
                gui.paymentField.setText("");
                gui.paymentField.setBackground(Color.WHITE);

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
