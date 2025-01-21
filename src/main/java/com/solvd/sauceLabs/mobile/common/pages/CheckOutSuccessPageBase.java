package com.solvd.sauceLabs.mobile.common.pages;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

public abstract class CheckOutSuccessPageBase extends AbstractPage implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-FINISH")
    ExtendedWebElement finishButton;

    public CheckOutSuccessPageBase(WebDriver driver) {
        super(driver);
    }

    public CheckOutFinishPageBase clickFinishButton() {
        swipe(finishButton);
        finishButton.click();
        return initPage(CheckOutFinishPageBase.class);
    }


}
