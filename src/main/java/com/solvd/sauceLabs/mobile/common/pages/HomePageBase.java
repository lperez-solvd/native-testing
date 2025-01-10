package com.solvd.sauceLabs.mobile.common.pages;

import com.solvd.sauceLabs.mobile.common.components.FilterOptionsBase;
import com.solvd.sauceLabs.mobile.common.components.ProductBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Optional;

public abstract class HomePageBase extends AbstractPage {

    public abstract List<? extends ProductBase> getProductList();

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CartPageBase clickCartButton();

    public abstract FilterOptionsBase clickFilterButton();

    public abstract MenuBase clickMenuButton();

    public abstract String getLoginErrorMessage();

    public Optional<? extends ProductBase> findProductByTitle(String title) {
        return getProductList().stream()
                .filter(product -> product.getTitle().equals(title)) // Filter by title
                .findFirst();
    }

    public ProductBase getProductByIndex(int index) {
        return getProductList().get(index);
    }

    public abstract void addProductByTitle(String text);


}
