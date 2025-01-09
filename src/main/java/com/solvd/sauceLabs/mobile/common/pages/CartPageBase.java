package com.solvd.sauceLabs.mobile.common.pages;

import com.solvd.sauceLabs.mobile.common.components.CartItemsBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CartPageBase extends AbstractPage {

    List<CartItemsBase> productsOnCart;
    ExtendedWebElement checkOutButton;

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public int getProductsCount() {
        return productsOnCart.size();
    }

    public abstract void clickCheckOutButton();

}
