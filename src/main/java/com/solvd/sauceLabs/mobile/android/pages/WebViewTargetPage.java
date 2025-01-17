package com.solvd.sauceLabs.mobile.android.pages;

import com.solvd.sauceLabs.mobile.common.pages.WebViewTargetPageBase;
import com.solvd.sauceLabs.mobile.utils.MobileContextUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewTargetPageBase.class)
public class WebViewTargetPage extends WebViewTargetPageBase implements IMobileUtils {

    @FindBy(xpath = "//img[@id=\"hplogo\"]")
    ExtendedWebElement googleLogo;

    public WebViewTargetPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isLogoPresent() {

        MobileContextUtils contextHelper = new MobileContextUtils();
        contextHelper.switchMobileContext(MobileContextUtils.View.WEB_BROWSER);

        return googleLogo.isElementPresent();
    }
}
