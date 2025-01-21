package com.solvd.sauceLabs;

import com.solvd.sauceLabs.mobile.common.pages.DrawingPageBase;
import com.solvd.sauceLabs.mobile.common.pages.HomePageBase;
import com.solvd.sauceLabs.mobile.common.pages.LeftNavMenuBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DrawingTests extends TestBase {
    @Test(enabled = false)
    public void drawingImageAndSaveTest() {
        HomePageBase home = fastLogin();

        LeftNavMenuBase menu = home.clickMenuButton();
        DrawingPageBase drawing = menu.clickDrawingButton();

        drawing.makeSignature();
        drawing.clickSaveButton();
        drawing.clickOkButton();
        drawing.clickClearButton();

    }

    @Test()
    public void drawingAndFindingImageTest() {
        HomePageBase home = fastLogin();

        LeftNavMenuBase menu = home.clickMenuButton();
        DrawingPageBase drawing = menu.clickDrawingButton();

        drawing.makeSignature();

        Assert.assertTrue(drawing.checkForElementPresence(), "The element is not present so the image hasn't been recognized");
    }

}
