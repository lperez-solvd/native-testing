package com.solvd.sauceLabs.mobile.common.pages;

import com.solvd.sauceLabs.mobile.ios.pages.DrawingPageBase;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LeftNavMenuBase extends AbstractPage implements IMobileUtils {

    public LeftNavMenuBase(WebDriver driver) {
        super(driver);
    }

    protected abstract ExtendedWebElement getWebViewButton();

    protected abstract ExtendedWebElement getGeoLocationButton();

    protected abstract ExtendedWebElement getAboutButton();

    public abstract ExtendedWebElement getLogOutButton();

    protected abstract ExtendedWebElement getDrawButton();


    public WebViewPageBase clickWebViewButton() {
        getWebViewButton().click();
        return initPage(WebViewPageBase.class);
    }

    public GeoLocationPageViewBase clickGeoLocationButton() {
        getGeoLocationButton().click();
        return initPage(GeoLocationPageViewBase.class);
    }

    public AboutPageBase clickAboutButton() {
        getAboutButton().click();
        return initPage(AboutPageBase.class);
    }

    public LoginPageBase clickLogOutButton() {
        getLogOutButton().click();
        return initPage(LoginPageBase.class);
    }

    public DrawingPageBase clickDrawingButton() {
        getDrawButton().click();
        return initPage(DrawingPageBase.class);
    }
}
