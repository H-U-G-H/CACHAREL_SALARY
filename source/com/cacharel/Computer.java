package com.cacharel;

public class Computer
{
    private Settings settings;

    public Computer(Settings settings)
    {
        this.settings = settings;
    }
    public double calculate(Position position, boolean hasCompleted, double totalSold, int days)
    {
        double sellPercent = (totalSold * position.getPercent(hasCompleted));
        double salaryBeforeTax = sellPercent + (days * position.getWorkShiftSalary());
        return salaryBeforeTax - (salaryBeforeTax * settings.incomeTax);
    }
}
