package com.solvd.sauceLabs;

import com.solvd.sauceLabs.mobile.common.components.FilterOptionsBase;
import com.solvd.sauceLabs.mobile.common.components.ProductListItemBase;

import com.solvd.sauceLabs.mobile.common.pages.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class ProductTests extends TestBase {

    final Logger LOGGER = LoggerFactory.getLogger(ProductTests.class);

    private static final String productToBuyTitle = "Test.allTheThings() T-Shirt (Red)";


    @Test
    public void addProductToCartTest() {
        HomePageBase home = fastLogin();
        home.addProductByTitle(productToBuyTitle);
        CartPageBase cartPage = home.clickCartButton();
        Assert.assertEquals(cartPage.getProductsCount(), 1, "The number of items in the cart is not the expected");
    }

    @Test
    public void discardProductTest() {
        HomePageBase home = fastLogin();
        home.addProductByTitle(productToBuyTitle);
        CartPageBase cartPage = home.clickCartButton();
        ProductListItemBase product = cartPage.getProductByIndex(0);
        product.clickRemoveProductButton();
        Assert.assertEquals(cartPage.getProductsCount(), 0, "The number of items in the cart is not the expected");
    }

    @Test
    public void buyMultipleProductsTest() {
        SoftAssert sa = new SoftAssert();

        HomePageBase home = fastLogin();
        List<String> productsToAdd = List.of("Sauce Labs Backpack", productToBuyTitle);
        home.addProductsByTitle(productsToAdd);
        CartPageBase cartPage = home.clickCartButton();

        sa.assertEquals(cartPage.getProductsCount(), productsToAdd.size(), "The number of added products is not the expected");

        CheckOutPageBase checkOut = cartPage.clickCheckOutButton();
        checkOut.enterInfoToInputs("Lucas", "Perez", "1990");
        CheckOutSuccessPageBase checkOutSuccess = checkOut.clickContinueButton();

        CheckOutFinishPageBase finish = checkOutSuccess.clickFinishButton();
        sa.assertEquals(finish.getFinishMessage(), "THANK YOU FOR YOU ORDER", "The message is not the expected");

        sa.assertAll();
    }

    @Test
    public void filterProductsByAscendantPriceTest() {
        SoftAssert sa = new SoftAssert();

        HomePageBase home = fastLogin();
        FilterOptionsBase filterOptions = home.clickFilterButton();
        filterOptions.clickOnOption();

        ProductListItemBase firstProduct = home.getProductByIndex(0);
        String firstProductPrice = firstProduct.getPrice();

        LOGGER.info("Processing price comparison...");
        home.getProductList().forEach(
                (item) ->
                        sa.assertTrue(home.compareProductPrices(item, firstProductPrice) == 1 || home.compareProductPrices(item, firstProductPrice) == 0, "There is some items more expensive than the first one")
        );
        LOGGER.info("Price comparison ended");

        sa.assertAll();

    }
}
