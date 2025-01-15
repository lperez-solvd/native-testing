package com.solvd.sauceLabs.mobile.android.pages;

import com.solvd.sauceLabs.mobile.common.pages.HomePageBase;
import com.solvd.sauceLabs.mobile.common.pages.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-Username")
    ExtendedWebElement userNameInput;
    @ExtendedFindBy(accessibilityId = "test-Password")
    ExtendedWebElement passwordInput;
    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    ExtendedWebElement loginButton;
    @ExtendedFindBy(accessibilityId = "test-standard_user")
    ExtendedWebElement fastLoginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void enterUserName(String text) {
        userNameInput.type(text);
    }

    public void enterPassword(String text) {
        passwordInput.type(text);
    }

    public HomePageBase clickLoginButton() {
        loginButton.click();
        return initPage(HomePageBase.class);
    }

    public HomePageBase clickFastLoginButton() {
        swipe(fastLoginButton);
        fastLoginButton.click();
        swipe(fastLoginButton, Direction.UP);
        fastLoginButton.click();
        return initPage(HomePageBase.class);
    }


}
