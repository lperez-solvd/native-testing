package com.solvd.sauceLabs.mobile.android.components;

import com.solvd.sauceLabs.mobile.common.components.ProductListItemBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductListItemBase.class)
public class ProductListItem extends ProductListItemBase {

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Item title\"]")
    ExtendedWebElement title;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\"]")
    ExtendedWebElement price;

    @ExtendedFindBy(accessibilityId = "test-ADD TO CART")
    ExtendedWebElement addToCartButton;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Price']/android.view.ViewGroup[@content-desc='test-REMOVE']")
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
        waitUntil(d -> removeProductButton.isElementPresent(), 10);
        removeProductButton.click();
    }
}
