package pl.sellingo.koszulkifootball.pages.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.sellingo.koszulkifootball.fundamental.FundamentalTest;
import pl.sellingo.koszulkifootball.pages.MainPage;
import pl.sellingo.koszulkifootball.pages.PolitykaPrywatnosciPage;
import pl.sellingo.koszulkifootball.pages.RegulaminPage;
import pl.sellingo.koszulkifootball.pages.ReklamacjePage;

import static java.lang.Thread.sleep;
import static org.testng.Assert.*;
import static pl.sellingo.koszulkifootball.fundamental.FundamentalTest.initial;

public class MainPageTest_VerifyFooter extends FundamentalTest {

    MainPage mainPage;
    RegulaminPage regulaminPage;
    PolitykaPrywatnosciPage politykaPrywatnosciPage;
    ReklamacjePage reklamacjePage;


    public MainPageTest_VerifyFooter() {
       super();
    }

    @BeforeMethod
    public void setUp() {
        initial();
        mainPage = new MainPage();
        regulaminPage = new RegulaminPage();
        politykaPrywatnosciPage = new PolitykaPrywatnosciPage();
        reklamacjePage = new ReklamacjePage();
    }

    @Test(priority = 1)
    public void verifyPageTitleAndDeleteCookiesAndTakeScreenshot(){
        mainPage.getTitleOnMainPage();
        mainPage.takeScreenshot("mainPage_screen");
    }


    @Test(priority = 2)
    public void verifyFooterIsDisplay(){
        assertTrue(mainPage.getFooterOnMainPage(),"Footer is not display on the page");
    }


    @Test(priority = 3)
    public void verifyFooterSectionNames() {
        mainPage.getFooterList();
        assertEquals(mainPage.actualFooterSectionNameOnMainPage, mainPage.correctFooterSectionNameOnMainPage);
    }



    @Test(priority = 4)
    public void verifyInformationPhoneAndEmailOnFooterSectionKontakt(){
        assertEquals(mainPage.getPhoneNumberOnFooterWithSectionKontakt(),"123 456 789");
        assertEquals(mainPage.getEmailOnFooterWithSectionKontakt(),"sklepkoszulki@email.com");
    }


    @Test(priority = 5)
    public void verifyNumberItemsOnFooterSectionInformacje(){
        assertEquals(mainPage.getNumberItemsWithFooterSextionInformacje(),2);
    }


    @Test(priority = 6)
    public void verifyItemsNameOnFooterSectionInformacje(){
        mainPage.getNameItemsOnFooterSectionInformacje();
        assertEquals(mainPage.actualItemsNameOnFooterSectionInformacje, mainPage.correctItemsNameOnFooterSectionInformacje);
    }


    @Test(priority = 7)
    public void verifyFirstLinkOnFooterSectionInformacjeAndCheckPageTitle()
    {
        assertEquals(mainPage.getFirstLinkOnFooterSectionInformacje(),"Regulamin");
        mainPage.clicFirstLinkOnFooterSectionInformacje();
        assertEquals(regulaminPage.getTitleOnRegulaminPage(), "Regulamin");
    }


    @Test(priority = 8)
    public void verifySecondLinkOnFooterSectionInformacjeAndCheckPageTitle()
    {
        assertEquals(mainPage.getSecondLinkOnFooterSectionInformacje(),"Polityka prywatności");
        mainPage.clicSecondLinkOnFooterSectionInformacje();
        assertEquals(politykaPrywatnosciPage.getPageTitleOnPolitykaPrywatnosciPage(), "Polityka prywatności");
    }


    @Test(priority = 9)
    public void verifyNumberItemsOnFooterSectionPomoc(){
        assertEquals(mainPage.getNumberItemsOnFooterSectionPomoc(),1);
    }


    @Test(priority = 10)
    public void verifyFirstLinkOnFooterSectionPomoc(){
        assertEquals(mainPage.getFirstItemOnFooterSectionPomoc(),"Reklamacje");

    }

    @Test(priority = 11)
    public void verifyFirstLinkOnFooterSectionPomocAndCheckPageTitle()
    {
        assertEquals(mainPage.getFirstItemOnFooterSectionPomoc(),"Reklamacje");
        mainPage.clicFirstLinkOnFooterSectionPomoc();
        assertEquals((reklamacjePage.getTitleOnReklamacje()), "Reklamacje");
    }



    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
