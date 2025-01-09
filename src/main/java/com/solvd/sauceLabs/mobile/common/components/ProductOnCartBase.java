package com.solvd.sauceLabs.mobile.common.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ProductOnCartBase extends AbstractUIObject {

    ExtendedWebElement title;
    ExtendedWebElement price;
    ExtendedWebElement removeButton;

    public ProductOnCartBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public abstract void clickRemoveButton();


}
