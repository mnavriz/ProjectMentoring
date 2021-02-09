package Project13.Solutions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part1_Solution {
    public static void main(String[] args) {
        //The chromedriver.exe file is for Windows OS, and for the Chrome version 87.0.4280.88
        System.setProperty("webdriver.chrome.driver", "resources/webdrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        1) Navigate to  http://demoqa.com/text-box
        driver.get("http://demoqa.com/text-box");

//        2) Maximize the window
        driver.manage().window().maximize();

//        3) Enter full name as "Automation"
        WebElement userName = driver.findElement(By.id("userName"));
        userName.sendKeys("Automation");

//        4) Enter Email as "Testing@gmail.com"
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys("Testing@gmail.com");

//        5) Enter Current Address as "Testing Current Address"
        WebElement currentAddress = driver.findElement(By.cssSelector("textarea#currentAddress"));
        currentAddress.sendKeys("Testing Current Address");

//        6) Enter Permanent Address as "Testing Permanent Address"
        WebElement permanentAddress = driver.findElement(By.cssSelector("textarea#permanentAddress"));
        permanentAddress.sendKeys("Testing Permanent Address");

//        7) Click on submit button
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

//        8) Print Name in the text box
        WebElement nameText = driver.findElement(By.id("name"));
        System.out.println(nameText.getText().substring(5));

//        9) Print Email in the text box
        WebElement emailText = driver.findElement(By.id("email"));
        System.out.println(emailText.getText().substring(6));

//        10) Print Current Address in the text box
        WebElement currentAddressText = driver.findElement(By.cssSelector("p#currentAddress"));
        System.out.println(currentAddressText.getText().substring(17));

//        11) Print Permanent Address in the text box
        WebElement permanentAddressText = driver.findElement(By.cssSelector("p#permanentAddress"));
        System.out.println(permanentAddressText.getText().substring(20));
    }
}
