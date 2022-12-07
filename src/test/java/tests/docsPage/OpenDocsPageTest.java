package tests.docsPage;

import enums.pages.MainMenuPages;
import org.testng.annotations.Test;
import pages.DocsPage;
import tests.BaseTest;

public class OpenDocsPageTest extends BaseTest {

    @Test(description = "Open Docs page")
    public void test() {
        mainPage.checkMainPageHeader();
        docsPage = mainPage.openPage(MainMenuPages.docs, DocsPage.class);
        docsPage.checkDocsPageHeader();
    }
}
