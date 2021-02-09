package main.Project17;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.swing.text.html.CSS;
import java.util.List;


public class POM {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;


    public POM() {

        PageFactory.initElements(this.driver,this);
    }


     ReusableMethods rm = new ReusableMethods (driver,wait,js);

    @FindBy(css = "div[role =\"listbox\"]>mat-option:nth-child(1)")
    public WebElement repMotherOption;
    @FindBy(css = "div[role =\"listbox\"]>mat-option:nth-child(2)")
    public WebElement repFatherOption;
    @FindBy(css = "div[role =\"listbox\"]>mat-option:nth-child(3)")
    public WebElement repGuardianOption;
    @FindBy(css = "div[role =\"listbox\"]>mat-option:nth-child(4)")
    public WebElement repSelfOption;
    @FindBy(css = "div[role=\"listbox\"]>[role=\"option\"]:nth-child(1)")
    public WebElement countryKAZOption;
    @FindBy(css = "div[role=\"listbox\"]>[role=\"option\"]:nth-child(2)")
    public WebElement countryUSAOption;
    @FindBy(css = "div[role=\"listbox\"]>[role=\"option\"]:nth-child(3)")
    public WebElement countryRUSOption;
    @FindBy(css = "div[role=\"listbox\"]>[role=\"option\"]:nth-child(4)")
    public WebElement countryUKROption;
    @FindBy(css = "student-relatives table tbody tr")
    public List<WebElement> studentRelativeTable;



    @FindBy(css = "a[aria-label=\"dismiss cookie message\"]")
    public WebElement dismissCookieButton;
    @FindBy(css = "[aria-label=\"LOGIN\"]")
    public WebElement LoginButton;
    @FindBy(xpath = "//span[text()='Student']")
    public WebElement StudentButton;
    @FindBy(xpath = "//span[text()='Students']")
    public WebElement StudentsButton;
    @FindBy(css = "ms-add-button")
    public WebElement addButton;
    @FindBy(css = "//div[text()=\"Representatives\"]")
    public WebElement RepresentativesButton;
   // @FindBy(css = "ms-add-button[tooltip=\"GENERAL.BUTTON.ADD_REPRESENTATIVE\"]")
   @FindBy(css = "th.mat-header-cell button.mat-focus-indicator")
    public WebElement plusButton;
    @FindBy(css = "[formcontrolname=\"type\"]")
    public WebElement repFormButton;
    @FindBy(css = "mat-form-field[formgroupname=\"country\"]>div")
    public WebElement countryFormButton;
    @FindBy(xpath = "//mat-dialog-actions/div[1]/button/span[1]")
    public WebElement addFormButton;
    @FindBy(xpath = "span[text()=\"Save\"]")
    public WebElement saveFormButton;
    @FindBy(xpath = "//*[text()=\"Document Info\"]")
    public WebElement DocumentInfoButton;
    @FindBy(xpath = "//span[text()=\" Close \"]")
    public WebElement CloseButton;
    @FindBy(css = "td.mat-cell ms-delete-button")
    public WebElement TrashButton;
    @FindBy(css = "button[type=\"submit\"]")
    public WebElement YesButton;

    //



    @FindBy(css = "[data-placeholder=\"Username\"]")
    public WebElement UsernameInput;
    @FindBy(css = "[data-placeholder=\"Password\"]")
    public WebElement PasswordInput;
    @FindBy(css = "input[formcontrolname=\"firstName\"]")
    public WebElement FirstNameInput;
    @FindBy(css = "input[formcontrolname=\"lastName\"]")
    public WebElement LastNameInput;
    @FindBy(css = "input[formcontrolname=\"phone\"]")
    public WebElement phoneInput;

WebElement element;


    public By representativeButton = By.xpath("//div[text()=\"Representatives\"]");

    public void findElementAndClickFunction(String elementName){

    switch (elementName){

        case "dismissCookieButton":
            element = dismissCookieButton;
            break;
        case "LoginButton":
            element = LoginButton;
            break;
        case "StudentButton":
            element = StudentButton;
            break;
        case "StudentsButton":
            element = StudentsButton;
            break;
        case "addButton":
            element = addButton;
            break;
        case "RepresentativesButton":
            element = RepresentativesButton;
            break;
        case "plusButton":
            element = plusButton;
            break;
        case "repFormButton":
            element = repFormButton;
            break;
        case "countryFormButton":
            element = countryFormButton;
            break;
        case "addFormButton":
            element = addFormButton;
            break;
        case "saveFormButton":
            element = saveFormButton;
            break;
        case "DocumentInfoButton":
            element = DocumentInfoButton;
            break;
        case "CloseButton":
            element = CloseButton;
            break;
        case "TrashButton":
            element = TrashButton;
            break;
        case "YesButton":
            element = YesButton;
            break;






    }
        rm.clickFunction(element);

}
public void findElementAndSendKeyFunction(String elementName,String value){
    switch (elementName) {
        case "UsernameInput":
            element = UsernameInput;
            break;
        case "PasswordInput":
            element = PasswordInput;
            break;
        case "FirstNameInput":
            element = FirstNameInput;
            break;
        case "LastNameInput":
            element = LastNameInput;
            break;
        case "phoneInput":
            element = phoneInput;
            break;
    }
    rm.sendKeyFunction(element,value);
}
   }

