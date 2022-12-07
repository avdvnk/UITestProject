package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.pages.MainMenuPages;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

/**
 * Base Selenide page with common methods and locators
 */
public class BasePage {

    // Main menu pages
    protected SelenideElement mainMenuPages = $(".main-menu-pages");

    // h3 first header
    protected SelenideElement startHeader = $("h3");

    @Step("Switch to page: {value}")
    public <T> T openPage(MainMenuPages page, Class<T> returnPage) {
        mainMenuPages
                .shouldBe(Condition.visible)
                .find(byTagAndText("a", page.getValue()))
                .shouldBe(Condition.visible)
                .click();
        return Selenide.page(returnPage);
    }
}