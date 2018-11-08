package pl.sellingo.koszulkifootball.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.sellingo.koszulkifootball.fundamental.FundamentalTest;

public class ReklamacjePage extends FundamentalTest {

    WebDriverWait wait;

        public ReklamacjePage(){
            PageFactory.initElements(driver, this);
            wait = new WebDriverWait(driver, 5);

        }


    public String getTitleOnReklamacje() {
        String title =driver.getTitle();
        return title;
    }
}
