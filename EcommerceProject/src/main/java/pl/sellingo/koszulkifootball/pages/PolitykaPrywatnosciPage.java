package pl.sellingo.koszulkifootball.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.sellingo.koszulkifootball.fundamental.FundamentalTest;

public class PolitykaPrywatnosciPage extends FundamentalTest {

    WebDriverWait wait;

    public PolitykaPrywatnosciPage(){
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, 5);
    }

    public String getPageTitleOnPolitykaPrywatnosciPage(){
        return driver.getTitle();
    }
}
