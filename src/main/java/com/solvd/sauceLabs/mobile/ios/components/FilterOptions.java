package com.solvd.sauceLabs.mobile.ios.components;

import com.solvd.sauceLabs.mobile.common.components.FilterOptionsBase;
import com.solvd.sauceLabs.mobile.common.pages.HomePageBase;
import com.solvd.sauceLabs.mobile.ios.pages.HomePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class FilterOptions extends FilterOptionsBase {

    @ExtendedFindBy(iosPredicate = "name == \"Name (A to Z)\"")
    ExtendedWebElement optionToClick;

    public FilterOptions(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public HomePage clickOnOption() {
        optionToClick.click();
        return null;
    }
}
