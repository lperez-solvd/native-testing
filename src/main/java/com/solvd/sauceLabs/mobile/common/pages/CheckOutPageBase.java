package com.solvd.sauceLabs.mobile.common.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckOutPageBase extends AbstractPage {


    public CheckOutPageBase(WebDriver driver) {
        super(driver);
    }

    protected abstract void enterName(String text);

    protected abstract void enterLastName(String text);

    protected abstract void enterZipCode(String text);

    public void enterInfoToInputs(String name, String lastName, String zipCode) {
        enterName(name);
        enterLastName(lastName);
        enterZipCode(zipCode);
    }

    public abstract CheckOutSuccessPageBase clickContinueButton();
}
