package com.solvd.sauceLabs.mobile.android.pages;

import com.solvd.sauceLabs.mobile.common.pages.CheckOutFinishPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckOutFinishPageBase.class)
public class CheckOutFinishPage extends CheckOutFinishPageBase {
    @FindBy(xpath = "//android.widget.TextView[@text=\"THANK YOU FOR YOU ORDER\"]")
    ExtendedWebElement message;

    public CheckOutFinishPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getFinishMessage() {
        return message.getText();
    }
}
