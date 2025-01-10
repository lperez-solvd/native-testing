package com.solvd.sauceLabs.mobile.ios.components;

import com.solvd.sauceLabs.mobile.common.components.ProductOnCartBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class ProductOnCart extends ProductOnCartBase {
    @ExtendedFindBy(iosPredicate = "name == \"test-REMOVE\"")
    ExtendedWebElement removeButton;

    @Override
    public void clickRemoveButton() {
        removeButton.click();
    }

    public ProductOnCart(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
