package Project16;

import org.junit.Assert;
import org.junit.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;


import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

public class Project16 {

//  Note-1: Use TestNG for your tests
//  Note-2: Do not forget to delete whatever you have created manually if needed in order to keep the data clean for other testers please.


//  Setup for your test cases:

    ReusableMethods rs = new ReusableMethods();
    WebDriver driver;
    WebDriverWait wait;

@BeforeMethod
public void Setup() {
    System.setProperty("webdriver.chrome.driver","/Users/MN/Desktop/chromedriver");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver,7);
    driver.get("https://test.campus.techno.study/");

    //  Dismiss the cookie message by clicking on "Got it!" button
    //wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("a[aria-label=\"dismiss cookie message\"]"))));
    driver.findElement(By.cssSelector("a[aria-label=\"dismiss cookie message\"]")).click();

    //  Login by the credentials (username = "daulet2030@gmail.com" and password = "TechnoStudy123@")
    driver.findElement(By.cssSelector("[data-placeholder=\"Username\"]")).sendKeys("daulet2030@gmail.com");
    driver.findElement(By.cssSelector("[data-placeholder=\"Password\"]")).sendKeys("TechnoStudy123@");
    driver.findElement(By.cssSelector("[aria-label=\"LOGIN\"]")).click();

    //  Navigate to HumanResources > Employees through the left menu
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Human Resources']")));
    driver.findElement(By.xpath("//span[text()='Human Resources']")).click();

    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Employees']")));
    driver.findElement(By.xpath("//span[text()='Employees']")).click();



}




//  Test 1: Verify that an employee can be created with a minimum (First Name, Last Name, Employee ID, Document Type and Document Number) data --> (passes)
    @Test(priority = 1)
    public void CreateMinimumEmployee(){
    wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("ms-add-button"))));
    driver.findElement(By.cssSelector("ms-add-button")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='firstName']>input")));
    driver.findElement(By.cssSelector("[formcontrolname='firstName']>input")).sendKeys("Mustafa");
    driver.findElement(By.cssSelector("[formcontrolname='lastName']>input")).sendKeys("Navriz");
    driver.findElement(By.cssSelector("[data-placeholder='Employee ID']")).sendKeys("1234567890");


        //wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("div[role='listbox']>mat-option:nth-child(1)"))));
        WebElement DT = driver.findElement((By.cssSelector("[formcontrolname='documentNumber']")));
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", DT);

        DT.sendKeys("987654321");

    driver.findElement(By.xpath("//span[text()='Document Type']")).click();

        List<WebElement> document = driver.findElements(By.xpath("//span[@class='mat-option-text']"));

        for (WebElement element : document){
            if(element.getText().equals("Personal ID")){
                element.click();
            }
        }
    driver.findElement(By.xpath("//span[text()='Save']")).click();

        String SuccessMessage = driver.findElement(By.id("toast-container")).getText();
        Assert.assertEquals("Employee successfully created", SuccessMessage);

    }
//  Test 2: Verify that an existing employee can be deleted
    @Test(priority = 14)
    public void DeleteExistingEmployee(){

        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("[placeholder='GENERAL.FIELD.FIRST_NAME']>input"))));
        driver.findElement(By.cssSelector("[placeholder='GENERAL.FIELD.FIRST_NAME']>input")).sendKeys("Afatsum");
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".mat-select-trigger ng-tns-c215-47")));
        driver.findElement(By.xpath("//span[text()='Active']")).click();
        driver.findElement(By.xpath("//span[text()='All']")).click();

        wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("tbody>tr>td:nth-child(7)>div:nth-child(1)>ms-delete-button>button"))));
        driver.findElement(By.cssSelector("tbody>tr>td:nth-child(7)>div:nth-child(1)>ms-delete-button>button")).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".mat-focus-indicator mat-button mat-raised-button mat-button-base mat-accent"))));
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("toast-container"))));
        String SuccessfullyDeleted = driver.findElement(By.id("toast-container")).getText();
        Assert.assertEquals("Employee successfully deleted",SuccessfullyDeleted);

}


