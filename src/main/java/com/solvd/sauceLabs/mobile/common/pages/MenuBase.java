package com.solvd.sauceLabs.mobile.common.pages;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class MenuBase extends AbstractPage implements IMobileUtils {

    ExtendedWebElement webViewButton;
    ExtendedWebElement geoLocationButton;
    ExtendedWebElement aboutButton;
    ExtendedWebElement logOutButton;

    public MenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver);
    }

    public WebViewPageBase clickWebViewButton() {
        webViewButton.click();
        return initPage(WebViewPageBase.class);
    }

    public GeoLocationPageView clickGeoLocationButton() {
        geoLocationButton.click();
        return initPage(GeoLocationPageView.class);
    }

    public AboutPageBase clickAboutButton() {
        aboutButton.click();
        return initPage(AboutPageBase.class);
    }

    public LoginPageBase clickLogOutButton() {
        logOutButton.click();
        return initPage(LoginPageBase.class);
    }
}
