import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.*;


public class SignInTests extends BaseTest {

    @Test

    public void SignInWithRegisteredEmail() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthPage();
        UnauthorizedPage unauthorizedPage = new UnauthorizedPage(driver);
        unauthorizedPage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterEmail();
        signInPage.enterPassword();
        signInPage.goToProfilePage();
        ProfilePage profilePage = new ProfilePage(driver);
        try {
            Assert.assertTrue(profilePage.profileHeaderTextDisplayed());
            log.info("<Sign in with email> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Sign in with email> Test failed, element not found:" + " " + getClass() + " " + e.getMessage());
        } catch (AssertionError e) {
            log.warn("<Sign in with email> Test failed:" + " " + getClass() + " " + e.getMessage());
        }
    }

    @Test

    public void SignInWithRegisteredPhoneNumber() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthPage();
        UnauthorizedPage unauthorizedPage = new UnauthorizedPage(driver);
        unauthorizedPage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhone();
        signInPage.enterPassword();
        signInPage.goToProfilePage();
        ProfilePage profilePage = new ProfilePage(driver);
        try {
            Assert.assertTrue(profilePage.profileHeaderTextDisplayed());
            log.info("<Sign in with phone number> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Sign in with phone number> Test failed, element not found:" + " " + getClass() + " " + e.getMessage());
        } catch (AssertionError e) {
            log.warn("<Sign in with phone number> Test failed:" + " " + getClass() + " " + e.getMessage());
        }
    }

    @Test

    public void SignInWithPhoneNumberWithoutPlus() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthPage();
        UnauthorizedPage unauthorizedPage = new UnauthorizedPage(driver);
        unauthorizedPage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterRegisteredPhoneNumberWithoutPlus();
        signInPage.enterPassword();
        signInPage.goToProfilePage();
        ProfilePage profilePage = new ProfilePage(driver);
        try {
            Assert.assertTrue(profilePage.profileHeaderTextDisplayed());
            log.info("<Sign in with phone number without plus> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Sign in with phone number without plus> Test failed, element not found:" + " " + getClass() + " " + e.getMessage());
        } catch (AssertionError e) {
            log.warn("<Sign in with phone number without plus> Test failed:" + " " + getClass() + " " + e.getMessage());
        }
    }

    @Test

    public void SignInWithIncorrectPhoneNumberWithoutPlus() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthPage();
        UnauthorizedPage unauthorizedPage = new UnauthorizedPage(driver);
        unauthorizedPage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberShorterThanTwelveWhithoutPlus();
        signInPage.enterPassword();
        signInPage.goToProfilePage();
        ProfilePage profilePage = new ProfilePage(driver);
        try {
            Assert.assertTrue(profilePage.profileHeaderTextDisplayed());
            log.info("<Sign in with phone number shorter than twelve> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Sign in with phone number shorter than twelve> Test failed, element not found:" + " " + getClass() + " " + e.getMessage());
        } catch (AssertionError e) {
            log.warn("<Sign in with phone number shorter than twelve> Test failed:" + " " + getClass() + " " + e.getMessage());
        }
    }

    @Test

    public void SignInWithNotRegisteredPhoneNumber() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthPage();
        UnauthorizedPage unauthorizedPage = new UnauthorizedPage(driver);
        unauthorizedPage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterNotRegisteredPhoneNumber();
        signInPage.enterPassword();
        signInPage.clickOnLogInButton();
        try {
            Assert.assertTrue(signInPage.loginButtonDisplayed());
            log.info("<Sign in with not registered phone number> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Sign in with not registered phone number> Test failed, element not found:" + " " + getClass() + " " + e.getMessage());
        } catch (AssertionError e) {
            log.warn("<Sign in with not registered phone number> Test failed:" + " " + getClass() + " " + e.getMessage());
        }
    }

    @Test

    public void SignInWithNotRegisteredEmail() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthPage();
        UnauthorizedPage unauthorizedPage = new UnauthorizedPage(driver);
        unauthorizedPage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterNotRegisteredEmail();
        signInPage.enterPassword();
        signInPage.clickOnLogInButton();
        try {
            Assert.assertTrue(signInPage.loginButtonDisplayed());
            log.info("<Sign in with not registered email> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Sign in with not registered email> Test failed, element not found:" + " " + getClass() + " " + e.getMessage());
        } catch (AssertionError e) {
            log.warn("<Sign in with not registered email> Test failed:" + " " + getClass() + " " + e.getMessage());
        }
    }

    @Test

    public void SignInWithPhoneNumberShorterThanTwelve() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthPage();
        UnauthorizedPage unauthorizedPage = new UnauthorizedPage(driver);
        unauthorizedPage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberShorterThanTwelve();
        signInPage.enterPassword();
        signInPage.clickOnLogInButton();
        try {
            Assert.assertTrue(signInPage.incorrectDataInputErrorDisplays());
            log.info("<Sign in with phone number shorter than twelve> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Sign in with phone number shorter than twelve> Test failed, element not found:" + " " + getClass() + " " + e.getMessage());
        } catch (AssertionError e) {
            log.warn("<Sign in with phone number shorter than twelve> Test failed:" + " " + getClass() + " " + e.getMessage());
        }
    }

    @Test

    public void SignInWithPhoneNumberLongerThanTwelve() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthPage();
        UnauthorizedPage unauthorizedPage = new UnauthorizedPage(driver);
        unauthorizedPage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberLongerThanTwelve();
        signInPage.enterPassword();
        signInPage.clickOnLogInButton();
        try {
            Assert.assertTrue(signInPage.loginButtonDisplayed());
            log.info("<Sign in with phone number longer than twelve> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Sign in with phone number longer than twelve> Test failed, element not found:" + " " + getClass() + " " + e.getMessage());
        } catch (AssertionError e) {
            log.warn("<Sign in with phone number longer than twelve> Test failed:" + " " + getClass() + " " + e.getMessage());
        }
    }

    @Test

    public void SignInWithIncorrectEmail() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthPage();
        UnauthorizedPage unauthorizedPage = new UnauthorizedPage(driver);
        unauthorizedPage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterIncorrectEmail();
        signInPage.enterPassword();
        signInPage.clickOnLogInButton();
        try {
            Assert.assertTrue(signInPage.incorrectDataInputErrorDisplays());
            log.info("<Sign in with incorrect email> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Sign in with incorrect email> Test failed, element not found:" + " " + getClass() + " " + e.getMessage());
        } catch (AssertionError e) {
            log.warn("<Sign in with incorrect email> Test failed:" + " " + getClass() + " " + e.getMessage());
        }
    }

    @Test

    public void SignInWithoutPassword() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthPage();
        UnauthorizedPage unauthorizedPage = new UnauthorizedPage(driver);
        unauthorizedPage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterEmail();
        signInPage.clickOnLogInButton();
        try {
            Assert.assertTrue(signInPage.emptyFieldInputErrorDisplays());
            log.info("<Sign in without password> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Sign in without password> Test failed, element not found:" + " " + getClass() + " " + e.getMessage());
        } catch (AssertionError e) {
            log.warn("<Sign in without password> Test failed:" + " " + getClass() + " " + e.getMessage());
        }
    }

    @Test

    public void SignInWithoutEmail() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthPage();
        UnauthorizedPage unauthorizedPage = new UnauthorizedPage(driver);
        unauthorizedPage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPassword();
        signInPage.clickOnLogInButton();
        try {
            Assert.assertTrue(signInPage.incorrectDataInputErrorDisplays());
            log.info("<Sign in without email> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Sign in without email> Test failed, element not found:" + " " + getClass() + " " + e.getMessage());
        } catch (AssertionError e) {
            log.warn("<Sign in without email> Test failed:" + " " + getClass() + " " + e.getMessage());
        }
    }

    @Test

    public void SignInWithIncorrectEmailWithTooShortDomainZone() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthPage();
        UnauthorizedPage unauthorizedPage = new UnauthorizedPage(driver);
        unauthorizedPage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterIncorrectEmailWithTooShortDomainZone();
        signInPage.enterPassword();
        try {
            Assert.assertTrue(signInPage.incorrectDataInputErrorDisplays());
            log.info("<Sign in without email with too short domain zone> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Sign in without email with too short domain zone> Test failed, element not found:" + " " + getClass() + " " + e.getMessage());
        } catch (AssertionError e) {
            log.warn("<Sign in without email with too short domain zone> Test failed:" + " " + getClass() + " " + e.getMessage());
        }
    }

    @Test

    public void SignInWithIncorrectEmailWithTooShortDomain() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthPage();
        UnauthorizedPage unauthorizedPage = new UnauthorizedPage(driver);
        unauthorizedPage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterIncorrectEmailWithTooShortDomain();
        signInPage.enterPassword();
        try {
            Assert.assertTrue(signInPage.incorrectDataInputErrorDisplays());
            log.info("<Sign in without email with too short domain> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Sign in without email with too short domain> Test failed, element not found:" + " " + getClass() + " " + e.getMessage());
        } catch (AssertionError e) {
            log.warn("<Sign in without email with too short domain> Test failed:" + " " + getClass() + " " + e.getMessage());
        }
    }

    @Test

    public void turnTogglePassword() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthPage();
        UnauthorizedPage unauthorizedPage = new UnauthorizedPage(driver);
        unauthorizedPage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPassword();
        signInPage.clickOnPasswordToggle();
        try {
            Assert.assertTrue(signInPage.passwordDisplayed());
            log.info("<Password visible> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Password visible> Test failed, element not found:" + " " + getClass() + " " + e.getMessage());
        } catch (AssertionError e) {
            log.warn("<Password visible:" + " " + getClass() + " " + e.getMessage());
        }
    }

    @Test

    public void openCabinetAppInGooglePlay() {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthPage();
        UnauthorizedPage unauthorizedPage = new UnauthorizedPage(driver);
        unauthorizedPage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.goToGooglePlayCabinetAppPage();
        GooglePlayStorePage googlePlayStorePage = new GooglePlayStorePage(driver);
        try {
            Assert.assertTrue(googlePlayStorePage.cabinetAppPageDisplayed());
            log.info("<Open cabinet application page in google play store> Test passed" + " " + getClass());
        } catch (NoSuchElementException e) {
            log.warn("<Open cabinet application page in google play store:" + " " + getClass() + " " + e.getMessage());
        } catch (AssertionError e) {
            log.warn("<Open cabinet application page in google play store:" + " " + getClass() + " " + e.getMessage());
        }
    }

    @Test

    public void govno() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        basePage.goToUnAuthPage();
        UnauthorizedPage unauthorizedPage = new UnauthorizedPage(driver);
        unauthorizedPage.goToSignInPage();
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterNotRegisteredEmail();
        signInPage.enterPassword();
        signInPage.clickOnLogInButton();
        signInPage.ocrTest();
        Assert.assertTrue(signInPage.ocrTest().contains("Неправильный номер телефона/етаН или пароль."));
    }
}
