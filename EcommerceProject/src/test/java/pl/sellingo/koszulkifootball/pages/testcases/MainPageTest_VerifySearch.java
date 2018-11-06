package pl.sellingo.koszulkifootball.pages.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.sellingo.koszulkifootball.fundamental.FundamentalTest;
import pl.sellingo.koszulkifootball.pages.MainPage;

import java.lang.ref.PhantomReference;

import static org.testng.Assert.*;

public class MainPageTest_VerifySearch extends FundamentalTest {

    MainPage mainPage;


        public MainPageTest_VerifySearch(){
            super();
        }

        @BeforeMethod
        public void setUp(){
            initial();
            mainPage = new MainPage();
        }

        @Test(priority = 1)
        public void verifyPageTitle(){
            assertTrue(mainPage.getTitleOnMainPage(),"Koszulkifootball.sellingo.pl");
        }

        @Test(priority = 2)
        public void verifySearchIsDisplay(){
            assertTrue(mainPage.searchIsDisplay(), "Search is not display on the page!");
        }

        @Test(priority = 3)
        public void verifyProductsList(){
            mainPage.typeForSearchAndSubmit("AC Milan");
            assertEquals(mainPage.productsOnList(),1);
        }

        @Test(priority = 4)
        public void verifyProductName(){
            mainPage.typeForSearchAndSubmit("AC Milan");
            assertEquals(mainPage.getProductName(),"Replika koszulki AC Milan");
        }

        @Test(priority = 5)
        public void verifyProductPrice(){
            mainPage.typeForSearchAndSubmit("AC Milan");
            assertEquals(mainPage.getPrice(),"180,00","Price is incorrect!");
        }


        @Test(priority = 6)
        public void verifyProductCurrency(){
            mainPage.typeForSearchAndSubmit("AC Milan");
            assertEquals(mainPage.getCurrency(),"PLN","Currency is incorrect!");
        }

        @AfterMethod
        public void quit(){
        driver.quit();
    }

}
