package main.Project17;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ReusableMethods {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    @Parameters("browser")
    @BeforeClass()
    public void setUp(@Optional("firefox") String browserName) {

        switch (browserName) {

            default:
                System.setProperty("webdriver.chrome.driver", "/Users/MN/Desktop/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "/Users/MN/Desktop/geckodriver");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "/Users/MN/Desktop/msedgedriver");
                driver = new EdgeDriver();
                break;

        }

        js = ((JavascriptExecutor) driver);
        wait = new WebDriverWait(driver, 10);


        driver.get("https://test.campus.techno.study/");
    }

    public ReusableMethods(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
        this.driver = driver;
        this.wait = wait;
        this.js = js;
    }

    public void clickFunction(WebElement element){

        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
    public void scrollToElement(WebElement element){

        js.executeScript("arguments[0].click();", element);
    }
    public void sendKeyFunction(WebElement element, String text){

        //scrollToElement(element);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);

    }
    public void Waiter(int sec){
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitPresenceOfElementLocated(By Locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(Locator));
    }

    public void waitUntilAllElementsVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }
}
