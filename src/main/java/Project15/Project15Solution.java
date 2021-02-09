package Project15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Project15Solution {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "resources/webdrivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 5);

        // Navigate to https://test.campus.techno.study/
        driver.get("https://test.campus.techno.study");

        // Dismiss the cookie message by clicking on "Got it!" button
        driver.findElement(By.cssSelector("a[aria-label=\"dismiss cookie message\"]")).click();

        // Login by the credentials (username = "daulet2030@gmail.com" and password = "TechnoStudy123@")
        String username = "daulet2030@gmail.com";
        String password = "TechnoStudy123@";
        driver.findElement(By.cssSelector("input[formcontrolname=\"username\"]")).sendKeys(username);
        driver.findElement(By.cssSelector("input[formcontrolname=\"password\"]")).sendKeys(password);
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();

        // Click on Setup in the left menu
        driver.findElement(By.cssSelector("div.group-items>fuse-nav-vertical-collapsable:first-child")).click();

        // Click on School Setup
        driver.findElement(By.cssSelector("fuse-nav-vertical-collapsable:first-child>div.children>fuse-nav-vertical-collapsable:nth-child(2)")).click();

        // Click on Departments
        driver.findElement(By.cssSelector("a[href=\"/school-department\"]")).click();

        // Click on "+" button to add a school department
        driver.findElement(By.cssSelector("ms-add-button[tooltip=\"SCHOOL_DEPARTMENT.TITLE.ADD\"]")).click();

        // On the pop-up window, type "High School" for the name of the department and "HS-1" for the code.
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ms-text-field[formcontrolname=\"name\"]>input")));

        driver.findElement(By.cssSelector("ms-text-field[formcontrolname=\"name\"]>input")).sendKeys("High School");
        driver.findElement(By.cssSelector("ms-text-field[formcontrolname=\"code\"]>input")).sendKeys("HS-1");

        // Click on "Section" tab
        driver.findElement(By.cssSelector("div.mat-tab-labels>div[tabindex=\"0\"]")).click();

        // Click on "+" button to ad a new section.
//        driver.findElement(By.id("mat-tab-label-0-1")).click();

        // Type "Junior Classes" for the name of the section and "Juniors" for the short name and click on "Add" button to create the section.
        driver.findElement(By.cssSelector("input#ms-text-field-2")).sendKeys("Junior Classes");
        driver.findElement(By.cssSelector("input#ms-text-field-3")).sendKeys("Juniors");
        driver.findElement(By.cssSelector("ms-button>button")).click();

        // Create another section with the name "Senior Classes" and the short name "Seniors" similarly.
        driver.findElement(By.cssSelector("input#ms-text-field-2")).sendKeys("Senior Classes");
        driver.findElement(By.cssSelector("input#ms-text-field-3")).sendKeys("Seniors");
        driver.findElement(By.cssSelector("ms-button>button")).click();

        // Click on "Save" for creating the school department.
        driver.findElement(By.cssSelector("ms-save-button>button")).click();

        // Verify if the department with the name "High School" created. It should write "School Department successfully created." on the console.
        if (driver.findElement(By.xpath("//td[text()='High School']")).isDisplayed()) {
            System.out.println("School Department successfully created.");
        } else {
            System.out.println("A problem has occurred while creating a new school department!");
        }

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[role='alertdialog']")));

        // Click on "+" button to add a school department AGAIN
        driver.findElement(By.cssSelector("ms-add-button[tooltip=\"SCHOOL_DEPARTMENT.TITLE.ADD\"]")).click();

        // On the pop-up window, type "High School" for the name of the department and "HS-1" for the code AGAIN
        driver.findElement(By.cssSelector("ms-text-field[formcontrolname=\"name\"]>input")).sendKeys("High School");
        driver.findElement(By.cssSelector("ms-text-field[formcontrolname=\"code\"]>input")).sendKeys("HS-1");

        // Click on "Save" for TRYING to create a school department with the same name.
        driver.findElement(By.cssSelector("ms-save-button>button")).click();

        // Verify that a dialog box occurs with a message "There is already Department with "High School" name!"
        // It should write the message of the dialog box on the console.
        System.out.println(driver.findElement(By.cssSelector("div[role='alertdialog']")).getText());

        // Click on "x" to dismiss the pop-up window.
        driver.findElement(By.cssSelector("button[aria-label=\"Close dialog\"]")).click();

        // Click on edit button (or the row) of the "High School" department to edit it.
        driver.findElement(By.xpath("//td[text()='High School']")).click();

        // Edit the school department name as "High School Classes" and department code as "HSC-1" and click on "Save"
        driver.findElement(By.cssSelector("ms-text-field[formcontrolname=\"name\"]>input")).clear();
        driver.findElement(By.cssSelector("ms-text-field[formcontrolname=\"name\"]>input")).sendKeys("High School Classes");
        driver.findElement(By.cssSelector("ms-text-field[formcontrolname=\"code\"]>input")).clear();
        driver.findElement(By.cssSelector("ms-text-field[formcontrolname=\"code\"]>input")).sendKeys("HSC-1");
        driver.findElement(By.cssSelector("ms-save-button>button")).click();

        // Verify if the department name was edited as "High School Classes" and department code was edited as "HSC-1"
        // It should write "School Department name successfully edited." on the console.

        if (driver.findElement(By.xpath("//td[text()='High School Classes']")).isDisplayed()) {
            System.out.println("School Department name successfully edited.");
        } else {
            System.out.println("A problem has occurred while editing the school department name!");
        }

        // And it should write "School Department code successfully edited." on the console.
        if (driver.findElement(By.xpath("//td[text()=' HSC-1 ']")).isDisplayed()) {
            System.out.println("School Department code successfully edited.");
        } else {
            System.out.println("A problem has occurred while editing the school department code!");
        }

        // Click on corresponding trash icon
        driver.findElement(By.xpath("//tbody/tr[1]/..//ms-delete-button/button")).click();

        // Click on "Yes" for deleting the school department.
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        // Verify the department is deleted. (it should not be present in the table anymore)
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[role='alertdialog']")));
        List<WebElement> departmentNames = driver.findElements(By.cssSelector("td:nth-child(2)"));
        boolean isDeleted = true;
        for (WebElement departmentName : departmentNames) {
            if (departmentName.getText().equals("High School Classes")) {
                System.out.println(departmentName.getText());
                isDeleted = false;
                break;
            }
        }
        if (isDeleted) {
            System.out.println("School Department successfully deleted.");
        } else {
            System.out.println("A problem has occurred while deleting the school department!");
        }

        // Close the browser
        driver.quit();

    }
}
