package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import javafx.beans.NamedArg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ProfilePage extends BasePage {
    public ProfilePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Профиль']")
    private MobileElement profileHeader;

    @AndroidFindBy (id = "action_basket")
    private MobileElement basketIcon;

    public boolean profileHeaderTextDisplayed() {
        initWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Профиль']")));
        boolean b = profileHeader.isDisplayed();
        return b;
    }

    public void goToBasket() {
        basketIcon.click();
    }
}
