package com.solvd.sauceLabs.mobile.common.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductBase extends AbstractUIObject {

    ExtendedWebElement title;
    ExtendedWebElement price;
    ExtendedWebElement addToCartButton;
    ExtendedWebElement removeProductButton;

    public ProductBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract String getTitle();

    public abstract String getPrice();

    public abstract void clickAddToCartButton();

    public abstract void clickRemoveProductButton();
}
