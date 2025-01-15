package com.solvd.sauceLabs;

import com.solvd.sauceLabs.mobile.common.pages.*;
import com.solvd.sauceLabs.mobile.ios.pages.DrawingPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MenuTests extends TestBase {

    @Test
    public void testAboutButton() {
        HomePageBase home = fastLogin();

        LeftNavMenuBase menu = home.clickMenuButton();
        AboutPageBase about = menu.clickAboutButton();

        Assert.assertEquals(about.getTitleText(), "Website andmobiletesting atevery stage ofdevelopment", "The web page title is not the expected");
    }

    @Test(enabled = false)
    public void drawingImageAndSaveTest() {
        HomePageBase home = fastLogin();

        LeftNavMenuBase menu = home.clickMenuButton();
        DrawingPageBase drawing = menu.clickDrawingButton();

        drawing.makeSignature();
        drawing.clickSaveButton();
        drawing.clickOkButton();
        drawing.clickClearButton();
        //Assert.assertTrue(drawing.findElementByImage(), "The element hasn't been found");
        // drawing.checkForElementPresence();
        //drawing.returnElementData();

    }

    @Test(enabled = true)
    public void drawingAndFindingImageTest() {
        HomePageBase home = fastLogin();

        LeftNavMenuBase menu = home.clickMenuButton();
        DrawingPageBase drawing = menu.clickDrawingButton();

        drawing.makeSignature();

        //Assert.assertTrue(drawing.findElementByImage(), "The element hasn't been found");
        //drawing.checkForElementPresence();
        System.out.println(drawing.returnElementData());
    }

    @Test
    public void usingGeoLocation() {
        HomePageBase home = fastLogin();
        LeftNavMenuBase menu = home.clickMenuButton();
        GeoLocationPageViewBase geoPage = menu.clickGeoLocationButton();

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(geoPage.getLongitudeFromScreen(), geoPage.getLocationLongitude(), "The two longitudes doesn't match");
        sa.assertEquals(geoPage.getLatitudeFromScreen(), geoPage.getLocationLatitude(), "The two latitudes doesn't match");

        sa.assertAll();
    }

    @Test
    public void usingWebViewer() {
        HomePageBase home = fastLogin();
        LeftNavMenuBase menu = home.clickMenuButton();
        WebViewPageBase webView = menu.clickWebViewButton();
        webView.sendUrl("www.google.com");
        WebViewTargetPageBase targetPage = webView.clickGoToButton();

        Assert.assertTrue(targetPage.isLogoPresent(), "The expected logo is not present"); ;

    }
}


