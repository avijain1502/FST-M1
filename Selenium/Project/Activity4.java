package Projects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity4 {

    @Test
    public void addEmployee() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        driver.findElement(By.id("menu_pim_viewPimModule")).click();

        driver.findElement(By.id("btnAdd")).click();

        driver.findElement(By.id("firstName")).sendKeys("Avi");
        driver.findElement(By.id("lastName")).sendKeys("jain");
        driver.findElement(By.id("btnSave")).click();


        String name = driver.findElement(By.id("personal_txtEmpFirstName")).getAttribute("value");
        Assert.assertEquals(name , "Avi");
    }
}
