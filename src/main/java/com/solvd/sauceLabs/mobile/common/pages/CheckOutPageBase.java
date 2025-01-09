package com.solvd.sauceLabs.mobile.common.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckOutPageBase extends AbstractPage {

    ExtendedWebElement firstNameInput;
    ExtendedWebElement lastNameInput;
    ExtendedWebElement zipCodeInput;
    ExtendedWebElement continueButton;

    public CheckOutPageBase(WebDriver driver) {
        super(driver);
    }

    public void sendTextToInput(ExtendedWebElement input, String text) {
        input.type(text);
    }

    public abstract CheckOutSuccessPageBase clickContinueButton();
}
