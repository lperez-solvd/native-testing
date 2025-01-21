package com.solvd.sauceLabs.mobile.common.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckOutFinishPageBase extends AbstractPage {

    public CheckOutFinishPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getFinishMessage();
}
