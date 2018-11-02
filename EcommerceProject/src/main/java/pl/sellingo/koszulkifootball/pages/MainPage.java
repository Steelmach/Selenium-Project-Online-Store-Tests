package pl.sellingo.koszulkifootball.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.sellingo.koszulkifootball.fundamental.FundamentalTest;

import java.util.ArrayList;
import java.util.List;

public class MainPage extends FundamentalTest {


    //WebElements on the page
    @FindBy(id="MainMenu")
    WebElement mainMenu;

    @FindBy(css="#MainMenu>ul>li")
    List<WebElement> mainMenuItems;

    @FindBy(css="#MainMenu>ul>li>a")
    List<WebElement> mainMenuItemsLink;

    @FindBy(css="menu#MainMenu>ul>li:nth-of-type(4)>a")
    WebElement menuContactLink;

    //Elements
    public ArrayList correctMainMenuItemsNameList = new ArrayList();
    public ArrayList actualMainMenuItemsNameList =  new ArrayList();
    public  ArrayList correctPageTitle = new ArrayList();
    public ArrayList actualMainMenuItemsLinkList =  new ArrayList();






    //Initializing the page object
    public MainPage(){
        PageFactory.initElements(driver,this);

    }




    //Actions
    public String getTitleOnMainPage()
    {
        return driver.getTitle();
    }



    public int getMainMenuItemsSize()
    {
        return mainMenuItems.size();
    }



    public void mainMenuItemsName(){

        correctMainMenuItemsNameList.add("Aktualności");
        correctMainMenuItemsNameList.add("Opinie o sklepie");
        correctMainMenuItemsNameList.add("Reklamacje");
        correctMainMenuItemsNameList.add("Kontakt");

        int i=0;

        for(WebElement item : mainMenuItems)
        {

            actualMainMenuItemsNameList.add(item.getText());
            i++;
        }

    }


    public void mainMenuTransition(){
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

    public ContactPage clickMainMenuContactLink(){

        menuContactLink.click();
        return new ContactPage();
    }

    public boolean mainMenuContactLink(){
        return menuContactLink.isDisplayed();
    }
}
