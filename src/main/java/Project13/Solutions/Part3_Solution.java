package Project13.Solutions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Part3_Solution {
    public static void main(String[] args) {

        //The chromedriver.exe file is for Windows OS, and for the Chrome version 87.0.4280.88
        System.setProperty("webdriver.chrome.driver", "resources/webdrivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        1) Navigate to https://www.snapdeal.com/
        driver.get("https://www.snapdeal.com/");

//        2) Maximize the window
        driver.manage().window().maximize();

//        3) Search for "teddy bear" and click on search button
        WebElement inputValEnter = driver.findElement(By.id("inputValEnter"));
        inputValEnter.sendKeys("teddy bear");

        WebElement searchButton = driver.findElement(By.className("searchformButton"));
        searchButton.click();

//        4) Get and print the following text -->> We've got .... results for 'teddy bear'
        WebElement searchResultText = driver.findElement(By.cssSelector("#searchMessageContainer > div > span"));
        System.out.println(searchResultText.getText());

//        5) Print the URL
        System.out.println(driver.getCurrentUrl());

//        6) Click on logo snepdeal logo
        WebElement logo = driver.findElement(By.cssSelector("img.notIeLogoHeader"));
        logo.click();

//        7) Print the URL
        System.out.println(driver.getCurrentUrl());

//        8) Navigate back and check if the automatically written text in the search bar is "teddy bear"
//        (Hint: You may use the "value" attribute of the input tag for the search bar)
        driver.navigate().back();
        String str = driver.findElement(By.id("inputValEnter")).getAttribute("value");
        System.out.println(str.equals("teddy bear"));
    }
}
