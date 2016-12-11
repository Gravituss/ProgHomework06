
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Config;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public final String URL = Config.getProperty("baseUrl");
    public final String BROWSER = Config.getProperty("driver");
    public final String TIMEOUT = Config.getProperty("timeout");
    public final String PRICEMIN = Config.getProperty("priceMin");
    public final String PRICEMAX = Config.getProperty("priceMax");
    WebDriver driver;

    public WebDriver getDriver () {
        if (BROWSER.equals("firefox")) return new FirefoxDriver();
        if (BROWSER.equals("chrome")) return new ChromeDriver();
        return new ChromeDriver();
    }



    @BeforeMethod
    public void preConfig () {
        System.setProperty("webdriver.gecko.driver", "C:\\pr\\gecko\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\pr\\cd\\chromedriver.exe");
        driver = getDriver();

        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown () {
        driver.quit();
    }
}
