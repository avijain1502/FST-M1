package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {
    AndroidDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException, InterruptedException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL, options);

        driver.get("https://v1.training-support.net");
        Thread.sleep(10000);
    }
    @Test
    public void chromeTest() throws InterruptedException {
        String pageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[@text='Training Support']")).getText();

        System.out.println("Heading: " + pageHeading);
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"About Us\"]")).click();

        String aboutPageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']")).getText();
        System.out.println(aboutPageHeading);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}