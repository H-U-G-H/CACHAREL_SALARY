package com.cacharel;

public class Position
{
    private int prepaid;
    private double workShift;
    private int salaryPerHour;
    private double percentDone;
    private double percentNotDone;


    public Position(int prepaid, double workShift, int salaryPerHour, double percentDone, double percentNotDone)
    {
        this.prepaid = prepaid;
        this.workShift = workShift;
        this.salaryPerHour = salaryPerHour;
        this.percentDone = percentDone;
        this.percentNotDone = percentNotDone;
    }

    public int getPrepaid()
    {
        return prepaid;
    }

    public double getWorkShiftSalary()
    {
        return workShift * salaryPerHour;
    }

    public double getPercent(boolean isPlanCompleted)
    {
        return isPlanCompleted ? percentDone : percentNotDone;
    }
}
