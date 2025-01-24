package com.solvd.sauceLabs.mobile.android.pages;

import com.solvd.sauceLabs.mobile.android.components.FilterOptions;
import com.solvd.sauceLabs.mobile.android.components.ProductListItem;
import com.solvd.sauceLabs.mobile.common.components.ProductListItemBase;
import com.solvd.sauceLabs.mobile.common.pages.CartPageBase;
import com.solvd.sauceLabs.mobile.common.pages.HomePageBase;
import com.solvd.sauceLabs.mobile.common.pages.LeftNavMenuBase;


import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Item\"]")
    List<ProductListItem> allProducts;

    @ExtendedFindBy(accessibilityId = "test-Menu")
    ExtendedWebElement menuButton;

    @ExtendedFindBy(accessibilityId = "test-Cart")
    ExtendedWebElement cartButton;

    @ExtendedFindBy(accessibilityId = "test-Modal Selector Button")
    ExtendedWebElement filterButton;

    @ExtendedFindBy(accessibilityId = "Selector container")
    FilterOptions filterOptions;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]")
    ExtendedWebElement loginErrorMessage;

    @ExtendedFindBy(accessibilityId = "test-Toggle")
    private ExtendedWebElement testToggleButton;

    private boolean isListMode = false;

    @Override
    public List<ProductListItem> getProductList() {
        if (!isListMode) {
            clickToggleButton();
        }
        return allProducts;
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPageBase clickCartButton() {
        cartButton.click();
        return initPage(CartPageBase.class);
    }

    @Override
    public FilterOptions clickFilterButton() {
        filterButton.click();
        return filterOptions;
    }

    @Override
    public LeftNavMenuBase clickMenuButton() {
        menuButton.click();
        return initPage(LeftNavMenuBase.class);
    }

    @Override
    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }

    public void addProductByTitle(String text) {
        Optional<? extends ProductListItemBase> product = super.findProductByTitle(text);

        product.ifPresentOrElse(p -> {
                    LOGGER.info("The element has been found");
                    swipeUp(5);
                    swipe(p.getAddToCartButton());
                    p.clickAddToCartButton();
                },
                () -> {
                    // First attempt
                    clickToggleButton();

                    // Try one more time
                    Optional<? extends ProductListItemBase> retryProduct = super.findProductByTitle(text);
                    retryProduct.ifPresentOrElse(
                            p -> {
                                LOGGER.info("The element has been found after retry");
                                swipe(p.getAddToCartButton());
                                p.clickAddToCartButton();
                            }, () -> {
                                LOGGER.info("Product still not found after retry.");
                            });
                });

    }

    // Helpers

    private void clickToggleButton() {
        isListMode = !isListMode;
        testToggleButton.click();
    }
}
