package Part1and2.StepdefinitionPart1;

import Part1and2.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSteps extends Base {

    String StatusMessage="";

    @Given("Open the webpage http:\\/\\/thedemosite.co.uk\\/")
    public void openTheWebpageHttpThedemositeCoUk() {
        driver.get("http://thedemosite.co.uk/");
    }

    @Given("navigate to adduser page")
    public void navigateToAdduserPageByClickingLink() {
       driver.findElement(By.xpath("//a[text()='4. Login']")).click();
    }

    @When("When Enter {string} and {string} and click on Test Login button")
    public void whenEnterAndAndClickOnTestLoginButton(String username, String password) {
        driver.findElement(By.cssSelector("input[name=\"username\"]")).sendKeys(username);
        driver.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value=\"Test Login\"]")).click();

    }


    @Then("Get the status {string}")
    public void getTheStatus(String statusMessage) {
        try {
            StatusMessage=driver.findElement(By.cssSelector("center>b")).getText();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        Assert.assertEquals(StatusMessage,StatusMessage);
    }

    @When("When Enter <username> and <password> and click on Test Login button")
    public void whenEnterUsernameAndPasswordAndClickOnTestLoginButton(String username, String password) {
        driver.findElement(By.cssSelector("input[name=\"username\"]")).sendKeys(username);
        driver.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value=\"Test Login\"]")).click();
    }

}