//  Test 3: Verify that the first name of an existing employee can be updated --> (passes)
    @Test(priority = 2)
    public void UpdateEmployeeFirstName(){

        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("[placeholder='GENERAL.FIELD.FIRST_NAME']>input"))));
        driver.findElement(By.cssSelector("[placeholder='GENERAL.FIELD.FIRST_NAME']>input")).sendKeys("Mustafa");
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".mat-select-trigger ng-tns-c215-47")));
        driver.findElement(By.xpath("//span[text()='Active']")).click();
        driver.findElement(By.xpath("//span[text()='All']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("tbody>tr>td:nth-child(7)>div:nth-child(1)>ms-edit-button>button"))));
        driver.findElement(By.cssSelector("tbody>tr>td:nth-child(7)>div:nth-child(1)>ms-edit-button>button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='firstName']>input")));
        driver.findElement(By.cssSelector("[formcontrolname='firstName']>input")).clear();
        driver.findElement(By.cssSelector("[formcontrolname='firstName']>input")).sendKeys("Afatsum");
        driver.findElement(By.xpath("//span[text()='Save']")).click();

        rs.Waiter(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("toast-container"))));
        String EditSuccessMessage = driver.findElement(By.id("toast-container")).getText();
        Assert.assertEquals("Employee successfully edited",EditSuccessMessage);


    }
//  Test 4: Verify that the last name of an existing employee can be updated --> (passes)
    @Test(priority = 3)
    public void UpdateEmployeeLastName() {
        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("[placeholder='GENERAL.FIELD.FIRST_NAME']>input"))));
        driver.findElement(By.cssSelector("[placeholder='GENERAL.FIELD.FIRST_NAME']>input")).sendKeys("Afatsum");
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".mat-select-trigger ng-tns-c215-47")));
        driver.findElement(By.xpath("//span[text()='Active']")).click();
        driver.findElement(By.xpath("//span[text()='All']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("tbody>tr>td:nth-child(7)>div:nth-child(1)>ms-edit-button>button"))));
        driver.findElement(By.cssSelector("tbody>tr>td:nth-child(7)>div:nth-child(1)>ms-edit-button>button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='lastName']>input")));
        driver.findElement(By.cssSelector("[formcontrolname='lastName']>input")).clear();
        driver.findElement(By.cssSelector("[formcontrolname='lastName']>input")).sendKeys("Zirvan");
        driver.findElement(By.xpath("//span[text()='Save']")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("toast-container"))));
        String EditSuccessMessage = driver.findElement(By.id("toast-container")).getText();
        Assert.assertEquals("Employee successfully updated", EditSuccessMessage);
    }
