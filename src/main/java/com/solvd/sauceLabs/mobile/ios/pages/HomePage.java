package com.solvd.sauceLabs.mobile.ios.pages;

import com.solvd.sauceLabs.mobile.common.components.ProductBase;
import com.solvd.sauceLabs.mobile.common.pages.HomePageBase;
import com.solvd.sauceLabs.mobile.ios.components.FilterOptions;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @ExtendedFindBy(iosPredicate = "name == \"test-Item\"")
    List<ProductBase> allProducts;

    @ExtendedFindBy(iosPredicate = "name == \"test-Menu\"")
    ExtendedWebElement menuButton;

    @ExtendedFindBy(iosPredicate = "name == \"test-Cart\"")
    ExtendedWebElement cartButton;

    @ExtendedFindBy(iosPredicate = "name == \"test-Modal Selector Button\"")
    ExtendedWebElement filterButton;
    @ExtendedFindBy(iosClassChain = "**/XCUIElementTypeOther[`name == \"Selector container\"`][2]")
    FilterOptions filterOptions;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductBase getProductByIndex(int index) {
        return allProducts.get(index);
    }

    @Override
    public void clickCartButton() {
        cartButton.click();
    }

    @Override
    public FilterOptions clickFilterButton() {
        filterButton.click();
        return filterOptions;
    }

    @Override
    public void clickMenuButton() {
        menuButton.click();
    }
}
