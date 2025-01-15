package com.solvd.sauceLabs.mobile.android.pages;

import com.solvd.sauceLabs.mobile.common.components.ProductListItemBase;
import com.solvd.sauceLabs.mobile.common.pages.CartPageBase;
import com.solvd.sauceLabs.mobile.common.pages.HomePageBase;
import com.solvd.sauceLabs.mobile.common.pages.LeftNavMenuBase;
import com.solvd.sauceLabs.mobile.ios.components.FilterOptions;
import com.solvd.sauceLabs.mobile.ios.components.ProductListItem;
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
    Logger LOGGER = LoggerFactory.getLogger(com.solvd.sauceLabs.mobile.ios.pages.HomePage.class);

    @ExtendedFindBy(accessibilityId = "test-PRODUCTS")
    List<ProductListItem> allProducts;

    @ExtendedFindBy(accessibilityId = "test-Menu")
    ExtendedWebElement menuButton;

    @ExtendedFindBy(accessibilityId = "test-Cart")
    ExtendedWebElement cartButton;

    @ExtendedFindBy(accessibilityId = "test-Modal Selector Button")
    ExtendedWebElement filterButton;

    @ExtendedFindBy(accessibilityId = "Selector container")
    FilterOptions filterOptions;

    @FindBy(xpath= "//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]")
    ExtendedWebElement loginErrorMessage;

    @Override
    public List<ProductListItem> getProductList() {
        return allProducts;
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPageBase clickCartButton() {
        tap(cartButton.getLocation().getX() + 30, cartButton.getLocation().getY() + 35);
        return initPage(CartPageBase.class);
    }

    @Override
    public FilterOptions clickFilterButton() {
        filterButton.click();
        return filterOptions;
    }

    @Override
    public LeftNavMenuBase clickMenuButton() {
        tap(menuButton.getLocation().getX() + 1, menuButton.getLocation().getY() + 24);

        return initPage(LeftNavMenuBase.class);
    }

    @Override
    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }

    public void addProductByTitle(String text) {
        Optional<? extends ProductListItemBase> product = super.findProductByTitle(text);
        product.ifPresent(p -> {
            LOGGER.info("The element has benn found");
            swipe(p.getAddToCartButton());
            p.clickAddToCartButton();
        });
    }
}
