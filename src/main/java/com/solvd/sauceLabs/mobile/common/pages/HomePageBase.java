package com.solvd.sauceLabs.mobile.common.pages;

import com.solvd.sauceLabs.mobile.common.components.FilterOptionsBase;
import com.solvd.sauceLabs.mobile.common.components.ProductBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class HomePageBase extends AbstractPage {


    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductBase getProductByIndex(int index);

    public abstract void clickCartButton();

    public abstract FilterOptionsBase clickFilterButton();

    public abstract void clickMenuButton();

}
