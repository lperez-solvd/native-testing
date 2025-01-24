package com.solvd.sauceLabs.mobile.android.pages;

import com.solvd.sauceLabs.mobile.android.components.ProductListItem;
import com.solvd.sauceLabs.mobile.common.pages.CartPageBase;
import com.solvd.sauceLabs.mobile.common.pages.CheckOutPageBase;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Item\"]")
    List<ProductListItem> productList;

    @ExtendedFindBy(accessibilityId = "test-CHECKOUT")
    ExtendedWebElement checkOutButton;
    @FindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView")
    ExtendedWebElement cartProductsNumber;


    @Override
    protected List<? extends ProductListItem> getProductsOnCart() {
        return productList;
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public ProductListItem getProductByIndex(int index) {
        return productList.get(index);
    }

    @Override
    public CheckOutPageBase clickCheckOutButton() {
        swipe(checkOutButton);
        checkOutButton.click();
        return initPage(CheckOutPageBase.class);
    }

    @Override
    public int getProductsCount() {
        if (cartProductsNumber.isElementPresent()) {
            return Integer.parseInt(cartProductsNumber.getText());
        } else {
            return 0;
        }
    }
}
