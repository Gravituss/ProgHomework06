import org.testng.annotations.Test;
import pages.BaseRozetkaPage;

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
        assertTrue(driver.getPageSource().contains("найдено более"));

    }
}
