package Projects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity6 {
    @Test
    public void EditEmployee() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        WebElement directory = driver.findElement(By.id("menu_directory_viewDirectory"));
        directory.isDisplayed();
        directory.isEnabled();

        directory.click();

        WebElement pageHeading = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(pageHeading.getText(), "Search Directory");

        driver.close();

    }
}
