package StepDefinition;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstExample extends BaseClass {
    @BeforeAll
    public static void setup() {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
    @AfterAll
    public static void teardown(){
        driver.quit();
    }
    @Given("the user is on TS homepage")
    public  void openHomepage(){
        driver.get("https://v1.training-support.net/");
        Assertions.assertEquals("Training Support", driver.getTitle());
    }

    @When("user clicks on About us link")
    public void clickAboutLink(){
        driver.findElement(By.id("about-link")).click();
    }

    @Then("user gets redirected to home page")
    public void verifyAboutPage(){
        Assertions.assertEquals("About Training Support",driver.getTitle());
    }

}
