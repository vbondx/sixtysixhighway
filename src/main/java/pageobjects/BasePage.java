package pageobjects;

import com.asprise.ocr.Ocr;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
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
        String registeredPhoneNumber = "+380632350342";     //SET YOUR REGISTERED PHONE NUMBER
        String phoneNumberShorterThanTwelve = "+3093028044"; //OTHER DATA FOR TEST
        String notRegisteredPhoneNumber = "+380632350348";
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

    public void setConnection() {                                       // WORKS ONLY WITH GENYMOTION VIRTUAL DEVICE
        ((AndroidDriver) driver).setConnection(Connection.NONE);
    }

    public void captureScreenshot() {                        // SCREENSHOT CAPTURE FOR OCR
        log.info("Screeshot capture");
        File scrFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        try {
            String filePath = System.getProperty("user.dir") +"/toastmessages/toastmessage.png";
            FileUtils.copyFile(scrFile,  new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String charRecognition() {                                   // ASPRICE OCR
        log.info("Image recognition setup");
        Ocr.setUp(); // one time setup
        Ocr ocr = new Ocr(); // create a new OCR engine

        ocr.startEngine("rus", Ocr.SPEED_FAST);                   // LANG
        String s = ocr.recognize(new File[] {new File(System.getProperty("user.dir") + "/toastmessages/toastmessage.png")},
                Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT); // PLAINTEXT | XML | PDF | RTF
        System.out.println("Result: " + s);
        ocr.stopEngine();
        System.out.println(s);
        return s;
    }

    public WebDriverWait initWaiter() {
        WebDriverWait wd = new WebDriverWait(driver, 5);        // WEBDRIVER WAITER
        return wd;
    }


    //    public void getToast() {                                          // Tess4j+Tesseract OCR
//        File imagePath = new File(System.getProperty("user.dir"));
//        File imageFile = new File (imagePath + "/toastmessages/toastmessage1.png");
//        tesseract.TessBaseAPI api = new tesseract.TessBaseAPI();
//        //api.Init("src/main/resources/data", "eng");
//        Tesseract instance = Tesseract.getInstance();
//
//        try {
//
//            String result = instance.doOCR(imageFile);
//            System.out.println(result);
//
//        } catch (TesseractException e) {
//            System.err.println(e.getMessage());
//        }
//    }

//    public String getToastMessage() throws InterruptedException {           // Tesseract+Leptonica OCR
//
//        String filePath = System.getProperty("user.dir");
//        File file = new File(filePath, "/toastmessages");
//        sleep(2000l);
//        captureScreenshot(filePath + "/toastmessages");
//        String str = "";
//        BytePointer outText;
//        tesseract.TessBaseAPI api = new tesseract.TessBaseAPI();
//
//        if (api.Init(".", "RUS") != 0) {
//            System.err.println("Could not initialize tesseract.");
//            System.exit(1);
//        }
//
//        lept.PIX image = pixRead(file+"/toastmessage1.png");
//        api.SetImage(image);
//
//        // Get OCR result
//        outText = api.GetUTF8Text();
//        str = outText.getString();
//        System.out.println("OCR output:\n" + str);
//
//        // Destroy used object and release memory
//        api.End();
//        outText.deallocate();
//        pixDestroy(image);
//        System.out.println(str);
//        return str;
//    }
}
