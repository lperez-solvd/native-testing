package com.solvd.sauceLabs.mobile.common.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class FilterOptionsBase extends AbstractUIObject {

    public FilterOptionsBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract void clickOnOption();
}
