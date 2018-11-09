package pl.sellingo.koszulkifootball.pages.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.sellingo.koszulkifootball.fundamental.FundamentalTest;
import pl.sellingo.koszulkifootball.pages.MainPage;

import static org.testng.Assert.*;

public class MainPageTest_VerifySideMenuKategorie extends FundamentalTest {

        MainPage mainPage;


        public MainPageTest_VerifySideMenuKategorie(){
            super();
        }


    @BeforeMethod
    public void setUp(){
        initial();
        mainPage = new MainPage();
    }


    @Test(priority = 1)
    public void verifyPageTitleOnMainPage(){
        assertTrue(mainPage.getTitleOnMainPage(),"Tytuł strony  jest nieprawidłowy!!");
        mainPage.takeScreenshot("Ekran glowny");
    }


    @Test(priority = 2)
    public void verifySideMenuLabelKategorie(){
            assertEquals(mainPage.getSideMenuKategorieLabel(),"Kategorie");
    }


    @Test(priority = 3)
    public void verifyNumberItemsFormSideMenuKategorie(){
            assertEquals(mainPage.getNumberItemsFromSideMenuKategorie(),6);
    }


    @Test(priority = 4)
    public void verifyNameAndSortItemsFormSideMenuKategorie(){
            mainPage.getNameItemsFormSideMenuKategorieAndSortThem();
            assertEquals(mainPage.actualItemsNameFormSideMenuKategorie, mainPage.correctItemsNameFormSideMenuategorie);
    }


    @Test(priority = 5)
    public void verifyProductListNumberAfterClickedItemKoszulkiFromSideMenuKategorie(){
            assertEquals(mainPage.clickItemKoszulkiFromSideMenuKategorieAndCheckProductsNumber("Koszulki"),12);
    }


    @Test(priority = 6)
    public void verifyProductListNameAfterClickedItemKoszulkiFromSideMenuKategorie(){
        mainPage.getNameItemsFromSideMenuKategorie("Koszulki");
        assertEquals(mainPage.actualNameItemsFromKategoria,mainPage.correctNameItemsFromKategoria);
    }


    @Test(priority = 7)
    public void verifyProductListNumberAfterClickedItemLigaPolskaFromSideMenuKategorie(){
        assertEquals(mainPage.clickItemKoszulkiFromSideMenuKategorieAndCheckProductsNumber("Liga Polska"),3);
    }


    @Test(priority = 8)
    public void verifyProductListNameAfterClickedItemLigaPolskaFromSideMenuKategorie(){
        mainPage.getNameItemsFromSideMenuKategorie("Liga Polska");
        assertEquals(mainPage.actualNameItemsFromKategoria,mainPage.correctNameItemsFromKategoria);
    }


    @Test(priority = 9)
    public void verifyProductListNumberAfterClickedItemLigaAngielskaFromSideMenuKategorie(){
        assertEquals(mainPage.clickItemKoszulkiFromSideMenuKategorieAndCheckProductsNumber("Liga Angielska"),4);
    }


    @Test(priority = 10)
    public void verifyProductListNameAfterClickedItemLigaAngielskaFromSideMenuKategorie(){
        mainPage.getNameItemsFromSideMenuKategorie("Liga Angielska");
        assertEquals(mainPage.actualNameItemsFromKategoria,mainPage.correctNameItemsFromKategoria);
    }


    @Test(priority = 11)
    public void verifyProductListNumberAfterClickedItemLigaWłoskaFromSideMenuKategorie(){
        assertEquals(mainPage.clickItemKoszulkiFromSideMenuKategorieAndCheckProductsNumber("Liga Włoska"),2);
    }


    @Test(priority = 12)
    public void verifyProductListNameAfterClickedItemLigaWłoskaFromSideMenuKategorie(){
        mainPage.getNameItemsFromSideMenuKategorie("Liga Włoska");
        assertEquals(mainPage.actualNameItemsFromKategoria,mainPage.correctNameItemsFromKategoria);
    }


    @Test(priority = 13)
    public void verifyProductListNumberAfterClickedItemLigaHiszpańskaFromSideMenuKategorie(){
        assertEquals(mainPage.clickItemKoszulkiFromSideMenuKategorieAndCheckProductsNumber("Liga Hiszpańska"),2);
    }


    @Test(priority = 14)
    public void verifyProductListNameAfterClickedItemLigaHiszpańskaFromSideMenuKategorie(){
        mainPage.getNameItemsFromSideMenuKategorie("Liga Hiszpańska");
        assertEquals(mainPage.actualNameItemsFromKategoria,mainPage.correctNameItemsFromKategoria);
    }


    @Test(priority = 15)
    public void verifyProductListNumberAfterClickedItemLigaNiemieckaFromSideMenuKategorie(){
        assertEquals(mainPage.clickItemKoszulkiFromSideMenuKategorieAndCheckProductsNumber("Liga Niemiecka"),1);
    }


    @Test(priority = 16)
    public void verifyProductListNameAfterClickedItemLigaNiemieckaFromSideMenuKategorie(){
        mainPage.getNameItemsFromSideMenuKategorie("Liga Niemiecka");
        assertEquals(mainPage.actualNameItemsFromKategoria,mainPage.correctNameItemsFromKategoria);
    }


    @Test(priority = 17)
    public void verifyColorFromItemsSideMenuKategorieAfterClicked(){
            assertTrue(mainPage.clickItemsFromSideMenuKategorieAndGetColorValue());;
    }




    @AfterMethod
    public void quit(){
        driver.quit();
    }

}
