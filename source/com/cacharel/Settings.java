package com.cacharel;

public class Settings
{
    public double incomeTax; // ПОДОХОДНЫЙ НАЛОГ

    public PositionSettings sellerSettings; // ПАРАМЕТРЫ ПРОДАВЦА
    public PositionSettings adminSettings; // ПАРАМЕТРЫ АДМИНИСТРАТОРА
    public PositionSettings seniorSettings; // ПАРАМЕТРЫ СТАРШЕГО АДМИНИСТРАТОРА

    // КОНСТРУКТОР
    public Settings(double incomeTax,
                    PositionSettings sellerSettings,
                    PositionSettings adminSettings,
                    PositionSettings seniorSettings)
    {
        this.incomeTax = incomeTax; // ПОДОХОДНЫЙ НАЛОГ
        this.sellerSettings = sellerSettings; // ПАРАМЕТРЫ ПРОДАВЦА
        this.adminSettings = adminSettings; // ПАРАМЕТРЫ АДМИНИСТРАТОРА
        this.seniorSettings = seniorSettings; // ПАРАМЕТРЫ СТАРШЕГО АДМИНИСТРАТОРА
    }
}
