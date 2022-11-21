package com.cacharel;

public class Position
{
    private PositionSettings settings;

    // КОНСТРУКТОР
    public Position(PositionSettings settings)
    {
        this.settings = settings;
    }

    // ПОЛУЧИТЬ ПРЕДОПЛАТУ
    public int getPrepaid()
    {
        return this.settings.prepaid;
    }

    // ПОЛУЧИТЬ ОПЛАТУ ЗА СМЕНУ
    public double getWorkShiftSalary()
    {
        return this.settings.workShift * this.settings.salaryPerHour;
    }

    // ПОЛУЧИТЬ ПРОЦЕНТ
    public double getPercent(boolean isPlanCompleted)
    {
        return isPlanCompleted ? this.settings.percentCompleted : this.settings.percentNotCompleted;
    }
}
