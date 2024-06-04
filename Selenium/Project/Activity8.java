package Projects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://alchemy.hguy.co/orangehrm");
    }
    @Test
    public void AddQualification() {
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        driver.findElement(By.id("menu_dashboard_index")).click();
        driver.findElement(By.xpath("//span[text()='Apply Leave']")).click();

        Select leave = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        leave.selectByVisibleText("DayOff");
        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2024-06-27");
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys(Keys.TAB);
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys(Keys.TAB);
        driver.findElement(By.id("applyBtn")).click();

        driver.findElement(By.xpath("//a[text()='My Leave']")).click();
        String status = driver.findElement(By.xpath("//a[text()='2024-06-27']/../../td[6]/a")).getText();
        Assert.assertEquals(status,"Pending Approval(1.00)");

    }
    @AfterClass
    public void ramp() {
        driver.close();
    }
}
