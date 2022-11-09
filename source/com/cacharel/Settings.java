package com.cacharel;

public class Settings
{
    public double incomeTax;

    public PositionSettings sellerSettings;
    public PositionSettings adminSettings;

    public Settings(double incomeTax, PositionSettings sellerSettings, PositionSettings adminSettings)
    {
        this.incomeTax = incomeTax;
        this.sellerSettings = sellerSettings;
        this.adminSettings = adminSettings;
    }
}
