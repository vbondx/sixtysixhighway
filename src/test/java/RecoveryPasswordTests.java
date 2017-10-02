import org.junit.Ignore;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;

public class RecoveryPasswordTests extends BaseTest {

    @Ignore

    public void RecoveryPasswordWithRegisteredEmail() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthPage();
        UnauthorizedPage unauthorizedPage = new UnauthorizedPage(driver);
        unauthorizedPage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.goToRecoveryPasswordPage();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.enterEmail();
        forgotPasswordPage.goToSuccesPage();
        SuccessForgotPasswordPage successForgotPasswordPage = new SuccessForgotPasswordPage(driver);
    }

}
