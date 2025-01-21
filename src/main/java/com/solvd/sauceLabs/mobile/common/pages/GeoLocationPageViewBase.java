package com.solvd.sauceLabs.mobile.common.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GeoLocationPageViewBase extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeoLocationPageViewBase.class);


    public GeoLocationPageViewBase(WebDriver driver) {
        super(driver);
    }

    public abstract double getLocationLongitude();

    public abstract double getLocationLatitude();

    public abstract double getLongitudeFromScreen();

    public abstract double getLatitudeFromScreen();

    protected double handleParse(String valueToParse) {
        try {
            // Try to parse the longitude text to a double
            return Double.parseDouble(valueToParse);

        } catch (NumberFormatException e) {
            // Handle case where the text cannot be parsed into a double
            LOGGER.error("Latitude is not a valid number to parse: {}", valueToParse);
            throw new IllegalStateException("Invalid latitude format: " + valueToParse, e);
        }
    }
}
