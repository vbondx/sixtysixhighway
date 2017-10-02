package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ForgotPasswordPage extends BasePage {
    public ForgotPasswordPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy (id = "etMailPhone")
    private MobileElement emailOrPhoneField;

    @AndroidFindBy (id = "btnContinue")
    private MobileElement continueButton;

    public void enterEmail() {
        log.info("Enter registered email" + " " + dataList().get(0));
        emailOrPhoneField.sendKeys(dataList().get(0).toString());
    }

    public void enterPhone() {
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
        emailOrPhoneField.sendKeys(dataList().get(6).toString());
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

    public void enterPhoneNumberShorterThanTwelveWhithoutPlus() {
        log.info("Enter incorrect phone number longer than twelve without plus" + " " + dataList().get(13));
        emailOrPhoneField.sendKeys(dataList().get(13).toString());
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    public SuccessForgotPasswordPage goToSuccesPage() {
        continueButton.click();
        return new SuccessForgotPasswordPage(driver);
    }
}
