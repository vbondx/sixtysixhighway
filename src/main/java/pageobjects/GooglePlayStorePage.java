package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GooglePlayStorePage extends BasePage {
    public GooglePlayStorePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Кабинет продавца Prom.ua']")
    private MobileElement cabinetAppTitle;

    public boolean cabinetAppPageDisplayed() {
        boolean b = cabinetAppTitle.isDisplayed();
        return b;
    }
}
