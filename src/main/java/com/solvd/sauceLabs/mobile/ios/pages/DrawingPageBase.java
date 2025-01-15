package com.solvd.sauceLabs.mobile.ios.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DrawingPageBase extends AbstractPage {


    public DrawingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ExtendedWebElement getSignaturePadByImage();

    public abstract void makeSignature();

    public abstract void clickClearButton();

    public abstract void clickSaveButton();

    public abstract void clickOkButton();

    public boolean findElementByImage() {
        return getSignaturePadByImage().isElementPresent();
    }

    public abstract String returnElementData();

    public abstract String checkForElementPresence();

}