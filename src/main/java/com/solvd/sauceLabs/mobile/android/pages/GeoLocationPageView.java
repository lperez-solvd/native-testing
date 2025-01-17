package com.solvd.sauceLabs.mobile.android.pages;

import com.solvd.sauceLabs.mobile.common.pages.GeoLocationPageViewBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = GeoLocationPageViewBase.class)
public class GeoLocationPageView extends GeoLocationPageViewBase implements IMobileUtils {

    final Logger LOGGER = LoggerFactory.getLogger(GeoLocationPageView.class);

    @ExtendedFindBy(accessibilityId = "test-latitude")
    ExtendedWebElement latitude;
    @ExtendedFindBy(accessibilityId = "test-longitude")
    ExtendedWebElement longitude;

    public GeoLocationPageView(WebDriver driver) {
        super(driver);
    }


    public double getLocationLongitude() {
        LOGGER.info("Phone longitude = {}", getLocation().getLongitude());
        return getLocation().getLongitude();
    }

    public double getLocationLatitude() {
        LOGGER.info("Phone latitude = {}", getLocation().getLatitude());

        return getLocation().getLatitude();
    }

    public double getLongitudeFromScreen() {
        if (isAlertPresent()) {
            acceptAlert();
        }
        waitUntil(d -> longitude.isElementPresent(), 50);

        return Double.parseDouble(longitude.getText());
    }

    public double getLatitudeFromScreen() {
        if (isAlertPresent()) {
            acceptAlert();
        }
        waitUntil(d -> latitude.isElementPresent(), 50);
        return Double.parseDouble(latitude.getText());
    }


}
