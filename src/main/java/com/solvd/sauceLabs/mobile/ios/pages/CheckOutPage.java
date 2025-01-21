package com.solvd.sauceLabs.mobile.ios.pages;

import com.solvd.sauceLabs.mobile.common.pages.CheckOutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckOutPageBase.class)
public class CheckOutPage extends CheckOutPageBase {

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

}
