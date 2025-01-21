package com.solvd.sauceLabs.mobile.common.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public abstract class CheckOutPageBase extends AbstractPage {

    @ExtendedFindBy(accessibilityId = "test-First Name")
    ExtendedWebElement nameInput;

    @ExtendedFindBy(accessibilityId = "test-Last Name")
    ExtendedWebElement lastNameInput;

    @ExtendedFindBy(accessibilityId = "test-Zip/Postal Code")
    ExtendedWebElement zipCodeInput;

    @ExtendedFindBy(accessibilityId = "test-CONTINUE")
    ExtendedWebElement continueButton;

    public CheckOutPageBase(WebDriver driver) {
        super(driver);
    }


    protected void enterName(String text) {
        nameInput.type(text);
    }


    protected void enterLastName(String text) {
        lastNameInput.type(text);
    }


    protected void enterZipCode(String text) {
        zipCodeInput.type(text);
    }

    public void enterInfoToInputs(String name, String lastName, String zipCode) {
        enterName(name);
        enterLastName(lastName);
        enterZipCode(zipCode);
    }

    public CheckOutSuccessPageBase clickContinueButton() {
        continueButton.click();
        return initPage(CheckOutSuccessPageBase.class);
    }
}
