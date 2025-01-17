package com.solvd.sauceLabs.mobile.android.pages;

import com.solvd.sauceLabs.mobile.common.pages.WebViewPageBase;
import com.solvd.sauceLabs.mobile.common.pages.WebViewTargetPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    @ExtendedFindBy(accessibilityId = "test-enter a https url here...")
    ExtendedWebElement urlInput;
    @ExtendedFindBy(accessibilityId = "test-GO TO SITE")
    ExtendedWebElement goToSiteButton;

    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void sendUrl(String text) {
        urlInput.type(text);
    }

    @Override
    public WebViewTargetPageBase clickGoToButton() {
        goToSiteButton.click();
        return initPage(WebViewTargetPageBase.class);
    }
}
