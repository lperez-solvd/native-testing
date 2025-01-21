package com.solvd.sauceLabs.mobile.ios.pages;

import com.solvd.sauceLabs.mobile.common.pages.AboutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@SuppressWarnings("unused")
@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AboutPageBase.class)
public class AboutPage extends AboutPageBase {

    @ExtendedFindBy(iosPredicate = "value == '1'")
    ExtendedWebElement aboutTitle;

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return aboutTitle.getAttribute("name");
    }

}