//  Test 5: Verify that the document number of an existing employee can be updated --> (passes)

    @Test(priority = 4)
    public void UpdateDocumentNumber(){
        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("[placeholder='GENERAL.FIELD.FIRST_NAME']>input"))));
        driver.findElement(By.cssSelector("[placeholder='GENERAL.FIELD.FIRST_NAME']>input")).sendKeys("Afatsum");
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".mat-select-trigger ng-tns-c215-47")));
        driver.findElement(By.xpath("//span[text()='Active']")).click();
        driver.findElement(By.xpath("//span[text()='All']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("tbody>tr>td:nth-child(7)>div:nth-child(1)>ms-edit-button>button"))));
        driver.findElement(By.cssSelector("tbody>tr>td:nth-child(7)>div:nth-child(1)>ms-edit-button>button")).click();

        rs.Waiter(1000);
        //wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("[formcontrolname='documentNumber']"))));
        WebElement DocumentArea = driver.findElement((By.cssSelector("[formcontrolname='documentNumber']")));
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", DocumentArea);

        DocumentArea.clear();
        DocumentArea.sendKeys("3142");
        driver.findElement(By.xpath("//span[text()='Save']")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        wait.until(ExpectedConditions.presenceOfElementLocated((By.id("toast-container"))));
        String EditSuccessMessage = driver.findElement(By.id("toast-container")).getText();
        Assert.assertEquals("Employee successfully updated", EditSuccessMessage);

    }

//  Test 6: Verify that (any other data you decided) of an existing employee can be updated --> (passes)
    @Test(priority = 5)
    public void AnyOtherData(){

        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("[placeholder='GENERAL.FIELD.FIRST_NAME']>input"))));
        driver.findElement(By.cssSelector("[placeholder='GENERAL.FIELD.FIRST_NAME']>input")).sendKeys("Afatsum");
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".mat-select-trigger ng-tns-c215-47")));
        driver.findElement(By.xpath("//span[text()='Active']")).click();
        driver.findElement(By.xpath("//span[text()='All']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("tbody>tr>td:nth-child(7)>div:nth-child(1)>ms-edit-button>button"))));
        driver.findElement(By.cssSelector("tbody>tr>td:nth-child(7)>div:nth-child(1)>ms-edit-button>button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("[formcontrolname='middleName']>input"))));
        driver.findElement(By.cssSelector("[formcontrolname='middleName']>input")).sendKeys("msm");

        driver.findElement(By.xpath("//span[text()='Save']")).click();

        String SuccessMessage = driver.findElement(By.id("toast-container")).getText();
        Assert.assertEquals("Employee successfully updated", SuccessMessage);



    }

//  Test 7: Verify that an employee with different names but the same Employee ID cannot be created --> (fails!)
    @Test(priority = 6)
    public void SameEmployeeID(){
        wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("ms-add-button"))));
        driver.findElement(By.cssSelector("ms-add-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='firstName']>input")));
        driver.findElement(By.cssSelector("[formcontrolname='firstName']>input")).sendKeys("Afatsum");
        driver.findElement(By.cssSelector("[formcontrolname='lastName']>input")).sendKeys("Zirvan");
        driver.findElement(By.cssSelector("[data-placeholder='Employee ID']")).sendKeys("1234567890");

        WebElement DT = driver.findElement((By.cssSelector("[formcontrolname='documentNumber']")));
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", DT);

        DT.sendKeys("123");

        driver.findElement(By.xpath("//span[text()='Document Type']")).click();

        List<WebElement> document = driver.findElements(By.xpath("//span[@class='mat-option-text']"));

        for (WebElement element : document){
            if(element.getText().equals("Personal ID")){
                element.click();
            }
        }
        driver.findElement(By.xpath("//span[text()='Save']")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("toast-container"))));
        String Message = driver.findElement(By.id("toast-container")).getText();
       // System.out.println(Message);
        Assert.assertEquals("Error!\n" +
                "Afatsum Zirvan already has such Employee ID", Message);

    }
//  Test 8: Verify that an employee with different names but the same Document Number cannot be created --> (passes)
    @Test(priority = 7)
    public void SameDocumentNumber(){
        wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("ms-add-button"))));
        driver.findElement(By.cssSelector("ms-add-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='firstName']>input")));
        driver.findElement(By.cssSelector("[formcontrolname='firstName']>input")).sendKeys("Iwas");
        driver.findElement(By.cssSelector("[formcontrolname='lastName']>input")).sendKeys("Müller");
        driver.findElement(By.cssSelector("[data-placeholder='Employee ID']")).sendKeys("1233444");

        WebElement DT = driver.findElement((By.cssSelector("[formcontrolname='documentNumber']")));
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", DT);

        DT.sendKeys("123");

        driver.findElement(By.xpath("//span[text()='Document Type']")).click();

        List<WebElement> document = driver.findElements(By.xpath("//span[@class='mat-option-text']"));

        for (WebElement element : document){
            if(element.getText().equals("Personal ID")){
                element.click();
            }
        }
        driver.findElement(By.xpath("//span[text()='Save']")).click();

        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("toast-container"))));
        String Message = driver.findElement(By.id("toast-container")).getText();
        System.out.println(Message);

        Assert.assertEquals("×\n" +
                "Error!\n" +
                "Afatsum Zirvan already has such document number or PIN", Message);


    }
