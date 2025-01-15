package com.solvd.sauceLabs.mobile.ios.pages;

import com.solvd.sauceLabs.mobile.common.pages.GeoLocationPageViewBase;
import com.solvd.sauceLabs.mobile.common.pages.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = GeoLocationPageViewBase.class)
public class GeoLocationPageView extends GeoLocationPageViewBase implements IMobileUtils {

    Logger LOGGER = LoggerFactory.getLogger(GeoLocationPageView.class);

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
        LOGGER.info("Phone longitude = {}", getLocation().getLongitude());
        return getLocation().getLongitude();
    }

    public double getLocationLatitude() {
        setLocation();
        LOGGER.info("Phone latitude = {}", getLocation().getLatitude());

        return getLocation().getLatitude();
    }

    public double getLongitudeFromScreen() {
        if (isAlertPresent()) {
            cancelAlert();
        }
        waitUntil(d -> longitude.isElementPresent(), 50);

        return Double.parseDouble(longitude.getText());
    }

    public double getLatitudeFromScreen() {
        if (isAlertPresent()) {
            cancelAlert();
        }
        waitUntil(d -> latitude.isElementPresent(), 50);
        return Double.parseDouble(latitude.getText());
    }


}
