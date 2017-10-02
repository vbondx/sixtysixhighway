package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class BasePage {
    AppiumDriver<MobileElement> driver;

    public BasePage(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.driver = driver;
    }
    Logger log = Logger.getLogger("rootLogger");


    @AndroidFindBy (id = "top_item")
    private MobileElement topItemIcon;

    @AndroidFindBy (id = "category_item")
    private MobileElement categoryItemIcon;

    @AndroidFindBy (id = "favorite_item")
    private MobileElement favoriteIcon;

    @AndroidFindBy (id = "profile_item")
    private MobileElement profileIcon;

    @AndroidFindBy (id = "action_basket")
    private MobileElement basketIcon;

    public MainPage goToMainPageBase() {
        log.info("Click on top category icon in bottom navigation");
        topItemIcon.click();
        return new MainPage(driver);
    }

    public CategoriesPage goToCategoriesPageBase() {
        log.info("Click on categories icon in bottom navigation");
        categoryItemIcon.click();
        return new CategoriesPage(driver);
    }

    public FavoriteProductsPage goToFavoritesBase() {
        log.info("Click on favorites icon in bottom navigation");
        favoriteIcon.click();
        return new FavoriteProductsPage(driver);
    }

    public ProfilePage goToProfilePage() {
        log.info("Click on profile icon in bottom navigation as authorized user");
        profileIcon.click();
        return new ProfilePage(driver);
    }

    public BasketPage goToBasketPageBase() {
        log.info("Click on basket icon");
        basketIcon.click();
        return new BasketPage(driver);
    }

    public UnauthorizedPage goToUnAuthPage() {
        log.info("Click on profile icon in bottom navigation as unauthorized user");
        profileIcon.click();
        return new UnauthorizedPage(driver);
    }

    public ArrayList dataList() {
        String registeredEmail = "minnnune@gmail.com";     //SET YOUR REGISTERED EMAIL
        String passwordForRegisteredEmail = "1gp7mn24";     //SET YOUR PASSWORD FOR THIS EMAIL
        String registeredPhoneNumber = "+380990280442";     //SET YOUR REGISTERED PHONE NUMBER
        String phoneNumberShorterThanTwelve = "+3093028044"; //OTHER DATA FOR TEST
        String notRegisteredPhoneNumber = "+380632350342";
        String phoneNumberLongerThanTwelve = "+3809303333333";
        String incorrectEmail = "test@";
        String notRegisteredEmail = "test@test.com";
        String registeredMultiAccountEmail = "";            //TODO
        String registeredMultiAccountPhone = "";            //TODO
        String incorrectEmailTooShortDomainZone = "test@gmail.c";
        String incorrectEmailTooShortDomain = "test@.com";
        String registeredPhoneNumberWithoutPlus = "380990280442"; //SET YOUR REGISTERED PHONE NUMBER WITHOUT PLUS
        String PhoneNumberShorterThanTwelveWithoutPlus = "38093028044";

        ArrayList list = new ArrayList();
        list.add(registeredEmail);
        list.add(passwordForRegisteredEmail);
        list.add(registeredPhoneNumber);
        list.add(phoneNumberShorterThanTwelve);
        list.add(notRegisteredPhoneNumber);
        list.add(phoneNumberLongerThanTwelve);
        list.add(incorrectEmail);
        list.add(notRegisteredEmail);
        list.add(registeredMultiAccountEmail);
        list.add(registeredMultiAccountPhone);
        list.add(incorrectEmailTooShortDomainZone);
        list.add(incorrectEmailTooShortDomain);
        list.add(registeredPhoneNumberWithoutPlus);
        list.add(PhoneNumberShorterThanTwelveWithoutPlus);
        return list;
    }

    public void setConnectionAirPlane() {
        ((AndroidDriver) driver).setConnection(Connection.NONE);
    }
}
