package com.solvd.sauceLabs.mobile.android.pages;

import com.solvd.sauceLabs.mobile.common.pages.LeftNavMenuBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LeftNavMenuBase.class)
public class LeftNavMenu extends LeftNavMenuBase {

    @ExtendedFindBy(accessibilityId = "test-WEBVIEW")
    ExtendedWebElement webViewButton;
    @ExtendedFindBy(accessibilityId = "test-GEO LOCATION")
    ExtendedWebElement geoLocationButton;
    @ExtendedFindBy(accessibilityId = "test-ABOUT")
    ExtendedWebElement aboutButton;
    @ExtendedFindBy(accessibilityId = "test-LOGOUT")
    ExtendedWebElement logOutButton;
    @ExtendedFindBy(accessibilityId = "test-DRAWING")
    ExtendedWebElement drawButton;

    public LeftNavMenu(WebDriver driver) {
        super(driver);
    }

    @Override
    protected ExtendedWebElement getDrawButton() {
        return drawButton;
    }

    @Override
    protected ExtendedWebElement getWebViewButton() {
        return webViewButton;
    }

    @Override
    protected ExtendedWebElement getGeoLocationButton() {
        return geoLocationButton;
    }

    @Override
    protected ExtendedWebElement getAboutButton() {
        return aboutButton;
    }

    @Override
    public ExtendedWebElement getLogOutButton() {
        return logOutButton;
    }


}
