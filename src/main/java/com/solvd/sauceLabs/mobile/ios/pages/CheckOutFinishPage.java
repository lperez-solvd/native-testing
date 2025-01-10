package com.solvd.sauceLabs.mobile.ios.pages;

import com.solvd.sauceLabs.mobile.common.pages.CheckOutFinishPageBase;
import com.solvd.sauceLabs.mobile.common.pages.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckOutFinishPageBase.class)
public class CheckOutFinishPage extends CheckOutFinishPageBase {
    @ExtendedFindBy(iosPredicate = "name == \"THANK YOU FOR YOU ORDER\"")
    ExtendedWebElement message;

    public CheckOutFinishPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getFinishMessage() {
        return message.getText();
    }
}
