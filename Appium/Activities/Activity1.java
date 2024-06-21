package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options caps = new UiAutomator2Options()
        .setPlatformName("android")
        .setAutomationName("UiAutomator2")
        .setAppPackage("com.android.calculator2")
        .setAppActivity(".Calculator")
        .noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL,caps);
    }
    @Test
    public void multiplyTest(){
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/op_mul")).click();
        driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String result = driver.findElement(AppiumBy.id("result")).getText();

        // Assertion
        Assert.assertEquals(result, "45");
    }

    public void tearDown() {
        driver.quit();
    }
}
