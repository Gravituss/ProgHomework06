package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchResultsPage {

    private WebDriver driver;
    public final String PRELOADER_XPATH = ".//img[contains(@src, 'check-ajax.gif')]";


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
    public WebElement getPreloaderGif() { return preloaderGif; }

    @FindBy(id = "price[min]")
    private WebElement priceMinField;
    @FindBy(id = "price[max]")
    private WebElement priceMaxField;
    @FindBy(xpath = ".//button[@id='submitprice']")
    private WebElement priceSubmitBtn;

    @FindBy(xpath = PRELOADER_XPATH)
    private WebElement preloaderGif;




}
