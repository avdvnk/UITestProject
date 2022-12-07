package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import enums.pages.docs.LeftMenuChapters;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Class contains locator and methods for Docs page
 */
public class DocsPage extends BasePage {
    // Docs left menu
    private final SelenideElement leftMenu = $(".left-menu");

    // Chapter head
    private final SelenideElement chapterHead = $("div.short.docs");

    // H3 header value
    private static final String headerName = "Documentation";

    @Step("Check docs page")
    public void checkDocsPageHeader() {
        startHeader
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(headerName));
    }

    @Step("Open chapter: {chapter}")
    public void openChapter(LeftMenuChapters chapter) {
        leftMenu
                .shouldBe(Condition.visible)
                .find(withTagAndText("a", chapter.getValue()))
                .click();
        chapterHead
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(chapter.getValue()));
    }
}
