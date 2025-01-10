package com.solvd.sauceLabs.mobile.common.pages;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MenuBase extends AbstractPage implements IMobileUtils {

    protected abstract ExtendedWebElement getWebViewButton();
    protected abstract  ExtendedWebElement getGeoLocationButton();
    protected abstract  ExtendedWebElement getAboutButton();
    public abstract  ExtendedWebElement getLogOutButton();

    public MenuBase(WebDriver driver) {
        super(driver);
    }

    public WebViewPageBase clickWebViewButton() {
        getWebViewButton().click();
        return initPage(WebViewPageBase.class);
    }

    public GeoLocationPageView clickGeoLocationButton() {
        getGeoLocationButton().click();
        return initPage(GeoLocationPageView.class);
    }

    public AboutPageBase clickAboutButton() {
        getAboutButton().click();
        return initPage(AboutPageBase.class);
    }

    public LoginPageBase clickLogOutButton() {
        getLogOutButton().click();
        return initPage(LoginPageBase.class);
    }
}
