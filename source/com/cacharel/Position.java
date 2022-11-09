package com.cacharel;

public class Position
{
    private PositionSettings settings;

    public Position(PositionSettings settings)
    {
        this.settings = settings;
    }

    public int getPrepaid()
    {
        return this.settings.prepaid;
    }

    public double getWorkShiftSalary()
    {
        return this.settings.workShift * this.settings.salaryPerHour;
    }

    public double getPercent(boolean isPlanCompleted)
    {
        return isPlanCompleted ? this.settings.percentCompleted : this.settings.percentNotCompleted;
    }
}