//  Test 9: Verify that an employee with the same First Name and Last Name can be created --> (passes)
    @Test(priority = 8)
    public void SameFirstNameAndLastName(){
        wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("ms-add-button"))));
        driver.findElement(By.cssSelector("ms-add-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='firstName']>input")));
        driver.findElement(By.cssSelector("[formcontrolname='firstName']>input")).sendKeys("Afatsum");
        driver.findElement(By.cssSelector("[formcontrolname='lastName']>input")).sendKeys("Zirvan");
        driver.findElement(By.cssSelector("[data-placeholder='Employee ID']")).sendKeys("88888888");


        //wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("div[role='listbox']>mat-option:nth-child(1)"))));
        WebElement DT = driver.findElement((By.cssSelector("[formcontrolname='documentNumber']")));
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", DT);

        DT.sendKeys("999999999");

        driver.findElement(By.xpath("//span[text()='Document Type']")).click();

        List<WebElement> document = driver.findElements(By.xpath("//span[@class='mat-option-text']"));

        for (WebElement element : document){
            if(element.getText().equals("Personal ID")){
                element.click();
            }
        }
        driver.findElement(By.xpath("//span[text()='Save']")).click();

        String SuccessMessage = driver.findElement(By.id("toast-container")).getText();
        Assert.assertEquals("Employee successfully created", SuccessMessage);
    }

//  Use a data provider to do the Tests 10-15
    @DataProvider(name = "EmployeeData")
    public Object [][] EmployeeData(){
    Object [][] data =
     {
             {"","Smith","09127","323127","id","No Name"},
             {"Jhon","","0916","121216","passport", "No Lastname"},
             {"Tim","Carter","","35516","birth certificate", "No Employee ID"},
             {"232","tata","0716","252516","passport", "Name with numbers"},
             {"*#@$","World","0616","3316","id", "Name with characters"}

    };

    return data;
    }

