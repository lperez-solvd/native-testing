package com.solvd.sauceLabs.mobile.common.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class GeoLocationPageViewBase extends AbstractPage {
    public GeoLocationPageViewBase(WebDriver driver) {
        super(driver);
    }



    public abstract double getLocationLongitude();

    public abstract double getLocationLatitude();

    public abstract double getLongitudeFromScreen();

    public abstract double getLatitudeFromScreen();
}
