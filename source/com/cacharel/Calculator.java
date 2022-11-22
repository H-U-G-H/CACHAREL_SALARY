package com.cacharel;

public class Calculator
{
    private Settings settings; // ПАРАМЕТРЫ

    // КОНСТРУКТОР
    public Calculator(Settings settings)
    {
        this.settings = settings; // ПАРАМЕТРЫ
    }
    public double calculate(Position position, boolean hasCompleted, double salesPlan, double totalSold, int days)
    {
        // РАСЧЕТ ВЫПЛАТ СТАРШЕГО АДМИНИСТРАТОРА
        if(position.getPrepaid() == 24000)
        {
            if(hasCompleted)
            {
                double sellPercent = (totalSold * position.getPercent(true)) + 5000; // ПРОЦЕНТ С ПРОДАЖ
                double salaryBeforeTax = sellPercent + (days * position.getWorkShiftSalary()); // ВЫПЛАТА ДО УПЛАТЫ НДФЛ
                return salaryBeforeTax - (salaryBeforeTax * settings.incomeTax); // ВЫПЛАТА ПОСЛЕ УПЛАТЫ НДФЛ
            }
            else
            {
                double sellPercent = (totalSold * position.getPercent(false)) * (totalSold/salesPlan); // ПРОЦЕНТ С ПРОДАЖ
                double salaryBeforeTax = sellPercent + (days * position.getWorkShiftSalary()); // ВЫПЛАТА ДО УПЛАТЫ НДФЛ
                return salaryBeforeTax - (salaryBeforeTax * settings.incomeTax); // ВЫПЛАТА ПОСЛЕ УПЛАТЫ НДФЛ
            }
        }
        // --------------------------------------

        double sellPercent = (totalSold * position.getPercent(hasCompleted)); // ПРОЦЕНТ С ПРОДАЖ
        double salaryBeforeTax = sellPercent + (days * position.getWorkShiftSalary()); // ВЫПЛАТА ДО УПЛАТЫ НДФЛ
        return salaryBeforeTax - (salaryBeforeTax * settings.incomeTax); // ВЫПЛАТА ПОСЛЕ УПЛАТЫ НДФЛ
    }
}
