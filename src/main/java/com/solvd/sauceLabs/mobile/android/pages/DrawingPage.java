package com.solvd.sauceLabs.mobile.android.pages;

import com.solvd.sauceLabs.mobile.common.pages.DrawingPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.webkit.WebView[@text=\"Signature Pad demo\"]//android.widget.Image")
    ExtendedWebElement signaturePad;
    @ExtendedFindBy(accessibilityId = "test-DRAWING-SCREEN")
    ExtendedWebElement unlockSignaturePadElement;

    @ExtendedFindBy(accessibilityId = "test-CLEAR")
    ExtendedWebElement clearButton;
    @ExtendedFindBy(iosPredicate = "test-SAVE")
    ExtendedWebElement saveButton;
    @FindBy(id = "android:id/button1")
    ExtendedWebElement successfullySavedOkButton;
    @ExtendedFindBy(image = "images/myScreenshotAndroid.png")
    ExtendedWebElement signaturePadByImage;
    @ExtendedFindBy(image = "images/mySavedImageSMALL.png")
    ExtendedWebElement testImage;

    @Override
    public ExtendedWebElement getSignaturePadByImage() {
        return signaturePadByImage;
    }

    @Override
    public void makeSignature() {
        unlockSignaturePadElement.click();
        waitUntil(d -> signaturePad.isElementPresent(), 10);

        int startPointX = signaturePad.getLocation().getX() + 70;
        int startPointY = signaturePad.getLocation().getY() + 55;
        dragAndDrop(startPointX, startPointY, startPointX, startPointY + 110 * 3, Duration.ofSeconds(1), Duration.ofSeconds(1));
        dragAndDrop(startPointX, startPointY + 110 * 3, startPointX + 100 * 3, startPointY + 110 * 3, Duration.ofSeconds(1), Duration.ofSeconds(1));
        dragAndDrop(startPointX + 100 * 3, startPointY + 110 * 3, startPointX + 100 * 3, startPointY, Duration.ofSeconds(1), Duration.ofSeconds(1));
        dragAndDrop(startPointX + 100 * 3, startPointY, startPointX, startPointY, Duration.ofSeconds(1), Duration.ofSeconds(1));

        int centerX = startPointX + 50 * 3;
        int centerY = startPointY + 55 * 3;

        dragAndDrop(startPointX, centerY, startPointX + 100 * 3, centerY, Duration.ofSeconds(1), Duration.ofSeconds(1));

        dragAndDrop(centerX, startPointY, centerX, startPointY + 110 * 3, Duration.ofSeconds(1), Duration.ofSeconds(1));

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

    public boolean checkForElementPresence() {
        waitUntil(d -> signaturePadByImage.isElementPresent(), 20);
        return signaturePadByImage.isElementPresent(20);
    }

    public DrawingPage(WebDriver driver) {
        super(driver);
    }
}
