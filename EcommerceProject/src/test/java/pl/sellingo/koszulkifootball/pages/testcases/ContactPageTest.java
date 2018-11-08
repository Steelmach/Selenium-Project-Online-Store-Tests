package pl.sellingo.koszulkifootball.pages.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.sellingo.koszulkifootball.fundamental.FundamentalTest;
import pl.sellingo.koszulkifootball.pages.ContactPage;
import pl.sellingo.koszulkifootball.pages.MainPage;

import static org.testng.Assert.*;

public class ContactPageTest extends FundamentalTest {

    MainPage mainPage;
    ContactPage contactPage;


    public ContactPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initial();
        mainPage = new MainPage();
    }


    @Test(priority = 1)
    public void verifyPageTitleOnMainPage(){
        assertTrue(mainPage.getTitleOnMainPage(),"Koszulkifootball.sellingo.pl");
    }

    @Test(priority = 2)
    public void verifyMainMenuContactLinkIsDisplay(){
        assertTrue(mainPage.mainMenuContactLink(), "ContactLink is not display!");
    }

    @Test(priority = 3)
    public void verifyPageTitleOnContactPage(){
        contactPage = mainPage.clickMainMenuContactLink();
        assertTrue(contactPage.getPageTitleOnContactPage(),"Kontakt");

    }

    @Test(priority = 4)
    public void verifyPhoneNumber(){
        contactPage = mainPage.clickMainMenuContactLink();
        assertTrue(contactPage.verifyIsDisplayCorrectPhone(),"Phone numer is incorrect!");
    }
    @Test(priority = 5)
    public void verifyEmailAddress(){
        contactPage = mainPage.clickMainMenuContactLink();
        assertTrue(contactPage.verifyIsDisplayCorrectMail(),"Email is incorrect!");
    }

    @Test(priority = 6)
    public void verifyAddress(){
        contactPage = mainPage.clickMainMenuContactLink();
        assertTrue(contactPage.verifyIsDisplayCorrectAddress(),"Address is incorrect!");
    }

    @Test(priority = 7)
    public void verifyContactFormIsDispaly(){
        contactPage = mainPage.clickMainMenuContactLink();
        assertTrue(contactPage.verifyIsDisplayContactForm(),"Contact Form is not display!");
    }



    @AfterMethod
    public void quit(){
        driver.quit();
    }

}