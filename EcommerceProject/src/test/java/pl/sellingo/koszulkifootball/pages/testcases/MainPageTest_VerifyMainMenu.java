package pl.sellingo.koszulkifootball.pages.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;
import pl.sellingo.koszulkifootball.fundamental.FundamentalTest;
import pl.sellingo.koszulkifootball.pages.MainPage;

import static org.testng.AssertJUnit.assertEquals;

public class MainPageTest_VerifyMainMenu extends FundamentalTest {

    MainPage mainPage;



    public MainPageTest_VerifyMainMenu(){
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
    public void verifyMainMenuItemsNumber(){
        Assert.assertEquals(mainPage.getMainMenuItemsSize(),4);
    }


    @Test(priority = 2)
    public void verifyMainMenuItemsName(){
        mainPage.mainMenuItemsName();

        for(int i=0; i<mainPage.getMainMenuItemsSize(); i++)
        {
            Assert.assertEquals(mainPage.correctMainMenuItemsNameList.get(i),mainPage.actualMainMenuItemsNameList.get(i));
        }
    }


    @Test(priority = 3)
    public void verifyMainMenuItemsNameoSort(){
        mainPage.mainMenuItemsName();

        for(int i=0; i<mainPage.getMainMenuItemsSize(); i++)
        {
            Assert.assertEquals(mainPage.correctMainMenuItemsNameList.get(i),mainPage.actualMainMenuItemsNameList.get(i));
        }
    }


    @Test(priority = 4)
    public void verifyMainMenuItemTransition()
    {
        mainPage.mainMenuTransition();
        for(int i = 0; i < mainPage.getMainMenuItemsSize(); i++){
            assertEquals(mainPage.actualMainMenuItemsLinkList.get(i), mainPage.correctPageTitle.get(i));
        }
    }


    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
