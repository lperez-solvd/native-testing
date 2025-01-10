package com.solvd.sauceLabs;

import com.solvd.sauceLabs.mobile.common.components.ProductOnCartBase;
import com.solvd.sauceLabs.mobile.common.pages.*;
import com.solvd.sauceLabs.mobile.ios.components.ProductOnCart;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductTests extends TestBase {

    @Test
    public void addProductToCartTest() {
        HomePageBase home = fastLogin();
        home.addProductByTitle("Test.allTheThings() T-Shirt (Red)");
        CartPageBase cartPage = home.clickCartButton();
        Assert.assertEquals(cartPage.getProductsCount(), 1, "The number of items in the cart is not the expected");
    }

    @Test
    public void discardProductTest() {
        HomePageBase home = fastLogin();
        home.addProductByTitle("Test.allTheThings() T-Shirt (Red)");
        CartPageBase cartPage = home.clickCartButton();
        ProductOnCartBase product = cartPage.getProductByIndex(0);
        product.clickRemoveButton();
        Assert.assertEquals(cartPage.getProductsCount(), 0, "The number of items in the cart is not the expected");
    }

    @Test
    public void buyTwoProductsTest() {
        HomePageBase home = fastLogin();
        home.addProductByTitle("Sauce Lab Backpack");
        home.addProductByTitle("Test.allTheThings() T-Shirt (Red)");
        CartPageBase cartPage = home.clickCartButton();
        CheckOutPageBase checkOut = cartPage.clickCheckOutButton();
        checkOut.enterInfoToInputs("Lucas", "Perez", "1990");
        CheckOutSuccessPageBase checkOutSuccess = checkOut.clickContinueButton();

        CheckOutFinishPageBase finish = checkOutSuccess.clickFinishButton();
        Assert.assertEquals(finish.getFinishMessage(), "THANK YOU FOR YOUR ORDER", "The message is not the expected");
    }
}
