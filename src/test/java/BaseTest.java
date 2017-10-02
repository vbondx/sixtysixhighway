import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    Logger log = Logger.getLogger("rootLogger");
    static AndroidDriver<MobileElement> driver;

    @BeforeMethod
    public void setUp() {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/Android/app");
        File app = new File(appDir, "app-prodProm-release.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Device");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "ua.prom.b2c");
        capabilities.setCapability("appActivity", "ua.prom.b2c.ui.main.MainActivity");
        capabilities.setCapability("newCommandTimeout", "60");
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    @AfterMethod

    public void tearDown () {
        log.info("***END TEST***");
        driver.quit();

    }

    @BeforeMethod

    public void setUpBeforeMethod() {
        log.info("***START TEST***");
        //driver.launchApp();
    }
}
