package com.solvd.sauceLabs.mobile.common.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    ExtendedWebElement userNameInput;
    ExtendedWebElement passwordInput;
    ExtendedWebElement loginButton;

    ExtendedWebElement fastLoginButton;

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void enterUserName(String text);

    public abstract void enterPassword(String text);

    public abstract HomePageBase clickLoginButton();

    public abstract void clickFastLoginButton();


}
