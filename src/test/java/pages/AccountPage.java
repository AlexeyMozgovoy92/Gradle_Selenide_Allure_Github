package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class AccountPage extends BasePage {
    public SelenideElement userProfileName() {
        $(byClassName("dropdown-caret")).click();
        return $(byClassName("css-truncate-target"));
    }
}