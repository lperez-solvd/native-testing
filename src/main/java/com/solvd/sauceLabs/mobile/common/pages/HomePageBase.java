package com.solvd.sauceLabs.mobile.common.pages;

import com.solvd.sauceLabs.mobile.common.components.FilterOptionsBase;
import com.solvd.sauceLabs.mobile.common.components.ProductListItemBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public abstract class HomePageBase extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageBase.class);

    public abstract List<? extends ProductListItemBase> getProductList();

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract CartPageBase clickCartButton();

    public abstract FilterOptionsBase clickFilterButton();

    public abstract LeftNavMenuBase clickMenuButton();

    public abstract String getLoginErrorMessage();

    public Optional<? extends ProductListItemBase> findProductByTitle(String title) {
        return getProductList().stream()
                .filter(product -> product.getTitle().equals(title)) // Filter by title
                .findFirst();
    }

    public ProductListItemBase getProductByIndex(int index) {
        return getProductList().get(index);
    }

    public abstract void addProductByTitle(String text);

    /**
     * @param product1          Product to be compared
     * @param firstProductPrice Product to be compared price
     * @return If product 1 price is bigger than product 2, will return 1, if product 2 is bigger will return -1 if are equal will return 0
     */
    public int compareProductPrices(ProductListItemBase product1, String firstProductPrice) {

        BigDecimal product1Price = new BigDecimal(product1.getPrice().replaceAll("[^0-9.]", ""));
        BigDecimal product2Price = new BigDecimal(firstProductPrice.replaceAll("[^0-9.]", ""));
        LOGGER.info("Comparison result: {}", product1Price.compareTo(product2Price));
        return product1Price.compareTo(product2Price);

    }

    public void addProductsByTitle(List<String> productTitles) {
        for (String title : productTitles) {
            addProductByTitle(title);
        }
    }

}
