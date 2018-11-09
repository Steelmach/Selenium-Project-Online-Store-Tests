package pl.sellingo.koszulkifootball.pages.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.sellingo.koszulkifootball.fundamental.FundamentalTest;
import pl.sellingo.koszulkifootball.pages.MainPage;

import static org.testng.Assert.*;

public class MainPageTest_VerifyHeader extends FundamentalTest {

    MainPage mainPage;


            public MainPageTest_VerifyHeader(){
                super();
            }



                     @BeforeMethod
                     public void setUp(){
                        initial();
                        mainPage = new MainPage();
                    }


                    @Test(priority = 1)
                    public void verifyPageTitleOnMainPageAndTakeScreen(){
                        assertTrue(mainPage.getTitleOnMainPage());
                    }


                    @Test(priority = 2)
                    public void verifyLogoIsDisplay(){
                        assertTrue(mainPage.logoIsDisplay());
                    }


                    @Test(priority = 3)
                    public void verifyPageTitleAfterClickedToLogo(){
                        assertEquals(mainPage.getPageTitleAfterClickedOnLogo(), "Koszulkifootball.sellingo.pl");
                    }

                    @Test(priority = 4)
                    public void verifyInformationPhoneNumberAndEmailInHeader(){
                        assertEquals(mainPage.getPhoneNumerFromHeader(), "532417054");
                        assertEquals(mainPage.getEmailFromHeader(),"sklep@koszulkifootball.sellingo.pl");
                    }

                    @Test(priority = 5)
                    public void verifyNumberProductInBasket(){

                        assertEquals(mainPage.getNumberProductsFromBasket(), 0);
                    }

                    @Test(priority = 6)
                    public void verifyAmountInBasket(){

                        assertEquals(mainPage.getAmountFromBasket(), "0");
                    }

                    @Test(priority = 7)
                    public void veifyCurrencyInBasket(){

                        assertEquals(mainPage.getCurrencyFromBasket(), "PLN");
                    }

                    @Test(priority = 8)
                    public void verifyMessageInBasket()
                    {

                        assertEquals(mainPage.getMessageFromBasket(),"KOSZYK JEST\nPUSTY");
                    }


                    @AfterMethod
                    public void quit(){
                        driver.quit();
                    }
}










