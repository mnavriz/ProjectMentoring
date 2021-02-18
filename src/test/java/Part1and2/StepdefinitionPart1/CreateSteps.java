package Part1and2.StepdefinitionPart1;

import Part1and2.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CreateSteps extends Base {


    @Given("Open the webpage")
    public void openTheWebpage() {
        driver.get("http://thedemosite.co.uk/");
    }

    @Given("navigate to adduser page by clicking 3.Add a User link")
    public void navigateToAdduserPageByClickingLink() {
        driver.findElement(By.xpath("//a[text()=\"3. Add a User\"]")).click();
    }

    @When("Enter {string} and {string} and click on save button")
    public void enterAndAndClickOnSaveButton(String username, String password) {
        driver.findElement(By.cssSelector("input[name=\"username\"]")).sendKeys(username);
        driver.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys(password);
        driver.findElement(By.cssSelector("input[type=\"button\"]")).click();
    }


    @And("click ok on alert AND check the {string}.")
    public void clickOkOnAlertANDCheckThe(String result) {
        String Alertext="";

        try {
            Alertext = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
        }  catch(Exception e){
            e.getMessage();
            System.out.println(e);
        }

        Assert.assertEquals(result,Alertext);
    }
}

