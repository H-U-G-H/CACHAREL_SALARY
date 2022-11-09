package com.cacharel;

public class Computer
{

    private int sellerPrepaid = 12000;
    private int adminPrepaid = 18000;
    private double workShift = 12.5;
    private int sellerSalaryPerHour = 120;
    private int adminSalaryPerHour = 140;
    private double sellerPercentCompleted = 0.05;
    private double sellerPercentNotCompleted = 0.04;
    private double adminPercentCompleted = 0.06;
    private double adminPercentNotCompleted = 0.05;
    private double incomeTax = 0.13;

    public double calculate(boolean isSeller, boolean hasCompleted, double totalSold, int days)
    {
        int prepaid;
        double percent;
        double hourlyPayment;

        if (isSeller)
        {
            prepaid = sellerPrepaid;
            hourlyPayment = workShift * sellerSalaryPerHour;
            if (hasCompleted)
            {
                percent = sellerPercentCompleted;
            }
            else
            {
                percent = sellerPercentNotCompleted;
            }
        }
        else
        {
            prepaid = adminPrepaid;
            hourlyPayment = workShift * adminSalaryPerHour;
            if (hasCompleted)
            {
                percent = adminPercentCompleted;
            }
            else
            {
                percent = adminPercentNotCompleted;
            }
        }

        double sellPercent = (totalSold * percent);
        double salaryBeforeTax = sellPercent + (days * hourlyPayment);
        double salaryAfterTax = salaryBeforeTax - (salaryBeforeTax * incomeTax);

        return salaryAfterTax;
    }
}
