package Project;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Activity1 {
    AndroidDriver driver;
    WebDriverWait wait;

    List taskDescription = new ArrayList<>();

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void addAndValidateTask() throws InterruptedException{
        addTasks("Complete Activity with Google Task");
        validateAddedTasks("Complete Activity with Google Task");
        addTasks("Complete Activity with Google Keep");
        validateAddedTasks("Complete Activity with Google Keep");
        addTasks("Complete the second Activity Google Keep");
        validateAddedTasks("Complete the second Activity Google Keep");



    }
    public void addTasks (String taskName) throws InterruptedException{
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Create new task")));
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys(taskName);
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
    }

    public void validateAddedTasks(String taskName){
        List<WebElement> tasks =driver.findElements(AppiumBy.id("com.google.android.apps.tasks:id/task_name"));
        for(WebElement task:tasks){
            taskDescription.add(task.getText());
            System.out.println(task.getText());
        }
        Assert.assertTrue(taskDescription.contains(taskName));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

