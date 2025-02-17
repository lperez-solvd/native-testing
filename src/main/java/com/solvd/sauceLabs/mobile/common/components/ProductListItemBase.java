package com.solvd.sauceLabs.mobile.common.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductListItemBase extends AbstractUIObject {


    public ProductListItemBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract ExtendedWebElement getAddToCartButton();

    public abstract String getTitle();

    public abstract String getPrice();

    public abstract void clickAddToCartButton();

    public abstract void clickRemoveProductButton();
}
