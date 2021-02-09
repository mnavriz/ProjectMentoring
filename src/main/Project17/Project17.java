package main.Project17;



import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Project17 {
    ReusableMethods rm;
    POM pom;
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;


    //  Note: Use TestNG for your tests
/*
   Create a TestNG.xml file and add your class to it.
*/

/*
   Setup for your test cases: (Use @BeforeClass method for setup)
   Open a browser and navigate to https://test.campus.techno.study/
   Dismiss the cookie message by clicking on "Got it!" button
   Login by the credentials (username = "daulet2030@gmail.com" and password = "TechnoStudy123@")
   Navigate to Student > Students through the left menu
   Click on + icon for adding a student
   Select "Representatives" from the bottom tabs
   Click on + icon to add a new representative
*/
   // @Parameters("browser")
    /*@BeforeClass*/
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
        rm = new ReusableMethods(driver, wait, js);
        //pom = new POM(driver, wait, js);


        driver.get("https://test.campus.techno.study/");

        pom.findElementAndClickFunction("dismissCookieButton");

        pom.findElementAndSendKeyFunction("UsernameInput", "daulet2030@gmail.com");

        pom.findElementAndSendKeyFunction("PasswordInput", "TechnoStudy123@");

        pom.findElementAndClickFunction("LoginButton");

        pom.findElementAndClickFunction("StudentButton");

        pom.findElementAndClickFunction("StudentsButton");

        pom.findElementAndClickFunction("addButton");

        rm.waitPresenceOfElementLocated(pom.representativeButton);
        WebElement Representative = driver.findElement(pom.representativeButton);


        js.executeScript("arguments[0].scrollIntoView(true);", Representative);

        rm.waitPresenceOfElementLocated(pom.representativeButton);
        driver.findElement(pom.representativeButton).click();

    }

/*
   Verify that you can add a new representative of Father, Mother, Guardian and Self
   Write only one test case for verification of creation of representatives
   Use a single Data Provider in order to use the same test case for creation of each type of representative.
 */
    /*
  Verify you can delete an existing representative.
  (Optional: Use only one test case to delete the four representative you have created about.
    You may use data provider or run your test many times.)
  (For automated testing/verification, deleting one representative will be enough but
   please do not forget to delete other representative you have created above, at least manually)
*/
        @DataProvider(name = "RepresentativeData")
        public Object[][] RepresentativeData () {
            Object[][] data =
                    {
                            {pom.repMotherOption, "Fatma", "kasa", "+7(123) 456-7890", pom.countryKAZOption}
                            // {repFatherOption, "Ali", "kassa", "+7(123) 456-7891", countryUSAOption},
                            // {repGuardianOption, "Veli", "tata", "+7(123) 456-7892", countryRUSOption},
                            // {repSelfOption, "BEN", "tataTU", "+7(123) 456-7893", countryUKROption}
                    };

            return data;
        }

        @Test(dataProvider = "RepresentativeData", groups = {"smoke"})
        public void AddANDDeleteRepresentative (WebElement repWebElement, String FirstName, String LastName, String
        MobilePhone, WebElement CountryWebElement){


            pom.findElementAndClickFunction("plusButton");

            pom.findElementAndClickFunction("repFormButton");
            repWebElement.click();

            String strRepWebElement = repWebElement.getText();

            pom.findElementAndSendKeyFunction("FirstNameInput", FirstName);

            pom.findElementAndSendKeyFunction("LastNameInput", LastName);

            pom.findElementAndSendKeyFunction("phoneInput", MobilePhone);

            pom.findElementAndClickFunction("countryFormButton");

            CountryWebElement.click();


            pom.findElementAndClickFunction("addFormButton");

            rm.Waiter(3000);

            String expected = FirstName + " " + LastName + " " + strRepWebElement + " " + MobilePhone;

            List<String> result = new ArrayList<>();

            for (WebElement element : pom.studentRelativeTable) {
                js.executeScript("arguments[0].scrollIntoView(true);", element);
                result.add(element.getText());
            }


            Assert.assertTrue(result.contains(expected));

            boolean isRepDeleted = false;

            pom.findElementAndClickFunction("TrashButton");
            pom.findElementAndClickFunction("YesButton");

            result.remove(0);

            rm.Waiter(3000);
            // wait.until(ExpectedConditions.visibilityOfAllElements(studentRelativeTable));
            for (WebElement element : pom.studentRelativeTable) {
                js.executeScript("arguments[0].scrollIntoView(true);", element);
                result.add(element.getText());
                System.out.println(element.getText());
            }
            Assert.assertTrue(result.contains("No data to show"));
        }

