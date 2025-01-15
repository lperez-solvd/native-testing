package com.solvd.sauceLabs.mobile.ios.pages;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase implements IMobileUtils {

    @ExtendedFindBy(iosPredicate = "name == \"Signature Pad demo\"")
    ExtendedWebElement signaturePad;
    @ExtendedFindBy(iosPredicate = "name == \"test-CLEAR\"")
    ExtendedWebElement clearButton;
    @ExtendedFindBy(iosPredicate = "name == \"test-SAVE\"")
    ExtendedWebElement saveButton;
    @ExtendedFindBy(iosPredicate = "name == \"OK\"")
    ExtendedWebElement successfullySavedOkButton;
    @ExtendedFindBy(image = "images/myScreenshotRESIZEDx2.png")
    ExtendedWebElement signaturePadByImage;


    @Override
    public ExtendedWebElement getSignaturePadByImage() {
        return signaturePadByImage;
    }

    @Override
    public void makeSignature() {
        int startPointX = signaturePad.getLocation().getX() + 70;
        int startPointY = signaturePad.getLocation().getY() + 55;
        dragAndDrop(startPointX, startPointY, startPointX, startPointY + 110, Duration.ofSeconds(1), Duration.ofSeconds(1));
        dragAndDrop(startPointX, startPointY + 110, startPointX + 100, startPointY + 110, Duration.ofSeconds(1), Duration.ofSeconds(1));
        dragAndDrop(startPointX + 100, startPointY + 110, startPointX + 100, startPointY, Duration.ofSeconds(1), Duration.ofSeconds(1));
        dragAndDrop(startPointX + 100, startPointY, startPointX, startPointY, Duration.ofSeconds(1), Duration.ofSeconds(1));

        int centerX = startPointX + 50;
        int centerY = startPointY + 55;

        dragAndDrop(startPointX, centerY, startPointX + 100, centerY, Duration.ofSeconds(1), Duration.ofSeconds(1));

        dragAndDrop(centerX, startPointY, centerX, startPointY + 110, Duration.ofSeconds(1), Duration.ofSeconds(1));

    }

    @Override
    public void clickClearButton() {
        clearButton.click();
    }

    @Override
    public void clickSaveButton() {
        saveButton.click();
    }

    @Override
    public void clickOkButton() {
        cancelAlert();
        successfullySavedOkButton.click();
    }

    public String returnElementData() {
        return signaturePadByImage.getLocation().toString() + signaturePadByImage.getName();
    }

    public String checkForElementPresence() {
        waitUntil(d -> signaturePadByImage.isElementPresent(),20);
        return String.valueOf(signaturePadByImage.isElementPresent(20));
    }


    public DrawingPage(WebDriver driver) {
        super(driver);
    }
}
