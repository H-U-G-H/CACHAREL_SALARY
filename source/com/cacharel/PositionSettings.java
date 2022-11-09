package com.cacharel;

public class PositionSettings
{
    public int prepaid;
    public double workShift;
    public int salaryPerHour;
    public double percentCompleted;
    public double percentNotCompleted;

    public PositionSettings(int prepaid, double workShift, int salaryPerHour, double percentCompleted, double percentNotCompleted)
    {
        this.prepaid = prepaid;
        this.workShift = workShift;
        this.salaryPerHour = salaryPerHour;
        this.percentCompleted = percentCompleted;
        this.percentNotCompleted = percentNotCompleted;
    }
}
