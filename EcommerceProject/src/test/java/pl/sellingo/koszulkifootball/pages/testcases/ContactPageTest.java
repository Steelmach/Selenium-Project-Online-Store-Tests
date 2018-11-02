package pl.sellingo.koszulkifootball.pages.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.sellingo.koszulkifootball.fundamental.FundamentalTest;
import pl.sellingo.koszulkifootball.pages.ContactPage;
import pl.sellingo.koszulkifootball.pages.MainPage;

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


    @Test(priority = 0)
    public void verifyPageTitleOnMainPage(){
        Assert.assertEquals(mainPage.getTitleOnMainPage(),"Koszulkifootball.sellingo.pl");
    }

    @Test(priority = 1)
    public void verifyMainMenuContactLinkIsDisplay(){
            Assert.assertTrue(mainPage.mainMenuContactLink(), "ContactLink is not display!");
    }

    @Test(priority = 2)
    public void verifyPageTitleOnContactPage(){
            contactPage = mainPage.clickMainMenuContactLink();
            Assert.assertEquals(contactPage.getPageTitle(),"Kontakt");

    }

    @Test(priority = 3)
    public void verifyPhoneNumber(){
        contactPage = mainPage.clickMainMenuContactLink();
        Assert.assertTrue(contactPage.verifyIsDisplayPhone(),"Phone numer is incorrect!");
    }
    @Test(priority = 4)
    public void verifyEmailAddress(){
        contactPage = mainPage.clickMainMenuContactLink();
        Assert.assertTrue(contactPage.verifyIsDisplayMail(),"Email is incorrect!");
    }

    @Test(priority = 5)
    public void verifyAddress(){
        contactPage = mainPage.clickMainMenuContactLink();
        Assert.assertTrue(contactPage.verifyIsDisplayAddress(),"Address is incorrect!");
    }

    @Test(priority = 6)
    public void verifyContactFormIsDispaly(){
        contactPage = mainPage.clickMainMenuContactLink();
        Assert.assertTrue(contactPage.verifyIsDisplayContactForm(),"Contact Form is not display!");
    }



    @AfterMethod
    public void quit(){
        driver.quit();
    }

}
