package com.solvd.sauceLabs;

import com.solvd.sauceLabs.mobile.common.components.ProductOnCartBase;
import com.solvd.sauceLabs.mobile.common.pages.*;
import com.solvd.sauceLabs.mobile.ios.components.ProductOnCart;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


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
        SoftAssert sa = new SoftAssert();

        HomePageBase home = fastLogin();
        home.addProductByTitle("Sauce Labs Backpack");
        home.addProductByTitle("Test.allTheThings() T-Shirt (Red)");
        CartPageBase cartPage = home.clickCartButton();

        // add extra test to ensure al products has been added
        sa.assertEquals(cartPage.getProductsCount(), 2, "The number of added products is not the expected");

        CheckOutPageBase checkOut = cartPage.clickCheckOutButton();
        checkOut.enterInfoToInputs("Lucas", "Perez", "1990");
        CheckOutSuccessPageBase checkOutSuccess = checkOut.clickContinueButton();

        CheckOutFinishPageBase finish = checkOutSuccess.clickFinishButton();
        sa.assertEquals(finish.getFinishMessage(), "THANK YOU FOR YOU ORDER", "The message is not the expected");

        sa.assertAll();
    }
}
