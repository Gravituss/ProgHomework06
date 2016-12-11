package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchResultsPage {

    private WebDriver driver;
//    public final static String PRELOADER_XPATH = ".//img[contains(@class,'proces') " +
//            "and contains(@src,'check-ajax.gif')]";

    public final static String PRELOADER_XPATH = ".//*[@id='parameters-filter-form']/div/div[2]/img";

    public SearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getPriceMinField() {
        return priceMinField;
    }
    public WebElement getPriceMaxField() {
        return priceMaxField;
    }
    public WebElement getPriceSubmitBtn() {
        return priceSubmitBtn;
    }

    @FindBy(id = "price[min]")
    private WebElement priceMinField;
    @FindBy(id = "price[max]")
    private WebElement priceMaxField;
    @FindBy(xpath = ".//button[@id='submitprice']")
    private WebElement priceSubmitBtn;

}
