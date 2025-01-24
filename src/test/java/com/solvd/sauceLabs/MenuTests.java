package com.solvd.sauceLabs;

import com.solvd.sauceLabs.mobile.common.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MenuTests extends TestBase {

    @Test
    public void verifyAboutPageTest() {
        HomePageBase home = fastLogin();

        LeftNavMenuBase menu = home.clickMenuButton();
        AboutPageBase about = menu.clickAboutButton();

        Assert.assertEquals(about.getTitleText(), "Website and mobile testing at every stage of development", "The web page title is not the expected");
    }

    @Test
    public void verifyGeoLocationFunctionalityTest() {
        HomePageBase home = fastLogin();
        LeftNavMenuBase menu = home.clickMenuButton();
        GeoLocationPageViewBase geoPage = menu.clickGeoLocationButton();

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(geoPage.getLongitudeFromScreen(), geoPage.getLocationLongitude(), "The two longitudes doesn't match");
        sa.assertEquals(geoPage.getLatitudeFromScreen(), geoPage.getLocationLatitude(), "The two latitudes doesn't match");

        sa.assertAll();
    }

    @Test
    public void verifyWebViewerFunctionalityTest() {
        HomePageBase home = fastLogin();
        LeftNavMenuBase menu = home.clickMenuButton();
        WebViewPageBase webView = menu.clickWebViewButton();
        webView.sendUrl("www.google.com");
        WebViewTargetPageBase targetPage = webView.clickGoToButton();

        Assert.assertTrue(targetPage.isLogoPresent(), "The expected logo is not present");

    }

}


