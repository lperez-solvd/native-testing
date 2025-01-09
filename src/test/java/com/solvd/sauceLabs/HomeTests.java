package com.solvd.sauceLabs;

import com.solvd.sauceLabs.mobile.common.pages.HomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.annotations.Test;

public class HomeTests implements IAbstractTest {

    @Test(description = "Open app test")
    public void openAppTest() {
        HomePageBase home = initPage(HomePageBase.class);
        home.clickCartButton();

    }
}
