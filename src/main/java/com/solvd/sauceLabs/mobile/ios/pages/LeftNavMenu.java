package com.solvd.sauceLabs.mobile.ios.pages;

import com.solvd.sauceLabs.mobile.common.pages.LeftNavMenuBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LeftNavMenuBase.class)
public class LeftNavMenu extends LeftNavMenuBase {

    @ExtendedFindBy(iosPredicate = "name == \"test-WEBVIEW\"")
    ExtendedWebElement webViewButton;
    @ExtendedFindBy(iosPredicate = "name == \"test-GEO LOCATION\"")
    ExtendedWebElement geoLocationButton;
    @ExtendedFindBy(iosPredicate = "name == \"test-ABOUT\"")
    ExtendedWebElement aboutButton;
    @ExtendedFindBy(iosPredicate = "name == \"test-LOGOUT\"")
    ExtendedWebElement logOutButton;
    @ExtendedFindBy(iosPredicate = "name == \"test-DRAWING\"")
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
