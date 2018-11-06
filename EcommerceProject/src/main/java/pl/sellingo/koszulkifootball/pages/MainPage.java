package pl.sellingo.koszulkifootball.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.sellingo.koszulkifootball.fundamental.FundamentalTest;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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


    //Elements
    public ArrayList correctMainMenuItemsNameList = new ArrayList();
    public ArrayList actualMainMenuItemsNameList = new ArrayList();
    public ArrayList correctPageTitle = new ArrayList();
    public ArrayList actualMainMenuItemsLinkList = new ArrayList();
    public ArrayList actualAttributeValueCss_Color = new ArrayList();
    public ArrayList actualAttributeValueCss_ColorBackroud = new ArrayList();


    //Initializing the page object
    public MainPage() {
        PageFactory.initElements(driver, this);
        wait  = new WebDriverWait(driver, 7);

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

    public void takeScreenshot(String name){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("screenshots/"+ name + "_" + dateFormat.format(date)+".jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
