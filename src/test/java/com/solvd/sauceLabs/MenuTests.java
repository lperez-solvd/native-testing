package com.solvd.sauceLabs;

import com.solvd.sauceLabs.mobile.common.pages.AboutPageBase;
import com.solvd.sauceLabs.mobile.common.pages.HomePageBase;
import com.solvd.sauceLabs.mobile.common.pages.LeftNavMenuBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTests extends TestBase {

    @Test
    public void testAboutButton() {
        HomePageBase home = fastLogin();

        LeftNavMenuBase menu = home.clickMenuButton();
        AboutPageBase about = menu.clickAboutButton();

        Assert.assertEquals(about.getTitleText(), "Website andmobiletesting atevery stage ofdevelopment", "The web page title is not the expected");
    }
}
