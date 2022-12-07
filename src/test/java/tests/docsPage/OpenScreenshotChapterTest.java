package tests.docsPage;

import enums.pages.MainMenuPages;
import enums.pages.docs.LeftMenuChapters;
import org.testng.annotations.Test;
import pages.DocsPage;
import tests.BaseTest;

public class OpenScreenshotChapterTest extends BaseTest {

    @Test(description = "Check opening screenshot chapter in Docs page")
    void test() {
        mainPage.checkMainPageHeader();
        docsPage = mainPage.openPage(MainMenuPages.docs, DocsPage.class);
        docsPage.checkDocsPageHeader();
        docsPage.openChapter(LeftMenuChapters.screenshots);
    }
}
