package com.solvd.sauceLabs.mobile.ios.pages;

import com.solvd.sauceLabs.mobile.common.pages.CheckOutFinishPageBase;
import com.solvd.sauceLabs.mobile.common.pages.CheckOutSuccessPageBase;
import com.solvd.sauceLabs.mobile.common.pages.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckOutSuccessPageBase.class)
public class CheckOutSuccessPage extends CheckOutSuccessPageBase implements IMobileUtils {

    @ExtendedFindBy(iosPredicate = "name == \"test-FINISH\"")
    ExtendedWebElement finishButton;

    @Override
    public CheckOutFinishPageBase clickFinishButton() {
        swipe(finishButton);
        finishButton.click();
        return initPage(CheckOutFinishPageBase.class);
    }

    public CheckOutSuccessPage(WebDriver driver) {
        super(driver);
    }
}