/*
   Verify that a representative cannot be created (or add button will not be active)
   if one of the following data is missing: Representative, First Name, Last Name, Mobile Phone or Country
   Write a single test case and use a single data provider to test each case with a missing information each time
*/
        @DataProvider(name = "MissingRepData")
        public Object[][] MissingRepData () {
            Object[][] data =
                    {
                            {pom.repMotherOption, "", "kasa", "+7(123) 456-7890", pom.countryKAZOption},
                            {pom.repFatherOption, "Ali", "", "+7(123) 456-7891", pom.countryUSAOption},
                            {pom.repGuardianOption, "Veli", "tata", "", pom.countryRUSOption},

                    };

            return data;
        }
        @Test(dataProvider = "MissingRepData", groups = "functional")
        public void VerifyRepCannotBEAddedWithMissingInfo (WebElement repWebElement, String FirstName, String
        LastName, String MobilePhone, WebElement CountryWebElement){


            pom.findElementAndClickFunction("plusButton");

            pom.findElementAndClickFunction("repFormButton");
            repWebElement.click();

            String strRepWebElement = repWebElement.getText();

            pom.findElementAndSendKeyFunction("FirstNameInput", FirstName);

            pom.findElementAndSendKeyFunction("LastNameInput", LastName);

            pom.findElementAndSendKeyFunction("phoneInput", MobilePhone);

            pom.findElementAndClickFunction("countryFormButton");

            CountryWebElement.click();


            boolean isButtonClickable = true;

            try {
                pom.findElementAndClickFunction("addFormButton");
            } catch (ElementClickInterceptedException e) {
                isButtonClickable = false;
                pom.findElementAndClickFunction("CloseButton");
            }

            Assert.assertFalse(isButtonClickable);

        }

/*
   (The following tests must fail. Because you are not supposed to create a representative as stated but in fact you can!)
   Verify that you cannot create a representative (add button should not be active) with the following data:
      with a First Name like "*#@%/"
      with a Last Name like "125436"
      with a Mobile Phone like "abcdef"
   Write a single test case for this test and pass parameters from TestNG.xml file to test the three cases.
*/
        @DataProvider(name = "WrongInputRepData")
        public Object[][] WrongInputRepData () {
            Object[][] data =
                    {
                            {pom.repMotherOption, "*#@%/", "kasa", "+7(123) 456-7890", pom.countryKAZOption},
                            {pom.repFatherOption, "Ali", "125436", "+7(123) 456-7891", pom.countryUSAOption},
                            {pom.repGuardianOption, "Veli", "tata", "abcdef", pom.countryRUSOption},
                            {pom.repSelfOption, "...", "---", "---", pom.countryUKROption}
                    };

            return data;
        }
        @Parameters
        @Test(dataProvider = "WrongInputRepData", groups = "regression")
        public void VerifyRepCannotBeAddedWithWrongInputFormat (WebElement repWebElement, String FirstName, String
        LastName, String MobilePhone, WebElement CountryWebElement){


            pom.findElementAndClickFunction("plusButton");

            pom.findElementAndClickFunction("repFormButton");
            repWebElement.click();

            String strRepWebElement = repWebElement.getText();

            pom.findElementAndSendKeyFunction("FirstNameInput", FirstName);

            pom.findElementAndSendKeyFunction("LastNameInput", LastName);

            pom.findElementAndSendKeyFunction("phoneInput", MobilePhone);

            pom.findElementAndClickFunction("countryFormButton");

            CountryWebElement.click();


            boolean isButtonClickable = true;

            try {
                pom.findElementAndClickFunction("addFormButton");
            } catch (ElementClickInterceptedException e) {
                isButtonClickable = false;
                pom.findElementAndClickFunction("CloseButton");
            }

            Assert.assertFalse(isButtonClickable);


        }

/*
    Create a folder called "screenshot" (suggestively in the project package, not somewhere else in your computer.)
    Create an @AfterMethod to take a screenshot when the test fails.
    Save the screenshots in the folder called "screenshots"
*/
   /* @AfterMethod
    public void takeScreenshotWhenTestFails(ITestResult result){

        if (result.getStatus() == ITestResult.FAILURE){

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
            String time = LocalDateTime.now().format(formatter);

            File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String folderPath = "/Users/MN/Desktop/TechnoStudy/SaturdayProjects/MySaturdayProjects/src/Batch3SaturdayProjects/src/main/Project17/screenshot";
            String fileName = result.getMethod().getMethodName()+"_"+time+".png";

            File destinationFile = new File(folderPath+fileName);


            try {
                FileUtils.copyFile(sourceFile,destinationFile);
            }catch (IOException e){
                e.printStackTrace();
            }
        }


    }*/

        @AfterClass
        public void closeBrowser () {
            driver.quit();
        }

/*
    Create @AfterClass to close the browser




    Add a listener to your xml file for getting well-prepared, good-looking and e-mailable test reports (like html reports)
*/

/*
    OPTIONAL: Run your project in parallel (say, running three tests at a time)
      It is strongly suggested that before trying parallel execution, make sure they run perfectly one after other.
*/

/*
    CHALLENGE: Without writing any more test cases (you may have to change your code a little bit),
     run your test in two other browsers (say, Firefox and Edge, or else)
     Before trying challenge part, make sure your test cases work perfectly with one browser.
*/

}

