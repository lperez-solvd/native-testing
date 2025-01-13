package com.solvd.sauceLabs.mobile.ios.pages;

import com.solvd.sauceLabs.mobile.common.pages.CartPageBase;
import com.solvd.sauceLabs.mobile.common.pages.CheckOutPageBase;
import com.solvd.sauceLabs.mobile.ios.components.ProductListItem;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase implements IMobileUtils {

    @ExtendedFindBy(iosPredicate = "name == \"test-Item\"")
    List<ProductListItem> productList;

    @ExtendedFindBy(iosPredicate = "name == \"test-CHECKOUT\"")
    ExtendedWebElement checkOutButton;


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

}
