package com.cacharel;

public class Calculator
{
    private Settings settings; // ПАРАМЕТРЫ

    // КОНСТРУКТОР
    public Calculator(Settings settings)
    {
        this.settings = settings; // ПАРАМЕТРЫ
    }
    public double calculate(Position position, boolean hasCompleted, double totalSold, int days)
    {
        double sellPercent = (totalSold * position.getPercent(hasCompleted)); // ПРОЦЕНТ С ПРОДАЖ
        double salaryBeforeTax = sellPercent + (days * position.getWorkShiftSalary()); // ВЫПЛАТА ДО УПЛАТЫ НДФЛ
        return salaryBeforeTax - (salaryBeforeTax * settings.incomeTax); // ВЫПЛАТА ПОСЛЕ УПЛАТЫ НДФЛ
    }
}
