package com.solvd.sauceLabs.mobile.android.components;

import com.solvd.sauceLabs.mobile.common.components.FilterOptionsBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FilterOptions extends FilterOptionsBase {

    @FindBy(xpath = "//android.widget.TextView[@text=\"Price (low to high)\"]")
    ExtendedWebElement optionToClick;

    public FilterOptions(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void clickOnOption() {
        optionToClick.click();
    }
}
