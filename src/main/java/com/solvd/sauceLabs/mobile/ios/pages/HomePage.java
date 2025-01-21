package com.solvd.sauceLabs.mobile.ios.pages;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {

    final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    @ExtendedFindBy(iosPredicate = "name == \"test-Item\"")
    List<ProductListItem> allProducts;

    @ExtendedFindBy(iosPredicate = "name == \"test-Menu\"")
    ExtendedWebElement menuButton;

    @ExtendedFindBy(iosPredicate = "name == \"test-Cart\"")
    ExtendedWebElement cartButton;

    @ExtendedFindBy(iosPredicate = "name == \"test-Modal Selector Button\"")
    ExtendedWebElement filterButton;

    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"Selector container\"`][2]")
    FilterOptions filterOptions;

    @ExtendedFindBy(iosPredicate = "name == \"test-Error message\"")
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

        System.out.println();
        if (Objects.equals(getDevice().getName(), "iPhone 16")) {
            tap(cartButton.getLocation().getX() + 30, cartButton.getLocation().getY() + 35);
        } else {
            cartButton.click();
        }

        return initPage(CartPageBase.class);
    }

    @Override
    public FilterOptions clickFilterButton() {
        filterButton.click();
        return filterOptions;
    }

    @Override
    public LeftNavMenuBase clickMenuButton() {
        if (Objects.equals(getDevice().getName(), "iPhone 16")) {
            tap(menuButton.getLocation().getX() + 1, menuButton.getLocation().getY() + 24);
        } else {
            menuButton.click();
        }


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
