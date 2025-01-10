package com.solvd.sauceLabs.mobile.ios.pages;

import com.solvd.sauceLabs.mobile.common.pages.CheckOutPageBase;
import com.solvd.sauceLabs.mobile.common.pages.CheckOutSuccessPageBase;
import com.solvd.sauceLabs.mobile.common.pages.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckOutPageBase.class)
public class CheckOutPage extends CheckOutPageBase {
    @ExtendedFindBy(iosPredicate = "name == \"test-First Name\"")
    ExtendedWebElement nameInput;

    @ExtendedFindBy(iosPredicate = "name == \"test-Last Name\"")
    ExtendedWebElement lastNameInput;

    @ExtendedFindBy(iosPredicate = "name == \"test-Zip/Postal Code\"")
    ExtendedWebElement zipCodeInput;

    @ExtendedFindBy(iosPredicate = "name == \"test-CONTINUE\"")
    ExtendedWebElement continueButton;


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void enterName(String text) {
        nameInput.type(text);
    }

    @Override
    protected void enterLastName(String text) {
        lastNameInput.type(text);
    }

    @Override
    protected void enterZipCode(String text) {
        zipCodeInput.type(text);
    }

    @Override
    public CheckOutSuccessPageBase clickContinueButton() {
        continueButton.click();
        return initPage(CheckOutSuccessPageBase.class);
    }

}
