package com.solvd.sauceLabs.mobile.common.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckOutFinishPageBase extends AbstractPage {

    ExtendedWebElement finishMessage;

    public CheckOutFinishPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getFinishMessage();
}
