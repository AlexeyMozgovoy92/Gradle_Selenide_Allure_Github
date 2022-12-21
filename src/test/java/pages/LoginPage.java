package pages;

import com.codeborne.selenide.SelenideElement;
import config.Project;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {

    @Step("Open Sign in page")
    public static LoginPage openPage() {
        open(Project.config.baseUrl() + "login/");
        return new LoginPage();
    }

    @Step("Open page have field 'Username or email address'")
    public void checkLoginInputExists() {
        $("#login_field").shouldBe(visible);
    }

    @Step("Fill the field 'Username or email address'")
    public void setLoginValue(String loginValue) {
        SelenideElement login = $("#login_field");
        clearInputValue(login);
        login.setValue(loginValue);
    }
    @Step("Open page have field 'Password'")
    public void checkPasswordInputExists() {
        $("#password").shouldBe(visible);
    }

    @Step("Fill the field 'Password'")
    public void setPasswordValue(String passwordValue) {
        SelenideElement password = $("#password");
        clearInputValue(password);
        password.setValue(passwordValue);
    }

    @Step("Push the button 'Sign in'")
    public void clickSignInButton() {
        $("[name='commit']").click();
    }

    @Step("Push the button 'Forgot password?'")
    public void clickForgotPasswordButton() {
        $(byClassName("label-link")).click();
    }
    private void clearInputValue(SelenideElement element) {
        element.sendKeys(Keys.CONTROL + "A");
        element.sendKeys(Keys.BACK_SPACE);
    }
}
