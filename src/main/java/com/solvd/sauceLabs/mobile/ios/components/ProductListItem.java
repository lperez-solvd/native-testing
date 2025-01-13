package com.solvd.sauceLabs.mobile.ios.components;

import com.solvd.sauceLabs.mobile.common.components.ProductListItemBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductListItemBase.class)
public class ProductListItem extends ProductListItemBase {

    @ExtendedFindBy(iosPredicate = "name == \"test-Item title\"")
    ExtendedWebElement title;

    @ExtendedFindBy(iosPredicate = "name= \"test-Price\"")
    ExtendedWebElement price;

    @ExtendedFindBy(iosPredicate = "name=\"test-ADD TO CART\"")
    ExtendedWebElement addToCartButton;

    @ExtendedFindBy(iosPredicate = "name == \"test-REMOVE\"")
    ExtendedWebElement removeProductButton;


    public ProductListItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getAddToCartButton() {
        return addToCartButton;
    }

    public void setAddToCartButton(ExtendedWebElement addToCartButton) {
        this.addToCartButton = addToCartButton;
    }

    @Override
    public String getTitle() {
        return title.getText();
    }

    @Override
    public String getPrice() {
        return price.getText();
    }

    @Override
    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    @Override
    public void clickRemoveProductButton() {
        removeProductButton.click();
    }
}
