package pageobjects;

import com.asprise.ocr.Ocr;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.bytedeco.javacpp.tesseract;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class SignInPage extends BasePage {
    public SignInPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (id = "name_editText")
    private MobileElement emailOrPhoneField;

    @AndroidFindBy (id = "password_editText")
    private MobileElement passwordField;

    @AndroidFindBy (id = "text_input_password_toggle")
    private MobileElement eyeButton;

    @AndroidFindBy (id = "btnLogin")
    private MobileElement loginButton;

    @AndroidFindBy (id = "tvForgotPassword")
    private MobileElement forgotPasswordLink;

    @AndroidFindBy (id = "openCabinet_button")
    private MobileElement cabinetAppLink;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Хочу продавать на Prom.ua']")
    private MobileElement cabinetAppLinkText;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Обязательно для заполнения']")
    private MobileElement emptyFieldInputError;

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='Неверный формат']")
    private MobileElement incorrectDataInputError;

    @AndroidFindBy (xpath = "//android.widget.ImageButton[@content-desc='Перейти вверх']")
    private MobileElement goBackButton;

    @AndroidFindBy (id = "text_input_password_toggle")
    private MobileElement passwordToggleButton;

    public void enterEmail() {
        log.info("Enter registered email:" + " " + dataList().get(0));
        emailOrPhoneField.sendKeys(dataList().get(0).toString());
    }

    public void enterPassword() {
        log.info("Enter password for registered user:" + " " + dataList().get(1));
        passwordField.sendKeys(dataList().get(1).toString());
    }

    public void enterPhone () {
        log.info("Enter registered phone number" + " " + dataList().get(2));
        emailOrPhoneField.sendKeys(dataList().get(2).toString());
    }

    public void enterPhoneNumberShorterThanTwelve() {
        log.info("Enter incorrect phone number shorter than twelve" + " " + dataList().get(3));
        emailOrPhoneField.sendKeys(dataList().get(3).toString());
    }

    public void enterNotRegisteredPhoneNumber() {
        log.info("Enter not registered phone number" + " " + dataList().get(4));
        emailOrPhoneField.sendKeys(dataList().get(4).toString());
    }

    public void enterPhoneNumberLongerThanTwelve() {
        log.info("Enter incorrect phone number longer than twelve" + " " + dataList().get(5));
        emailOrPhoneField.sendKeys(dataList().get(5).toString());
    }

    public void enterIncorrectEmail() {
        log.info("Enter incorrect email:" + " " + dataList().get(6));
        emailOrPhoneField.sendKeys(dataList().get(6).toString());
    }

    public void enterNotRegisteredEmail() {
        log.info("Enter not registered email" + " " + dataList().get(7));
        emailOrPhoneField.sendKeys(dataList().get(7).toString());
    }

    public void enterRegisteredMultiAccountEmail() {            //TODO

    }

    public void enterRegisteredMultiAccountPhone() {            //TODO

    }

    public void enterIncorrectEmailWithTooShortDomainZone() {
        log.info("Enter incorrect email" + " " + dataList().get(10));
        emailOrPhoneField.sendKeys(dataList().get(10).toString());
    }

    public void enterIncorrectEmailWithTooShortDomain() {
        log.info("Enter incorrect email" + " " + dataList().get(11));
        emailOrPhoneField.sendKeys(dataList().get(11).toString());
    }

    public void enterRegisteredPhoneNumberWithoutPlus() {
        log.info("Enter registered phone number without plus" + " " + dataList().get(12));
        emailOrPhoneField.sendKeys(dataList().get(12).toString());
    }

    public void enterPhoneNumberShorterThanTwelveWithoutPlus() {
        log.info("Enter incorrect phone number longer than twelve without plus" + " " + dataList().get(13));
        emailOrPhoneField.sendKeys(dataList().get(13).toString());
    }

    public void clickOnPasswordToggle() {
        passwordToggleButton.click();
    }

    public boolean passwordDisplayed() {
        boolean b = driver.findElementByXPath("//android.widget.EditText[@text='" + dataList().get(1).toString() + "']").isDisplayed();
        return b;
    }

    public boolean emptyFieldInputErrorDisplays() {
        log.info("Search empty field input error");
        boolean b = emptyFieldInputError.isDisplayed();
        return b;
    }

    public boolean incorrectDataInputErrorDisplays() {
        log.info("Search incorrect data input error");
        boolean b = incorrectDataInputError.isDisplayed();
        return b;
    }

    public SignInPage goBack() {
        log.info("Click on back button");
        goBackButton.click();
        return new SignInPage(driver);
    }

    public ProfilePage goToProfilePage() {
        log.info("Click on Log in button");
        loginButton.click();
        return new ProfilePage(driver);
    }

    public void clickOnLogInButton() {
        log.info("Click on Log In button");
        loginButton.click();
    }

    public GooglePlayStorePage goToGooglePlayCabinetAppPage() {
        log.info("Click on sellers application link");
        cabinetAppLink.click();
        return new GooglePlayStorePage(driver);
    }

    public ForgotPasswordPage goToRecoveryPasswordPage() {
        log.info("Click on forgot password");
        forgotPasswordLink.click();
        return new ForgotPasswordPage(driver);
    }

    public boolean loginButtonDisplayed() {
        boolean b = loginButton.isDisplayed();
        return b;
    }
}
