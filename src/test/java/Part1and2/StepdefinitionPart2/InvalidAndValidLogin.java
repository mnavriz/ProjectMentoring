package Part1and2.StepdefinitionPart2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvalidAndValidLogin {
    WebDriver driver;
    WebDriverWait wait;

    @Given("Open the webpage https://test.campus.techno.study/")
    public void openTheWebpageHttpsTestCampusTechnoStudy() {
        WebDriverManager.chromedriver().setup();
        driver.get("https:\\/\\/test.campus.techno.study\\/");
    }

    @When("I enter my username and password")
    public void iEnterMyUsernameAndPassword(String username, String password) {
        username = "daulet2030@gmail.com";
        password = "TechnoStudy123@";
        driver.findElement(By.cssSelector("input[formcontrolname = \"username\"]")).sendKeys(username);
        driver.findElement(By.cssSelector("input[formcontrolname = \"password\"]")).sendKeys(password);
    }

    @Then("I click on LOGIN button")
    public void iClickOnLOGINButton() {
        driver.findElement(By.cssSelector("//span[text()=\"LOGIN\"]")).click();
    }

    @And("I should be logged in and see the Dashboard")
    public void iShouldBeLoggedInAndSeeTheDashboard(String expected, String actual) {
        actual = driver.findElement(By.xpath("//span[text()=\"Dashboard\"]")).getText();
        expected = "Dashboard";
        Assert.assertEquals(expected,actual);
    }


    @Given("I enter invalid <username> and <password>")
    public void iEnterInvalidUsernameAndPassword(String username, String password) {
        driver.findElement(By.cssSelector("input[formcontrolname = \"username\"]")).sendKeys(username);
        driver.findElement(By.cssSelector("input[formcontrolname = \"password\"]")).sendKeys(password);
    }

    @Then("I should see the Error Message")
    public void iShouldSeeTheErrorMessage(String actual, String expected) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
         actual = driver.findElement(By.id("toast-container")).getText();
        expected = "Invalid username or password";

        Assert.assertEquals(expected,actual);
    }
}
