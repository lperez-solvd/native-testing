package com.solvd.sauceLabs.mobile.common.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckOutSuccessPageBase extends AbstractPage {

    ExtendedWebElement finishButton;

    public CheckOutSuccessPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CheckOutFinishPageBase clickFinishButton ();
}
