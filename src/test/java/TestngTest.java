import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.BaseRozetkaPage;
import pages.SearchResultsPage;

import static org.testng.Assert.assertTrue;

public class TestngTest extends BaseTest {



    @Test
    public void test() {

        BaseRozetkaPage basePage = new BaseRozetkaPage(driver);
        basePage.getDismissBtn().click();

        basePage.getSearchField().sendKeys("Мяч");
        basePage.getCategoriesDropdown().click();
        basePage.getCategorySportItem().click();
        basePage.getSearchField().submit();


        SearchResultsPage resultsPage = new SearchResultsPage(driver);

        clearSymbols(resultsPage.getPriceMinField(), 8);
        resultsPage.getPriceMinField().sendKeys(PRICEMIN);
        clearSymbols(resultsPage.getPriceMaxField(), 8);
        resultsPage.getPriceMaxField().sendKeys(PRICEMAX);
        resultsPage.getPriceSubmitBtn().click();

    }

    public void clearSymbols (WebElement element, int times){
        for(int i = 0; i < times; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }
}
