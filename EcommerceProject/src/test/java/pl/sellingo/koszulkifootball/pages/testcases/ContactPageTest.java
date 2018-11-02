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
            contactPage = mainPage.clickMainMenuContactLink();

        }

    @Test(priority = 0)
    public void verifyPageTitleOnMainPage(){
        Assert.assertEquals(contactPage.getPageTitle(),"Kontakt");
    }


    @AfterMethod
    public void quit(){
        driver.quit();
    }

}
