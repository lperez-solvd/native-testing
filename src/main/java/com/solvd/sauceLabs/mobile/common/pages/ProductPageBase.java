package com.solvd.sauceLabs.mobile.common.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {
    

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getProductTitle();

    public abstract String getProductPrice();
}
