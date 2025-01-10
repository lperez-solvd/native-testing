package com.solvd.sauceLabs.mobile.ios.pages;

import com.solvd.sauceLabs.mobile.common.pages.MenuBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MenuBase.class)
public class Menu extends MenuBase {

    @ExtendedFindBy(iosPredicate = "name == \"test-WEBVIEW\"")
    ExtendedWebElement webViewButton;
    @ExtendedFindBy(iosPredicate = "name == \"test-GEO LOCATION\"")
    ExtendedWebElement geoLocationButton;
    @ExtendedFindBy(iosPredicate = "name == \"test-ABOUT\"")
    ExtendedWebElement aboutButton;
    @ExtendedFindBy(iosPredicate = "name == \"test-LOGOUT\"")
    ExtendedWebElement logOutButton;


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

    public Menu(WebDriver driver) {
        super(driver);
    }
}
