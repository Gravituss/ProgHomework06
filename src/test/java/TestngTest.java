import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.BaseRozetkaPage;
import pages.SearchResultsPage;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.testng.Assert.assertTrue;
import static pages.SearchResultsPage.PRELOADER_XPATH;

public class TestngTest extends BaseTest {

    WebDriverWait wait;

    @Test
    public void test() {
        wait = new WebDriverWait(driver, 20);
        BaseRozetkaPage basePage = new BaseRozetkaPage(driver);
        waitFor(basePage.getDismissBtn());
        basePage.getDismissBtn().click();
        waitFor( basePage.getFooterCopyrightText());

        basePage.getSearchField().sendKeys("hdd");
        basePage.getCategoriesDropdown().click();
        basePage.getCategoryPcPartsItem().click();
        basePage.getSearchField().submit();

        SearchResultsPage resultsPage = new SearchResultsPage(driver);

        waitFor(resultsPage.getPriceMinField());
        clearSymbols(resultsPage.getPriceMinField(), 8);
        resultsPage.getPriceMinField().sendKeys(PRICEMIN);
        clearSymbols(resultsPage.getPriceMaxField(), 8);
        resultsPage.getPriceMaxField().sendKeys(PRICEMAX);

        resultsPage.getPriceSubmitBtn().click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PRELOADER_XPATH)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PRELOADER_XPATH)));
        System.out.println("Gif is caught");



    }

    public void clearSymbols (WebElement element, int times){
        for(int i = 0; i < times; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void waitFor(WebElement element){
        wait = new WebDriverWait(driver,  Long.valueOf(TIMEOUT).longValue());
        wait.until(ExpectedConditions.visibilityOf(element));

    }
}
