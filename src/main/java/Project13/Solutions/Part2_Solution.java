package Project13.Solutions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part2_Solution {
    public static void main(String[] args) {

        //The chromedriver.exe file is for Windows OS, and for the Chrome version 87.0.4280.88
        System.setProperty("webdriver.chrome.driver", "resources/webdrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        1) Navigate to https://demo.applitools.com/
        driver.get("https://demo.applitools.com/");

//        2) Maximize the window
        driver.manage().window().maximize();

//        3) Enter the username as "ttechno@gmail.com"
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("ttechno@gmail.com");

//        4) Enter the password as "techno123."
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("techno123.");

//        5) Click on sign in button
        WebElement button = driver.findElement(By.id("log-in"));
        button.click();

//        6) Get the header text in red color ( starts with "Your nearest branch ...") and assign it to a String str
        WebElement header = driver.findElement(By.id("time"));
        String str = header.getText();

//        7) Print the String str
        System.out.println(str);

//        8) Print the URL
        System.out.println(driver.getCurrentUrl());
    }
}
