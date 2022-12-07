package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class MainPage extends BasePage {
    // All headers on main page
    ElementsCollection h3Headers = $$("h3");

    // First header name of main page
    private static final String firstHeaderName = "What is Selenide?";

    @Step("Check main page h3 header")
    public void checkMainPageHeader() {
        h3Headers
                .shouldBe(CollectionCondition.sizeGreaterThan(1))
                .first()
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(firstHeaderName));
    }
}
