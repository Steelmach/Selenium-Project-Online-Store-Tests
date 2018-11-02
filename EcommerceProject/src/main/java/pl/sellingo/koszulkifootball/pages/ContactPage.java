package pl.sellingo.koszulkifootball.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.sellingo.koszulkifootball.fundamental.FundamentalTest;

public class ContactPage extends FundamentalTest {

    //WebElements
    @FindBy(className = "phone")
    WebElement phone;

    @FindBy(className = "email")
    WebElement mail;

    @FindBy(className = "address")
    WebElement address;

    @FindBy(css="div.form-title")
    WebElement contactFormLabel;






    //Elements
    String correctPhone="532417054";
    String correctMail="sklep@koszulkifootball.sellingo.pl";
    String correctAddress="Wrocław 54-203, Legnicka 57";

    //Initializing the page object
    public ContactPage(){
        PageFactory.initElements(driver, this);
    }

    //Actions
    public String getPageTitle(){
        return driver.getTitle();
    }

    public boolean verifyIsDisplayPhone() {

        if (phone.getText().equals(correctPhone)) {
            return true;
        }
        else return false;
    }

    public boolean verifyIsDisplayMail() {

        if (mail.getText().equals(correctMail)){
            return true;
        }
        else return false;
    }

    public boolean verifyIsDisplayAddress() {

        if (address.getText().equals(correctAddress)) {
            return true;
        }
        else return false;
    }

    public boolean verifyIsDisplayContactForm(){
        return contactFormLabel.isDisplayed();
    }



}
