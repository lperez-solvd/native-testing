package com.solvd.sauceLabs.mobile.ios.pages;

import com.solvd.sauceLabs.mobile.common.components.ProductBase;
import com.solvd.sauceLabs.mobile.common.pages.CartPageBase;
import com.solvd.sauceLabs.mobile.common.pages.HomePageBase;
import com.solvd.sauceLabs.mobile.common.pages.MenuBase;
import com.solvd.sauceLabs.mobile.ios.components.FilterOptions;
import com.solvd.sauceLabs.mobile.ios.components.Product;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Optional;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {

    @ExtendedFindBy(iosPredicate = "name == \"test-Item\"")
    List<Product> allProducts;

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
    public List<Product> getProductList() {
        return allProducts;
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPageBase clickCartButton() {
        tap(cartButton.getLocation().getX() + 30, menuButton.getLocation().getY() + 35);
        return initPage(CartPageBase.class);
    }

    @Override
    public FilterOptions clickFilterButton() {
        filterButton.click();
        return filterOptions;
    }

    @Override
    public MenuBase clickMenuButton() {
        tap(menuButton.getLocation().getX() + 1, menuButton.getLocation().getY() + 24);

        return initPage(MenuBase.class);
    }

    @Override
    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }

    public void addProductByTitle(String text) {
        Optional<? extends ProductBase> product = super.findProductByTitle(text);
        product.ifPresent(p -> {
            swipe(p.getAddToCartButton());
            p.clickAddToCartButton();
        });
    }
}
