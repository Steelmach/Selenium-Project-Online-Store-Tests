package pl.sellingo.koszulkifootball.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.sellingo.koszulkifootball.fundamental.FundamentalTest;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends FundamentalTest {


    //WebElements on the page
    @FindBy(id = "MainMenu")
    WebElement mainMenu;

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

    }


    //Actions
    public String getTitleOnMainPage() {
        return driver.getTitle();
    }


    public int getMainMenuItemsSize() {
        return mainMenuItems.size();
    }


    public void mainMenuItemsName() {

        correctMainMenuItemsNameList.add("Aktualności");
        correctMainMenuItemsNameList.add("Opinie o sklepie");
        correctMainMenuItemsNameList.add("Reklamacje");
        correctMainMenuItemsNameList.add("Kontakt");

        int i = 0;

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


        for (int i = 0; i < mainMenuItemsLink.size(); i++) {
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

        menuContactLink.click();
        return new ContactPage();
    }

    public boolean mainMenuContactLink() {
        return menuContactLink.isDisplayed();
    }


    public boolean searchIsDisplay() {
        return search.isDisplayed();
    }

    public void typeForSearchAndSubmit(String text) {
        search.clear();
        search.sendKeys(text);
        searchSubmit.click();
    }

    public int productsOnList() {

        return productsList.size();
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public String getCurrency() {
        return currency.getText();
    }

    public void getAttributeValueCssOrginal_MainMenuItems() {

        Actions action = new Actions(driver);

        for (int i = 0; i < mainMenuItemsLink.size(); i++) {
            actualAttributeValueCss_Color.add(mainMenuItemsLink.get(i).getCssValue("color"));
            actualAttributeValueCss_ColorBackroud.add(mainMenuItemsLink.get(i).getCssValue("background-color"));

            System.out.println(actualAttributeValueCss_Color.get(i));
            System.out.println(actualAttributeValueCss_ColorBackroud.get(i));

        }

    }

    public void getAttributeValueCssAfterHoverMouse_MainMenuItems() {


        Actions action = new Actions(driver);

        for (int i = 0; i < mainMenuItemsLink.size(); i++) {
            action.moveToElement(mainMenuItems.get(i)).build().perform();
            actualAttributeValueCss_Color.add(mainMenuItemsLink.get(i).getCssValue("color"));
            actualAttributeValueCss_ColorBackroud.add(mainMenuItemsLink.get(i).getCssValue("background-color"));

            System.out.println(actualAttributeValueCss_Color.get(i));
            System.out.println(actualAttributeValueCss_ColorBackroud.get(i));

        }
    }
}
