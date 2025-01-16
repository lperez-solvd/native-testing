package com.solvd.sauceLabs.mobile.android.pages;

import com.solvd.sauceLabs.mobile.common.pages.CheckOutPageBase;
import com.solvd.sauceLabs.mobile.common.pages.CheckOutSuccessPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckOutPageBase.class)
public class CheckOutPage extends CheckOutPageBase {
    @ExtendedFindBy(accessibilityId = "test-First Name")
    ExtendedWebElement nameInput;

    @ExtendedFindBy(accessibilityId = "test-Last Name")
    ExtendedWebElement lastNameInput;

    @ExtendedFindBy(accessibilityId = "test-Zip/Postal Code")
    ExtendedWebElement zipCodeInput;

    @ExtendedFindBy(accessibilityId = "test-CONTINUE")
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
