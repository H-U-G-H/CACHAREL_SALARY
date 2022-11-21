package com.cacharel;

public class PositionSettings
{
    public int prepaid; // ПРЕДОПЛАТА
    public double workShift; // РАБОЧАЯ СМЕНА
    public int salaryPerHour; // ОПЛАТА ЗА ЧАС РАБОТЫ
    public double percentCompleted; // ПРОЦЕНТ ПРИ ВЫПОЛНЕНИИ ПЛАНА
    public double percentNotCompleted; // ПРОЦЕНТ ПРИ НЕВЫПОЛНЕНИИ ПЛАНА

    // КОНСТРУКТОР
    public PositionSettings(int prepaid, double workShift, int salaryPerHour, double percentCompleted, double percentNotCompleted)
    {
        this.prepaid = prepaid; // ПРЕДОПЛАТА
        this.workShift = workShift; // РАБОЧАЯ СМЕНА
        this.salaryPerHour = salaryPerHour; // ОПЛАТА ЗА ЧАС РАБОТЫ
        this.percentCompleted = percentCompleted; // ПРОЦЕНТ ПРИ ВЫПОЛНЕНИИ ПЛАНА
        this.percentNotCompleted = percentNotCompleted; // ПРОЦЕНТ ПРИ НЕВЫПОЛНЕНИИ ПЛАНА
    }
}
