package pl.sellingo.koszulkifootball.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.sellingo.koszulkifootball.fundamental.FundamentalTest;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class RegulaminPage extends FundamentalTest {

    WebDriverWait wait;


    public RegulaminPage() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);

    }


    public String getTitleOnRegulaminPage() {
        String title =driver.getTitle();
        return title;
    }


}
