package com.solvd.sauceLabs;

import com.solvd.sauceLabs.mobile.common.components.FilterOptionsBase;
import com.solvd.sauceLabs.mobile.common.components.ProductListItemBase;

import com.solvd.sauceLabs.mobile.common.pages.*;
import com.solvd.sauceLabs.mobile.ios.pages.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class ProductTests extends TestBase {

    Logger LOGGER = LoggerFactory.getLogger(ProductTests.class);


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
        ProductListItemBase product = cartPage.getProductByIndex(0);
        product.clickRemoveProductButton();
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

    @Test
    public void filterProductsTest() {
        SoftAssert sa = new SoftAssert();

        HomePageBase home = fastLogin();
        FilterOptionsBase filterOptions = home.clickFilterButton();
        filterOptions.clickOnOption();

        ProductListItemBase firstProduct = home.getProductByIndex(0);

        LOGGER.info("Processing price comparition...");
        home.getProductList().forEach((item) ->
                sa.assertTrue(home.compareProductPrices(item, firstProduct) == 1 || home.compareProductPrices(item, firstProduct) == 0, "There is some items more expensive than the first one")
        );
        LOGGER.info("Pricerice comparition ended");

        sa.assertAll();

    }
}
