package com.solvd.sauceLabs.mobile.common.pages;

import com.solvd.sauceLabs.mobile.common.components.ProductListItemBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CartPageBase extends AbstractPage {

    protected abstract List<? extends ProductListItemBase> getProductsOnCart();

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public int getProductsCount() {
        return getProductsOnCart().size();
    }

    public abstract CheckOutPageBase clickCheckOutButton();

    public abstract ProductListItemBase getProductByIndex(int index);
}
