package com.solvd.sauceLabs.mobile.ios.pages;

import com.solvd.sauceLabs.mobile.common.pages.CheckOutSuccessPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckOutSuccessPageBase.class)
public class CheckOutSuccessPage extends CheckOutSuccessPageBase implements IMobileUtils {

    public CheckOutSuccessPage(WebDriver driver) {
        super(driver);
    }
}