//  Test 10: Verify that an employee without entering a first name cannot be created --> (passes)
//  Test 11: Verify that an employee without entering a last name cannot be created --> (passes)
//  Test 12: Verify that an employee without entering an Employee ID cannot be created --> (passes)
//  Test 13: Verify that an employee cannot be created if you enter just numerical values for the First Name --> (fails!!!)
//  Test 14: Verify that an employee cannot be created if you enter just special characters like @,!,#, ,%,^ for the name --> (fails!!!)
//  Test 15: Add your own test data for the data provider for a negative testing of creating an employee (feel free to add more than one case)

    @Test(dataProvider = "EmployeeData", priority = 9)
    public void CreatingEmployeeWithDataProvider(String FirstName,String Lastname, String EmployeeID,String DocumentID,String DocumentType, String TestCase){
        wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("ms-add-button"))));
        driver.findElement(By.cssSelector("ms-add-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='firstName']>input")));
        driver.findElement(By.cssSelector("[formcontrolname='firstName']>input")).sendKeys(FirstName);
        driver.findElement(By.cssSelector("[formcontrolname='lastName']>input")).sendKeys(Lastname);
        driver.findElement(By.cssSelector("[data-placeholder='Employee ID']")).sendKeys(EmployeeID);


        //wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("div[role='listbox']>mat-option:nth-child(1)"))));
        WebElement DT = driver.findElement((By.cssSelector("[formcontrolname='documentNumber']")));
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", DT);

        DT.sendKeys(DocumentID);

        driver.findElement(By.xpath("//span[text()='Document Type']")).click();

        List<WebElement> document = driver.findElements(By.xpath("//span[@class='mat-option-text']"));

        for (WebElement element : document){
            if(element.getText().toLowerCase().contains(DocumentType)){
                wait.until(ExpectedConditions.visibilityOf(element));
                element.click();
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[text()='Save']"))));
        driver.findElement(By.xpath("//span[text()='Save']")).click();

        rs.Waiter(500);

        WebElement element =  driver.findElement(By.id("toast-container"));
        wait.until(ExpectedConditions.visibilityOf(element));
        String Message = element.getText();
       // Assert.assertEquals("Employee successfully created", SuccessMessage);
        System.out.println(Message);
        SoftAssert softAssert = new SoftAssert();

        switch (TestCase){

            case "No Name":
                softAssert.assertEquals("×\n"+"Error!\n" +"Invalid Employee Info!",Message,"Test without First Name");
                softAssert.assertAll();
                break;
            case "No Lastname":
                softAssert.assertEquals("×\n"+"Error!\n" +"Invalid Employee Info!",Message,"Test without Last Name");
                softAssert.assertAll();
                break;
            case "No Employee ID":
                softAssert.assertEquals("×\n"+"Error!\n" +"Invalid Employee Info!",Message,"Test without Employee ID");
                softAssert.assertAll();
                break;
            case "Name with numbers":
                softAssert.assertEquals("×\n"+"Error!\n" +"Invalid Employee Info!",Message,"Test with numerical values for First Name ");
                softAssert.assertAll();
                break;
            case "Name with characters":
                softAssert.assertEquals("×\n"+"Error!\n" +"Invalid Employee Info!",Message,"Test with special characters values for Last Name ");
                softAssert.assertAll();
                break;


        }



    }



//  Test 16: Verify that a photo can be uploaded while creating a new employee --> (fails!)
    @Test(priority = 10)
    public void PhotoUploadWhileCreating() {
        wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("ms-add-button"))));
        driver.findElement(By.cssSelector("ms-add-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname='firstName']>input")));
        driver.findElement(By.cssSelector("[formcontrolname='firstName']>input")).sendKeys("Mustafa");
        driver.findElement(By.cssSelector("[formcontrolname='lastName']>input")).sendKeys("Navriz");
        driver.findElement(By.cssSelector("[data-placeholder='Employee ID']")).sendKeys("1234567890");


        //wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("div[role='listbox']>mat-option:nth-child(1)"))));
        WebElement DT = driver.findElement((By.cssSelector("[formcontrolname='documentNumber']")));
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", DT);

        DT.sendKeys("987654321");

        driver.findElement(By.xpath("//span[text()='Document Type']")).click();

        List<WebElement> document = driver.findElements(By.xpath("//span[@class='mat-option-text']"));

        for (WebElement element : document) {
            if (element.getText().equals("Personal ID")) {
                element.click();
            }

        }

        WebElement photo = driver.findElement(By.cssSelector("[src=\"./assets/images/no-photo.jpg\"]"));

        String EMessage = null;
        try {
            photo.click();
        } catch (Exception e) {
            EMessage = e.getMessage();
        }
        //  [onclick="this.blur()"]

        //driver.findElement(By.xpath("//span[text()='Save']")).click();


        //String SuccessMessage = driver.findElement(By.id("toast-container")).getText();
        Assert.assertEquals("Photo successfully uploaded", EMessage);

    }
//  Test 17: Verify that a photo can be uploaded for an existing employee --> (passes)
    @Test(priority = 11)
    public void PhotoUploadExistingEmployee()throws AWTException{

            wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("[placeholder='GENERAL.FIELD.FIRST_NAME']>input"))));
            driver.findElement(By.cssSelector("[placeholder='GENERAL.FIELD.FIRST_NAME']>input")).sendKeys("Afatsum");
            //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".mat-select-trigger ng-tns-c215-47")));
            driver.findElement(By.xpath("//span[text()='Active']")).click();
            driver.findElement(By.xpath("//span[text()='All']")).click();

            wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("tbody>tr>td:nth-child(7)>div:nth-child(1)>ms-edit-button>button"))));
            driver.findElement(By.cssSelector("tbody>tr>td:nth-child(7)>div:nth-child(1)>ms-edit-button>button")).click();

            wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("[src=\"./assets/images/no-photo.jpg\"]"))));
            driver.findElement(By.cssSelector("[src=\"./assets/images/no-photo.jpg\"]")).click();
            driver.findElement(By.cssSelector("[data-icon='upload']")).click();

            //driver.findElement(By.xpath("*[@id=’uploadfile_0′]")).click();
            File path = new File("/Users/MN/Desktop/profilbild.png");
            StringSelection stringSelection = new StringSelection(path.getAbsolutePath());
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);


            Robot robot = new Robot();

//This launches java applet, so we are using cmd+tab to shift the focus
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(500);

//Open Goto window
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);

