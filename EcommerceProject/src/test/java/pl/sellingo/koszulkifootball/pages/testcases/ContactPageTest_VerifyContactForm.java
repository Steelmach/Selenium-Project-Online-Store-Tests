package pl.sellingo.koszulkifootball.pages.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.sellingo.koszulkifootball.fundamental.FundamentalTest;
import pl.sellingo.koszulkifootball.pages.ContactPage;
import pl.sellingo.koszulkifootball.pages.MainPage;

import static org.testng.Assert.*;
import static pl.sellingo.koszulkifootball.fundamental.FundamentalTest.initial;

public class ContactPageTest_VerifyContactForm extends FundamentalTest {

    MainPage mainPage;
    ContactPage contactPage;
    public ContactPageTest_VerifyContactForm(){
            super();
        }



        @BeforeMethod
        public void setUp(){
                initial();
                mainPage = new MainPage();
                contactPage =mainPage.clickMainMenuContactLink();


        }


            @Test(priority = 1)
            public void verifyContactFormSectionIsDisplay()
            {
                assertTrue(contactPage.contactFormSectionIsDisplay(),"Contact Foorm is not display on the page!");
            }

            @Test(priority = 2)
            public void verifyContactFormIsDisplay(){
                assertTrue(contactPage.contactFormSectionIsDisplay(), "Brak");
            }

            @Test(priority = 3)
            public void verifyAllElementsFromContactFormIsDispaly(){
                assertTrue(contactPage.getAllElementsFromContactForm());
            }

            @Test(priority = 4)
            public void verifyCorrectFillAndSubmitContactForm(){
                contactPage.fillEmailAndMessageAndClickSubmit("kontakttestowy@op.pl", "To jest wiadomość testowa");
                assertEquals(contactPage.getNameLabelAfterSendMail(),"Odpiszemy!");
            }

            @AfterMethod
            public void quit(){

            driver.quit();
        }


    }
