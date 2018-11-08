package pl.sellingo.koszulkifootball.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.sellingo.koszulkifootball.fundamental.FundamentalTest;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ContactPage extends FundamentalTest {


    WebDriverWait wait;

    //WebElements
    @FindBy(className = "phone")
    WebElement phone;

    @FindBy(className = "email")
    WebElement mail;

    @FindBy(className = "address")
    WebElement address;

    @FindBy(css = "div.form-title")
    WebElement contactFormLabel;

    @FindBy(className = "form_contact")
    WebElement contactFormSection;

    @FindBy(id = "input_169")
    WebElement inputEmail;

    @FindBy(id = "input_170")
    WebElement inputTextMessage;

    @FindBy(className = "btn-8")
    WebElement buttonSubmitContactForm;

    @FindBy(className = "success")
    WebElement labelSuccessSendMialConfirm;

    //Elements
    String correctPhone = "532417054";
    String correctMail = "sklep@koszulkifootball.sellingo.pl";
    String correctAddress = "Wrocław 54-203, Legnicka 57";

    //Initializing the page object
    public ContactPage() {

        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }

    //Actions
    public String getPageTitleOnContactPage() {
        driver.manage().deleteAllCookies();
        return driver.getTitle();
    }

    public boolean verifyIsDisplayCorrectPhone() {
        wait.until(visibilityOf(phone));
        if (phone.getText().equals(correctPhone)) {
            return true;
        } else return false;
    }

    public boolean verifyIsDisplayCorrectMail() {
        wait.until(visibilityOf(mail));
        if (mail.getText().equals(correctMail)) {
            return true;
        } else return false;
    }

    public boolean verifyIsDisplayCorrectAddress() {
        wait.until(visibilityOf(address));
        if (address.getText().equals(correctAddress)) {
            return true;
        } else return false;
    }

    public boolean verifyIsDisplayContactForm() {
        return wait.until(visibilityOf(contactFormLabel)).isDisplayed();

    }

    public boolean contactFormSectionIsDisplay() {
        return wait.until(visibilityOf(contactFormSection)).isDisplayed();
    }


    public boolean getAllElementsFromContactForm() {

        boolean email = wait.until(visibilityOf(inputEmail)).isDisplayed();
        boolean message = wait.until(visibilityOf(inputTextMessage)).isDisplayed();
        boolean submit = wait.until(visibilityOf(buttonSubmitContactForm)).isDisplayed();

        if (email == true && message == true && submit == true) {
            return true;
        } else return false;
    }

    public void fillEmailAndMessageAndClickSubmit(String email, String message){

      wait.until(visibilityOf(inputEmail)).sendKeys(email);
      wait.until(visibilityOf(inputTextMessage)).sendKeys(message);
      wait.until(elementToBeClickable(buttonSubmitContactForm)).click();


    }

    public String getNameLabelAfterSendMail(){
       return wait.until(visibilityOf(labelSuccessSendMialConfirm)).getText();
    }
}
