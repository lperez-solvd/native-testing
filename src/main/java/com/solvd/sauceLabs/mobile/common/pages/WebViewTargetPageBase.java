package com.solvd.sauceLabs.mobile.common.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WebViewTargetPageBase extends AbstractPage {

    public WebViewTargetPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isLogoPresent();

}
