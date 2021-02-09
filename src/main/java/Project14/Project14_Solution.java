package Project14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Project14_Solution {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        String username = "name_surname@fakemail.com";
        String password = "TechnoStudy";

//        Navigate to http://a.testaddressbook.com/sign_in
        driver.get("http://a.testaddressbook.com/sign_in");

//        Enter the username and password
        driver.findElement(By.id("session_email")).sendKeys(username);
        driver.findElement(By.id("session_password")).sendKeys(password);

//        Click on sign in button
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();

//        Click on Addresses
        driver.findElement(By.cssSelector("a[href='/addresses']")).click();

//        Click on new address button
        driver.findElement(By.cssSelector("a[href='/addresses/new']")).click();

//        Enter the first name "Fernando"
        driver.findElement(By.id("address_first_name")).sendKeys("Fernando");

//        Enter the last name  "Torres"
        driver.findElement(By.id("address_last_name")).sendKeys("Torres");

//        Enter the address 1 "Anfield Rd"
        driver.findElement(By.id("address_street_address")).sendKeys("Anfield Rd");

//        Enter the address 2 "Anfield"
        driver.findElement(By.id("address_secondary_address")).sendKeys("Anfield");

//        Enter the city "Liverpool"
        driver.findElement(By.id("address_city")).sendKeys("Liverpool");

//        Choose a RANDOM option from the state dropdown
        Select states = new Select(driver.findElement(By.id("address_state")));
        states.selectByIndex(new Random().nextInt(52));

//        Enter the Zipcode "L4 0TH"
        driver.findElement(By.id("address_zip_code")).sendKeys("L4 0TH");

//        Click on United States
        driver.findElement(By.id("address_country_us")).click();

//        Enter the birthday "03/20/1984"
        driver.findElement(By.id("address_birthday")).sendKeys("03/20/1984");

//        Enter the age "36"
        driver.findElement(By.id("address_age")).sendKeys("36");

//        Enter the WebSite "https://www.google.com/"
        driver.findElement(By.id("address_website")).sendKeys("https://www.google.com/");

//        Enter the phone "8625747878"
        driver.findElement(By.id("address_phone")).sendKeys("8625747878");

//        Click on Climbing and Dancing
        driver.findElement(By.id("address_interest_climb")).click();
        driver.findElement(By.id("address_interest_dance")).click();

//        Enter the Note "Never Back Down"
        driver.findElement(By.id("address_note")).sendKeys("Never Back Down");

//        Click on Create Address button
        driver.findElement(By.cssSelector("input[value='Create Address']")).click();

//        Verify the first name as "Fernando"
        String firstName = driver.findElement(By.cssSelector("span[data-test='first_name']")).getText();
        if (firstName.equals("Fernando")) {
            System.out.println("First name verified: " + firstName);
        } else {
            System.out.println("First name was NOT verified: " + firstName);
        }

//        Verify the last name as "Torres"
        String lastName = driver.findElement(By.cssSelector("span[data-test='last_name']")).getText();
        if (lastName.equals("Torres")) {
            System.out.println("First name verified: " + lastName);
        } else {
            System.out.println("First name was NOT verified: " + lastName);
        }

//        Click on Addresses
        driver.findElement(By.cssSelector("a[href='/addresses']")).click();

//        Click on Edit button
        driver.findElement(By.cssSelector("table>tbody>tr:first-child>td:nth-child(6)>a")).click();

//        Change the first name as "Peter"
        driver.findElement(By.id("address_first_name")).sendKeys("Peter");

//        Change the last name as "Crouch"
        driver.findElement(By.id("address_last_name")).sendKeys("Crouch");

//        Click on Update address
        driver.findElement(By.cssSelector("input[value='Update Address']")).click();

//        Verify the first name as "Peter"
        if (firstName.equals("Peter")) {
            System.out.println("First name updated: " + firstName);
        } else {
            System.out.println("First name was NOT updated: " + firstName);
        }

//        Verify the last name as "Crouch"
        if (lastName.equals("Torres")) {
            System.out.println("First name updated: " + lastName);
        } else {
            System.out.println("First name was NOT updated: " + lastName);
        }

//        Click on Addresses
        driver.findElement(By.cssSelector("a[href='/addresses']")).click();

//        Click on Destroy
        driver.findElement(By.cssSelector("table>tbody>tr:first-child>td:nth-child(7)>a")).click();

//        Confirm deleting the address
        driver.switchTo().alert().accept();

//        Address should be removed
        if (driver.findElement(By.cssSelector("div[data-test='notice']")).isDisplayed()) {
            String addressDeleteNotice = driver.findElement(By.cssSelector("div[data-test='notice']")).getText();
            System.out.println(addressDeleteNotice);
        } else {
            System.out.println("An error occurred while deleting the address!");
        }

//        Close the browser
        driver.close();
    }
}
