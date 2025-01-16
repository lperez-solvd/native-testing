package com.solvd.sauceLabs.mobile.android.pages;

import com.solvd.sauceLabs.mobile.common.pages.AboutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AboutPageBase.class)
public class AboutPage extends AboutPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text=\"Website and mobile testing at every stage of development\"]")
    ExtendedWebElement aboutTitle;

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return aboutTitle.getAttribute("name");
    }

}
