package tests.mainPage;

import org.testng.annotations.Test;
import tests.BaseTest;

public class CheckMainPageTest extends BaseTest {

    @Test(description = "Check main page and default language")
    void test() {
        mainPage.checkMainPageHeader();
    }
}
