package com.cacharel;

public class Computer
{
    public double calculate(boolean isSeller, boolean hasCompleted, double totalSold, int days)
    {
        int prepaid;
        double percent;
        double hourlyPayment;

        if (isSeller)
        {
            prepaid = 12000;
            hourlyPayment = 12.5 * 120;
            if (hasCompleted)
            {
                percent = 0.05;
            }
            else
            {
                percent = 0.04;
            }
        }
        else
        {
            prepaid = 18000;
            hourlyPayment = 12.5 * 140;
            if (hasCompleted)
            {
                percent = 0.06;
            }
            else
            {
                percent = 0.05;
            }
        }

        double sellPercent = (totalSold * percent);
        double salaryBeforeTax = sellPercent + (days * hourlyPayment);
        double salaryAfterTax = salaryBeforeTax - (salaryBeforeTax * 0.13);
        return salaryAfterTax;
    }
}
