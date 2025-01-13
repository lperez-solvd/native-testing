package com.solvd.sauceLabs;

import com.solvd.sauceLabs.mobile.common.pages.HomePageBase;
import com.solvd.sauceLabs.mobile.common.pages.LeftNavMenuBase;
import com.solvd.sauceLabs.mobile.common.pages.LoginPageBase;

import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase implements IAbstractTest {

    @Test(description = "Login with correct credentials")
    public void loginWithCorrectCredentialsTest() {
        LoginPageBase login = initPage(LoginPageBase.class);
        login.enterUserName("standard_user");
        login.enterPassword("secret_sauce");
        HomePageBase home = login.clickLoginButton();
        LeftNavMenuBase menu = home.clickMenuButton();
        Assert.assertTrue(menu.getLogOutButton().isElementPresent(), "The Log out button is not present");

    }

    @Test(description = "Login with incorrect credentials")
    public void loginWithIncorrectCredentialsTest() {
        LoginPageBase login = initPage(LoginPageBase.class);
        login.enterUserName("lucas_user");
        login.enterPassword("lucas_sauce");
        HomePageBase home = login.clickLoginButton();
        Assert.assertEquals(home.getLoginErrorMessage(), "Username and password do not match any user in this service.", "The error message is not the expected");

    }
}
