package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.concurrent.TimeUnit;

public class SuccessForgotPasswordPage extends BasePage {
    public SuccessForgotPasswordPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (id = "btnCheckMail")
    private MobileElement checkMailButton;

    public void setConnection() {
        ((AndroidDriver) driver).setConnection(Connection.AIRPLANE);
    }
}
