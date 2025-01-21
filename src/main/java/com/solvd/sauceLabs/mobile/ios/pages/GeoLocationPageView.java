package com.solvd.sauceLabs.mobile.ios.pages;

import com.solvd.sauceLabs.mobile.common.pages.GeoLocationPageViewBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = GeoLocationPageViewBase.class)
public class GeoLocationPageView extends GeoLocationPageViewBase implements IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeoLocationPageView.class);

    @ExtendedFindBy(iosPredicate = "name == \"test-latitude\"")
    ExtendedWebElement latitude;
    @ExtendedFindBy(iosPredicate = "name == \"test-longitude\"")
    ExtendedWebElement longitude;

    public GeoLocationPageView(WebDriver driver) {
        super(driver);
    }

    private void setLocation() {
        setLocation(new Location(37.785834, -122.406417, 0));
    }

    public double getLocationLongitude() {
        setLocation();
        double longitude = getLocation().getLongitude();
        LOGGER.info("Phone longitude = {}", longitude);
        return longitude;
    }

    public double getLocationLatitude() {
        setLocation();
        double latitude = getLocation().getLatitude();
        LOGGER.info("Phone latitude = {}", latitude);

        return latitude;
    }

    public double getLongitudeFromScreen() {
        if (isAlertPresent()) {
            cancelAlert();
        }
        waitUntil(d -> longitude.isElementPresent(), 50);

        String longitudeValue = longitude.getText();

        return handleParse(longitudeValue);
    }

    public double getLatitudeFromScreen() {
        if (isAlertPresent()) {
            cancelAlert();
        }
        waitUntil(d -> latitude.isElementPresent(), 50);

        String latitudeValue = latitude.getText();
        return handleParse(latitudeValue);
    }


}
