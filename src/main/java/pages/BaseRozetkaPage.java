package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BaseRozetkaPage {
    private WebDriver driver;

    public BaseRozetkaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getDismissBtn() {
        return dismissBtn;
    }
    public WebElement getSearchField(){
        return searchField;
    }

    public WebElement getCategoriesDropdown() {
        return categoriesDropdown;
    }

    public WebElement getCategoryPcPartsItem() { return categoryPcPartsItem;  }

    public WebElement getFooterCopyrightText() {return footerCopyrightText;}

    @FindBy(xpath = "//div[contains(@class,'notificationPanel') and text()[contains(.,'Отказаться')]]")
    private WebElement dismissBtn;
    @FindBy (xpath = "//div[@class = 'rz-header-search-inner']//input[@name = 'text']")
    private WebElement searchField;
    @FindBy (xpath = "//div[@class = 'rz-header-search-category']//span[@name = 'rz-search-category-value']")
    private WebElement categoriesDropdown;

    @FindBy (xpath = "//div[@class = 'rz-header-search-category']//a[contains(@class," +
            "'rz-header-search-category') and text()[contains(.,'Компьютерные ком')]]")
    private WebElement categoryPcPartsItem;

    @FindBy (xpath = ".//*[@id='body-footer']//div[@class='copy']")
    private WebElement footerCopyrightText;
}
