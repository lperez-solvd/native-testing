package com.solvd.sauceLabs.mobile.common.pages;

import com.solvd.sauceLabs.mobile.common.components.CartItemsBase;
import com.solvd.sauceLabs.mobile.common.components.ProductOnCartBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CartPageBase extends AbstractPage {

    protected abstract List<? extends CartItemsBase> getProductsOnCart();

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public int getProductsCount() {
        return getProductsOnCart().size();
    }

    public abstract CheckOutPageBase clickCheckOutButton();

    public abstract ProductOnCartBase getProductByIndex(int index);
}
