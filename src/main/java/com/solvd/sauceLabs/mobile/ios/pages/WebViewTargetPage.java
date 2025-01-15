package com.solvd.sauceLabs.mobile.ios.pages;

import com.solvd.sauceLabs.mobile.common.pages.AboutPageBase;
import com.solvd.sauceLabs.mobile.common.pages.WebViewTargetPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = WebViewTargetPageBase.class)
public class WebViewTargetPage extends WebViewTargetPageBase {

    @ExtendedFindBy(iosPredicate = "name == \"Google\" AND label == \"Google\" AND type == \"XCUIElementTypeImage\"")
    ExtendedWebElement googleLogo;

    public WebViewTargetPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLogoPresent() {
        return googleLogo.isElementPresent();
    }
}
