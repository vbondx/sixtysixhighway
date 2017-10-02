package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class UnauthorizedPage extends BasePage {
    public UnauthorizedPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "btnLoginProfile")
    private MobileElement signInButton;

    @AndroidFindBy (id = "tvWriteUsUnauthorizedProfile")
    private MobileElement writeUsButton;

    @AndroidFindBy (id = "tvUnauthorizedAppLang")
    private MobileElement languageButton;

    public SignInPage goToSignInPage() {
        log.info("Click on Sign In button");
        signInButton.click();
        return new SignInPage(driver);
    }
}
