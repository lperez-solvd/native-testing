package com.solvd.sauceLabs.mobile.ios.pages;

import com.solvd.sauceLabs.mobile.common.components.CartItemsBase;
import com.solvd.sauceLabs.mobile.common.components.ProductOnCartBase;
import com.solvd.sauceLabs.mobile.common.pages.CartPageBase;
import com.solvd.sauceLabs.mobile.common.pages.CheckOutPageBase;
import com.solvd.sauceLabs.mobile.common.pages.CheckOutSuccessPageBase;
import com.solvd.sauceLabs.mobile.common.pages.HomePageBase;
import com.solvd.sauceLabs.mobile.ios.components.CartItems;
import com.solvd.sauceLabs.mobile.ios.components.ProductOnCart;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase implements IMobileUtils {

    @ExtendedFindBy(iosPredicate = "name == \"test-Item\"")
    List<CartItems> cartItems;

    @ExtendedFindBy(iosPredicate = "name == \"test-Item\"")
    List<ProductOnCart> productList;

    @ExtendedFindBy(iosPredicate = "name == \"test-CHECKOUT\"")
    ExtendedWebElement checkOutButton;

    ProductOnCart product;

    @Override
    protected List<? extends CartItemsBase> getProductsOnCart() {
        return cartItems;
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public ProductOnCartBase getProductByIndex(int index) {
        return productList.get(index);
    }

    @Override
    public CheckOutPageBase clickCheckOutButton() {
        swipe(checkOutButton);
        checkOutButton.click();
        return initPage(CheckOutPageBase.class);
    }

}
