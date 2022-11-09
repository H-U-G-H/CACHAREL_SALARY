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
        Position position;
        Position sellerPosition = new Position(sellerPrepaid, workShift, sellerSalaryPerHour, sellerPercentCompleted, sellerPercentNotCompleted);
        Position adminPosition = new Position(adminPrepaid, workShift, adminSalaryPerHour, adminPercentCompleted, adminPercentNotCompleted);

        position = isSeller ? sellerPosition : adminPosition;

        double sellPercent = (totalSold * position.getPercent(hasCompleted));
        double salaryBeforeTax = sellPercent + (days * position.getWorkShiftSalary());
        double salaryAfterTax = salaryBeforeTax - (salaryBeforeTax * incomeTax);

        return salaryAfterTax;
    }
}
