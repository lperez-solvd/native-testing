package com.solvd.sauceLabs;

import com.solvd.sauceLabs.mobile.common.pages.HomePageBase;
import com.solvd.sauceLabs.mobile.common.pages.LoginPageBase;
import com.zebrunner.carina.core.AbstractTest;
import org.testng.annotations.Test;

public abstract class TestBase extends AbstractTest {

    @Test
    public HomePageBase fastLogin () {
        LoginPageBase login = initPage(LoginPageBase.class);
        login.clickFastLoginButton();
        return login.clickLoginButton();
    }

}
