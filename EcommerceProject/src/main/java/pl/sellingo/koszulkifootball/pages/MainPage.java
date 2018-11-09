package pl.sellingo.koszulkifootball.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.sellingo.koszulkifootball.fundamental.FundamentalTest;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Integer.*;
import static java.lang.Thread.sleep;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MainPage extends FundamentalTest {

    WebDriverWait wait;


    //WebElements on the page
    @FindBy(css = "#MainMenu>ul>li")
    List<WebElement> mainMenuItems;

    @FindBy(css = "#MainMenu>ul>li>a")
    List<WebElement> mainMenuItemsLink;

    @FindBy(css = "menu#MainMenu>ul>li:nth-of-type(4)>a")
    WebElement menuContactLink;

    @FindBy(id = "search_query")
    WebElement search;

    @FindBy(name = "search_box_btn_submit")
    WebElement searchSubmit;

    @FindBy(css = "ul.product-sidebar-big>li")
    List<WebElement> productsList;

    @FindBy(css = "ul.product-sidebar-big>li>a:nth-of-type(2)>h2>span")
    WebElement productName;

    @FindBy(className = "value")
    WebElement price;

    @FindBy(css = "div.value + span")
    WebElement currency;

    @FindBy(css = ".container.footer-container")
    WebElement footer;

    @FindBy(css = ".col-md-3.col-sm-4.rwd-footer h2")
    List<WebElement> footerSectionNameList;

    @FindBy(className = "phoneNumber")
    WebElement phoneNumerOnFooter;

    @FindBy(css = ".email > a")
    WebElement emailOnFooter;

    @FindBy(css="div.container.footer-container  div.col-md-3.col-sm-4.rwd-footer:nth-child(2) ul>li")
    List<WebElement> listOfItemsOnFooterSectionInformacje;

    @FindBy(css="div.container.footer-container  div.col-md-3.col-sm-4.rwd-footer:nth-child(2) ul>li:first-child a")
     WebElement regulamiOnFooterSectionInformacjeLink;

    @FindBy(css="div.container.footer-container  div.col-md-3.col-sm-4.rwd-footer:nth-child(2) ul>li:last-child a")
    WebElement politykaPrywatnosciOnFooterSectionInformacjeLink;

    @FindBy(css="div.container.footer-container  div.col-md-3.col-sm-4.rwd-footer:nth-child(3) ul>li")
    List<WebElement> listOfReklamacjeOnFooterSectionPomoc;

    @FindBy(css="div.container.footer-container  div.col-md-3.col-sm-4.rwd-footer:nth-child(3) ul>li:first-child a")
    WebElement reklamacjeOnFooterSectionPomocLink;

    @FindBy(css=".title:nth-of-type(2) > h2")
    WebElement labelSideMenuKategorie;

    @FindBy(css="#menu_categories>li a")
    List<WebElement> listOfElementsFromSideMenuKategorie;

    @FindBy(css="#menu_categories>li:nth-of-type(1) a ")
    WebElement sideMenuKategorieItemKoszulki;

    @FindBy(css="#menu_categories>li:nth-of-type(2) a ")
    WebElement sideMenuKategorieItemLigaPolska;

    @FindBy(css="#menu_categories>li:nth-of-type(3) a")
    WebElement sideMenuKategorieItemLigaAngielska;

    @FindBy(css="#menu_categories>li:nth-of-type(4) a")
    WebElement sideMenuKategorieItemLigaWłoska;

    @FindBy(css="#menu_categories>li:nth-of-type(5) a")
    WebElement sideMenuKategorieItemLigaHiszpanska;

    @FindBy(css="#menu_categories>li:nth-of-type(6) a")
    WebElement sideMenuKategorieItemLigaNiemiecka;

    @FindBy(css=".product-sidebar-big > li")
    List<WebElement> productList;

    @FindBy(css=".product-sidebar-big > li h2 span")
    List<WebElement> productListName;

    @FindBy(css=".header-1 > a:nth-of-type(3) img")
    WebElement logo;

    @FindBy(css=".contact-box.pull-right > p")
    WebElement phoneNumberInHeader;

    @FindBy(css=".contact-box.pull-right > a")
    WebElement emailInHeader;

    @FindBy(className = "cart_count")
    WebElement numberProductsInBasket;

    @FindBy(className = "cart_sum")
    WebElement amountInBasket;

    @FindBy(css=".b-2.t2 > a>span:nth-of-type(2)")
    WebElement currencyInBasket;

    @FindBy(css=".b-3.t3 > a > span")
    WebElement messageInBasket;




//    @FindBy(css="div.container.footer-container  div.col-md-3.col-sm-4.rwd-footer:nth-child(3) ul>li:nth-child(1)")
//    WebElement reklamacjeOnFooterSectionPomocLink;



    //Elements
    public ArrayList correctMainMenuItemsNameList = new ArrayList();
    public ArrayList actualMainMenuItemsNameList = new ArrayList();
    public ArrayList correctPageTitle = new ArrayList();
    public ArrayList actualMainMenuItemsLinkList = new ArrayList();
    public ArrayList actualAttributeValueCss_Color = new ArrayList();
    public ArrayList actualAttributeValueCss_ColorBackroud = new ArrayList();
    public ArrayList actualFooterSectionNameOnMainPage = new ArrayList();
    public ArrayList correctFooterSectionNameOnMainPage = new ArrayList();
    public ArrayList correctItemsNameOnFooterSectionInformacje =  new ArrayList();
    public ArrayList actualItemsNameOnFooterSectionInformacje =  new ArrayList();
    public ArrayList correctItemsNameFormSideMenuategorie = new ArrayList();
    public ArrayList actualItemsNameFormSideMenuKategorie = new ArrayList();
    public ArrayList correctNameItemsFromKategoria = new ArrayList();
    public ArrayList actualNameItemsFromKategoria = new ArrayList();


//    public ArrayList correctNameItemsFromKategoriaLigaPolska = new ArrayList();
//    public ArrayList actualNameItemsFromKategoriaLigaPolska = new ArrayList();
//    public ArrayList correctNameItemsFromKategoriaLigaAngielska = new ArrayList();
//    public ArrayList actualNameItemsFromKategoriaLigaAngielska = new ArrayList();
//    public ArrayList correctNameItemsFromKategoriaLigaWłoska = new ArrayList();
//    public ArrayList actualNameItemsFromKategoriaLigaWłoska = new ArrayList();
//    public ArrayList correctNameItemsFromKategoriaLigaHiszpańska = new ArrayList();
//    public ArrayList actualNameItemsFromKategoriaLigaHiszpańska = new ArrayList();
//    public ArrayList correctNameItemsFromKategoriaLigaNiemiecka = new ArrayList();
//    public ArrayList actualNameItemsFromKategoriaLigaNiemiecka = new ArrayList();



    //Initializing the page object
    public MainPage() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);

    }




    //Actions
    public boolean getTitleOnMainPage() {
        driver.manage().deleteAllCookies();
        return wait.until(titleIs("Koszulkifootball.sellingo.pl"));

    }


    public int getMainMenuItemsSize() {

        wait.until(visibilityOfAllElements(mainMenuItems));
        return mainMenuItems.size();
    }


    public void mainMenuItemsName() {

        correctMainMenuItemsNameList.add("Aktualności");
        correctMainMenuItemsNameList.add("Opinie o sklepie");
        correctMainMenuItemsNameList.add("Reklamacje");
        correctMainMenuItemsNameList.add("Kontakt");

        int i = 0;

        wait.until(visibilityOfAllElements(mainMenuItems));
        for (WebElement item : mainMenuItems) {

            actualMainMenuItemsNameList.add(item.getText());
            i++;
        }

    }


    public void mainMenuTransition() {
        correctMainMenuItemsNameList.add("Aktualności");
        correctMainMenuItemsNameList.add("Opinie o sklepie");
        correctMainMenuItemsNameList.add("Reklamacje");
        correctMainMenuItemsNameList.add("Kontakt");


        correctPageTitle.add("Aktualności");
        correctPageTitle.add("Koszulkifootball.sellingo.pl");
        correctPageTitle.add("Reklamacje");
        correctPageTitle.add("Kontakt");

        wait.until(visibilityOfAllElements(mainMenuItemsLink));
        for (int i = 0; i < mainMenuItemsLink.size(); i++) {

            wait.until(visibilityOfAllElements(mainMenuItemsLink));
            if (mainMenuItemsLink.get(i).getText().equals(correctMainMenuItemsNameList.get(i))) {
                mainMenuItemsLink.get(i).click();
                actualMainMenuItemsLinkList.add(driver.getTitle());
            } else {
                System.out.println("Błędna nazwa zakładki!");
            }
            driver.navigate().back();


        }
    }

    public ContactPage clickMainMenuContactLink() {

        wait.until(elementToBeClickable(menuContactLink));
        menuContactLink.click();
        return new ContactPage();
    }

    public boolean mainMenuContactLink() {
        wait.until(visibilityOf(menuContactLink));
        return menuContactLink.isDisplayed();
    }


    public boolean searchIsDisplay() {
        wait.until(visibilityOf(search));
        return search.isDisplayed();
    }

    public void typeForSearchAndSubmit(String text) {
        wait.until(visibilityOf(search));
        search.clear();
        search.sendKeys(text);
        wait.until(visibilityOf(searchSubmit));
        searchSubmit.click();
        takeScreenshot("productLIST");
    }

    public int productsOnList() {
        wait.until(visibilityOfAllElements(productsList));
        return productsList.size();
    }

    public String getProductName() {
        wait.until(visibilityOf(productName));
        return productName.getText();
    }

    public String getPrice() {
        wait.until(visibilityOf(productName));
        return price.getText();
    }

    public String getCurrency() {
        wait.until(visibilityOf(currency));
        return currency.getText();
    }

    public void getAttributeValueCssOrginal_MainMenuItems() {
        Actions action = new Actions(driver);

        wait.until(visibilityOfAllElements(mainMenuItemsLink));
        for (int i = 0; i < mainMenuItemsLink.size(); i++) {
            actualAttributeValueCss_Color.add(mainMenuItemsLink.get(i).getCssValue("color"));
            actualAttributeValueCss_ColorBackroud.add(mainMenuItemsLink.get(i).getCssValue("background-color"));

            //  System.out.println(actualAttributeValueCss_Color.get(i));
            //  System.out.println(actualAttributeValueCss_ColorBackroud.get(i));

        }

    }

    public void getAttributeValueCssAfterHoverMouse_MainMenuItems() {
        Actions action = new Actions(driver);

        wait.until(visibilityOfAllElements(mainMenuItemsLink));
        for (int i = 0; i < mainMenuItemsLink.size(); i++) {
            action.moveToElement(mainMenuItems.get(i)).build().perform();
            takeScreenshot("Hoover item menu");
            actualAttributeValueCss_Color.add(mainMenuItemsLink.get(i).getCssValue("color"));
            actualAttributeValueCss_ColorBackroud.add(mainMenuItemsLink.get(i).getCssValue("background-color"));

            // System.out.println(actualAttributeValueCss_Color.get(i));
            // System.out.println(actualAttributeValueCss_ColorBackroud.get(i));

        }
    }

    public void takeScreenshot(String name) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("screenshots/" + name + "_" + dateFormat.format(date) + ".jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public boolean getFooterOnMainPage() {
        return wait.until(visibilityOf(footer)).isDisplayed();
    }


    public void getFooterList() {

            correctFooterSectionNameOnMainPage.add("Kontakt");
            correctFooterSectionNameOnMainPage.add("Informacje");
            correctFooterSectionNameOnMainPage.add("Pomoc");


            wait.until(visibilityOfAllElements(footerSectionNameList));
        for (WebElement item : footerSectionNameList) {

            actualFooterSectionNameOnMainPage.add(item.getText());

        }

/* for test

        for(int i =0; i <actualFooterSectionNameOnMainPage.size(); i ++)
        {
            System.out.println(actualAttributeValueCss_ColorBackroud.get(i));
        }
*/

        }


        public String  getPhoneNumberOnFooterWithSectionKontakt(){

            String phoneNumber = wait.until(visibilityOf(phoneNumerOnFooter)).getText();
            return  phoneNumber;
    }



        public String  getEmailOnFooterWithSectionKontakt(){

            String email = wait.until(visibilityOf(emailOnFooter)).getText();
            return  email;
        }


        public int getNumberItemsWithFooterSextionInformacje(){
             int listItemsSize;
             return  listItemsSize =  wait.until(visibilityOfAllElements(listOfItemsOnFooterSectionInformacje)).size();
        }


        public void getNameItemsOnFooterSectionInformacje(){
            correctItemsNameOnFooterSectionInformacje.add("Regulamin");
            correctItemsNameOnFooterSectionInformacje.add("Polityka prywatności");

            for (int i =0; i <listOfItemsOnFooterSectionInformacje.size(); i++){

                actualItemsNameOnFooterSectionInformacje.add(listOfItemsOnFooterSectionInformacje.get(i).getText());
            }

        }

        public String getFirstLinkOnFooterSectionInformacje(){

            return regulamiOnFooterSectionInformacjeLink.getText();
        }

        public String getSecondLinkOnFooterSectionInformacje(){

            return politykaPrywatnosciOnFooterSectionInformacjeLink.getText();
        }


         public RegulaminPage clicFirstLinkOnFooterSectionInformacje(){
            js.executeScript("arguments[0].scrollIntoView();",regulamiOnFooterSectionInformacjeLink );
            wait.until(elementToBeClickable(regulamiOnFooterSectionInformacjeLink)).click();
            return new RegulaminPage();

        }

        public PolitykaPrywatnosciPage clicSecondLinkOnFooterSectionInformacje(){
            js.executeScript("arguments[0].scrollIntoView();",politykaPrywatnosciOnFooterSectionInformacjeLink);
            wait.until(elementToBeClickable(politykaPrywatnosciOnFooterSectionInformacjeLink)).click();
            return new PolitykaPrywatnosciPage();
        }

        public int getNumberItemsOnFooterSectionPomoc(){
            return  wait.until(visibilityOfAllElements(listOfReklamacjeOnFooterSectionPomoc)).size();

        }

        public String getFirstItemOnFooterSectionPomoc(){
            return reklamacjeOnFooterSectionPomocLink.getText();
        }

        public ReklamacjePage clicFirstLinkOnFooterSectionPomoc(){
            js.executeScript("arguments[0].scrollIntoView();",reklamacjeOnFooterSectionPomocLink);
            wait.until(visibilityOf(reklamacjeOnFooterSectionPomocLink)).click();
            return new ReklamacjePage();
        }

        public String getSideMenuKategorieLabel(){
            return wait.until(visibilityOf(labelSideMenuKategorie)).getText();
        }


        public int getNumberItemsFromSideMenuKategorie(){

            return wait.until(visibilityOfAllElements(listOfElementsFromSideMenuKategorie)).size();
        }

        public void getNameItemsFormSideMenuKategorieAndSortThem(){
            correctItemsNameFormSideMenuategorie.add("Koszulki");
            correctItemsNameFormSideMenuategorie.add("Liga Polska");
            correctItemsNameFormSideMenuategorie.add("Liga Angielska");
            correctItemsNameFormSideMenuategorie.add("Liga Włoska");
            correctItemsNameFormSideMenuategorie.add("Liga Hiszpańska");
            correctItemsNameFormSideMenuategorie.add("Liga Niemiecka");



            for(int i = 0; i < correctItemsNameFormSideMenuategorie.size(); i++){
                actualItemsNameFormSideMenuKategorie.add(listOfElementsFromSideMenuKategorie.get(i).getText());

            }
        }

        public int clickItemKoszulkiFromSideMenuKategorieAndCheckProductsNumber(String nameItemFromSideMenuKategorie){

            wait.until(visibilityOfAllElements(listOfElementsFromSideMenuKategorie));

            if(nameItemFromSideMenuKategorie.equals("Koszulki")) {
                sideMenuKategorieItemKoszulki.click();
            }
            else if(nameItemFromSideMenuKategorie.equals("Liga Polska")){
                sideMenuKategorieItemLigaPolska.click();
            }
            else if(nameItemFromSideMenuKategorie.equals("Liga Angielska")){
                sideMenuKategorieItemLigaAngielska.click();
            }
            else if(nameItemFromSideMenuKategorie.equals("Liga Włoska")){
                sideMenuKategorieItemLigaWłoska.click();
            }
            else if(nameItemFromSideMenuKategorie.equals("Liga Hiszpańska")){
                sideMenuKategorieItemLigaHiszpanska.click();
            }
            else if(nameItemFromSideMenuKategorie.equals("Liga Niemiecka")){
                sideMenuKategorieItemLigaNiemiecka.click();
            }

            wait.until(titleIs("Oferta"));
            int productsNumber =  wait.until(visibilityOfAllElements(productsList)).size();

            return productsNumber;
        }


        public void getNameItemsFromSideMenuKategorie(String nameItemsFromSideMenuKategorie) {

            wait.until(visibilityOfAllElements(listOfElementsFromSideMenuKategorie));

            if (nameItemsFromSideMenuKategorie.equals("Koszulki")) {
                correctNameItemsFromKategoria.add("AC Milan Replika koszulki");
                correctNameItemsFromKategoria.add("Arsenal Londyn Replika koszulki");
                correctNameItemsFromKategoria.add("Bayern Monachium Replika koszulki");
                correctNameItemsFromKategoria.add("Chelsea Londyn Replika koszulki");
                correctNameItemsFromKategoria.add("Cracovia Kraków Replika koszulki");
                correctNameItemsFromKategoria.add("FC Barcelona Replika koszulki");
                correctNameItemsFromKategoria.add("FC Liverpool Replika koszulki");
                correctNameItemsFromKategoria.add("Juventus Turyn Replika koszulki");
                correctNameItemsFromKategoria.add("Lechia Gdańsk Replika koszulki");
                correctNameItemsFromKategoria.add("Legia Warszawa Replika koszulki");
                correctNameItemsFromKategoria.add("Manchester United Replika koszulki");
                correctNameItemsFromKategoria.add("Real Madryt Replika koszulki");

                sideMenuKategorieItemKoszulki.click();
                wait.until(titleIs("Oferta"));
                wait.until(visibilityOfAllElements(productsList));
                for (int i = 0; i < productsList.size(); i++) {
                    actualNameItemsFromKategoria.add(productListName.get(i).getText());
                }
            }
            if(nameItemsFromSideMenuKategorie.equals("Liga Polska")){
                correctNameItemsFromKategoria.add("Cracovia Kraków Replika koszulki");
                correctNameItemsFromKategoria.add("Lechia Gdańsk Replika koszulki");
                correctNameItemsFromKategoria.add("Legia Warszawa Replika koszulki");


                sideMenuKategorieItemLigaPolska.click();
                wait.until(titleIs("Oferta"));
                wait.until(visibilityOfAllElements(productsList));
                for (int i = 0; i < productsList.size(); i++) {
                    actualNameItemsFromKategoria.add(productListName.get(i).getText());
                }

            }
            if(nameItemsFromSideMenuKategorie.equals("Liga Angielska")){
                correctNameItemsFromKategoria.add("Arsenal Londyn Replika koszulki");
                correctNameItemsFromKategoria.add("Chelsea Londyn Replika koszulki");
                correctNameItemsFromKategoria.add("FC Liverpool Replika koszulki");
                correctNameItemsFromKategoria.add("Manchester United Replika koszulki");

                sideMenuKategorieItemLigaAngielska.click();
                wait.until(titleIs("Oferta"));
                wait.until(visibilityOfAllElements(productsList));
                for (int i = 0; i < productsList.size(); i++) {
                    actualNameItemsFromKategoria.add(productListName.get(i).getText());
                }

            }
            if(nameItemsFromSideMenuKategorie.equals("Liga Włoska")){
                correctNameItemsFromKategoria.add("AC Milan Replika koszulki");
                correctNameItemsFromKategoria.add("Juventus Turyn Replika koszulki");

                sideMenuKategorieItemLigaWłoska.click();
                wait.until(titleIs("Oferta"));
                wait.until(visibilityOfAllElements(productsList));
                for (int i = 0; i < productsList.size(); i++) {
                    actualNameItemsFromKategoria.add(productListName.get(i).getText());
                }

            }
            if(nameItemsFromSideMenuKategorie.equals("Liga Hiszpańska")){
                correctNameItemsFromKategoria.add("FC Barcelona Replika koszulki");
                correctNameItemsFromKategoria.add("Real Madryt Replika koszulki");

                sideMenuKategorieItemLigaHiszpanska.click();
                wait.until(titleIs("Oferta"));
                wait.until(visibilityOfAllElements(productsList));
                for (int i = 0; i < productsList.size(); i++) {
                    actualNameItemsFromKategoria.add(productListName.get(i).getText());
                }

            }
            if(nameItemsFromSideMenuKategorie.equals("Liga Niemiecka")){
                correctNameItemsFromKategoria.add("Bayern Monachium Replika koszulki");


                sideMenuKategorieItemLigaNiemiecka.click();
                wait.until(titleIs("Oferta"));
                wait.until(visibilityOfAllElements(productsList));
                for (int i = 0; i < productsList.size(); i++) {
                    actualNameItemsFromKategoria.add(productListName.get(i).getText());
                }

            }
    }

            public boolean clickItemsFromSideMenuKategorieAndGetColorValue() {
                String correctColorValue = "rgba(255, 89, 0, 1)";
                String colorValue;
                boolean flag = true;

                wait.until(visibilityOfAllElements(listOfElementsFromSideMenuKategorie));
                for (int i = 0; i < listOfElementsFromSideMenuKategorie.size(); i++) {
                    listOfElementsFromSideMenuKategorie.get(i).click();
                    colorValue = listOfElementsFromSideMenuKategorie.get(i).getCssValue("color");

                    if (colorValue.equals(correctColorValue)) {
                        flag = true;

                    } else {
                        flag = false;
                        System.out.println("Błędny kolor dla zakładki: " + listOfElementsFromSideMenuKategorie.get(i).getText());
                        System.out.println("Otrzymany kolor zakładki to: " + colorValue + ", poprawny kolor to: " + correctColorValue  );
                        break;
                    }                }

                return flag;
            }



            public boolean logoIsDisplay(){
               return wait.until((visibilityOf(logo))).isDisplayed();
            }


            public String getPageTitleAfterClickedOnLogo(){

                wait.until(visibilityOf(logo)).click();
                return driver.getTitle();
            }


            public String getPhoneNumerFromHeader(){

                return wait.until(visibilityOf(phoneNumberInHeader)).getText();
            }

            public String getEmailFromHeader(){

                return wait.until(visibilityOf(emailInHeader)).getText();
            }

            public int getNumberProductsFromBasket(){
                return parseInt(wait.until(visibilityOf(numberProductsInBasket)).getText());
            }

            public String getAmountFromBasket(){

                return wait.until(visibilityOf(amountInBasket)).getText();
            }


            public String getCurrencyFromBasket(){

                return wait.until(visibilityOf(currencyInBasket)).getText();
            }


            public String getMessageFromBasket(){

                return wait.until(visibilityOf(messageInBasket)).getText();
            }


}








