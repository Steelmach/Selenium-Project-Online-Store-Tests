package pl.sellingo.koszulkifootball.fundamental;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class FundamentalTest {

    public static WebDriver driver;
    public static Properties prop;


    public FundamentalTest() {

        try {
            prop = new Properties();
            FileInputStream propertyFile = new FileInputStream("C:\\Users\\tomas\\IdeaProjects\\EcommerceProject\\src\\" +
                                                            "main\\java\\pl\\sellingo\\koszulkifootball\\config\\config.property");
            prop.load(propertyFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static void initial(){
            String browserName = prop.getProperty("browser");
            String urlAddress = prop.getProperty("url");

                if(browserName.equals("chrome")){
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\tomas\\Documents\\Selenium Project Store\\tools\\selenium\\chromedriver.exe");
                    driver = new ChromeDriver();
                }
                else if (browserName.equals("firefox")){
                    System.setProperty("webdriver.gecko.driver", "C:\\Users\\tomas\\Documents\\Selenium Project Store\\tools\\selenium\\geckodriver.exe");
                    driver = new FirefoxDriver();
                }
                else if (browserName.equals("ie")){
                    System.setProperty("webdriver.ie.driver", "C:\\Users\\tomas\\Documents\\Selenium Project Store\\tools\\selenium\\IEDriverServer.exe");
                    driver = new InternetExplorerDriver();
                }




            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            // driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            // for tests driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

            driver.get(urlAddress);
    }

}