//Paste the clipboard value
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);

//Press Enter key to close the Goto window and Upload window
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        /*
        driver.findElement(By.xpath("//*[text()='Upload']")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("toast-container"))));
        String Message = driver.findElement(By.id("toast-container")).getText();


        Assert.assertEquals("Photo successfully uploaded",Message);*/


    }
//  Test 18: Verify that the photo of an existing employee can be changed --> (passes)
    @Test(priority = 12)
    public void PhotoChange() throws AWTException{
        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("[placeholder='GENERAL.FIELD.FIRST_NAME']>input"))));
        driver.findElement(By.cssSelector("[placeholder='GENERAL.FIELD.FIRST_NAME']>input")).sendKeys("Afatsum");
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".mat-select-trigger ng-tns-c215-47")));
        driver.findElement(By.xpath("//span[text()='Active']")).click();
        driver.findElement(By.xpath("//span[text()='All']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("tbody>tr>td:nth-child(7)>div:nth-child(1)>ms-edit-button>button"))));
        driver.findElement(By.cssSelector("tbody>tr>td:nth-child(7)>div:nth-child(1)>ms-edit-button>button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//span[text()='Photo']"))));
        driver.findElement(By.xpath("//span[text()='Photo']")).click();

        driver.findElement(By.cssSelector("[data-icon='upload']")).click();

        //driver.findElement(By.xpath("*[@id=’uploadfile_0′]")).click();
        //String path = "/Users/MN/Desktop/profilbild.png";
       // StringSelection stringSelection = new StringSelection(path);
        //Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);


        Robot robot  = new Robot();

        //robot.mouseMove(50,40);
       // robot.mousePress(1);
//This launches java applet, so we are using cmd+tab to shift the focus
        /*robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);*/
        rs.Waiter(5000);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_KP_DOWN);

       // robot.keyRelease(KeyEvent.VK_DOWN);
        rs.Waiter(5000);
        robot.keyPress(KeyEvent.VK_ENTER);
        //robot.keyRelease(KeyEvent.VK_ENTER);
/*
//Open Goto window
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);

//Paste the clipboard value
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);

//Press Enter key to close the Goto window and Upload window
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        /*
        driver.findElement(By.xpath("//*[text()='Upload']")).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("toast-container"))));
        String Message = driver.findElement(By.id("toast-container")).getText();


        Assert.assertEquals("Photo successfully uploaded",Message);*/

    }

//  Test 19: Verify that the photo of an existing employee can be deleted --> (passes)
    @Test(priority = 13)
    public void DeletePhoto(){
        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("[placeholder='GENERAL.FIELD.FIRST_NAME']>input"))));
        driver.findElement(By.cssSelector("[placeholder='GENERAL.FIELD.FIRST_NAME']>input")).sendKeys("Afatsum");
        //wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".mat-select-trigger ng-tns-c215-47")));
        driver.findElement(By.xpath("//span[text()='Active']")).click();
        driver.findElement(By.xpath("//span[text()='All']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("tbody>tr>td:nth-child(7)>div:nth-child(1)>ms-edit-button>button"))));
        driver.findElement(By.cssSelector("tbody>tr>td:nth-child(7)>div:nth-child(1)>ms-edit-button>button")).click();


        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//span[text()='Photo']"))));
        driver.findElement(By.xpath("//span[text()='Photo']")).click();

        wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector("div>button[color='warn']"))));
        driver.findElement(By.cssSelector("div>button[color='warn']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//mat-dialog-actions/div/div/button[1]"))));
        driver.findElement(By.xpath("//mat-dialog-actions/div/div/button[1]")).click();
        driver.findElement(By.cssSelector("mat-dialog-actions>div:nth-child(2)>button")).click();


        rs.Waiter(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("toast-container"))));
        String Message = driver.findElement(By.id("toast-container")).getText();
        Assert.assertEquals("Employee status is active. But employee doesn't have active contract", Message);


    }


//  Write at least three different test cases for the search options of your own!

//  Close the browser
    @AfterClass
    public void cleanUp(){
    driver.quit();
    }

//  Good luck!

}
