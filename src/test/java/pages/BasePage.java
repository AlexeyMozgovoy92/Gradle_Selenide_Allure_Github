package pages;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;


public abstract class BasePage {
    public static String getTitle() {
        return title();
    }

    public void checkAlertContainsMessage(String value) {
        step("Displayed error message '" + value + "'", () -> {
            $(byClassName("js-flash-alert")).shouldHave(text(value));
        });
    }
}

