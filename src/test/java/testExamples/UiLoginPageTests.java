package testExamples;

import annotations.Layer;
import com.github.javafaker.Faker;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static helpers.DriverUtils.getConsoleLogs;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UiLoginPageTests extends TestBase {

    String passwordValue = projectPassword;
    String loginValue = projectLogin;


    @Test
    @Owner("Alexey")
    @Layer("web")
    @Tags({@Tag("web"), @Tag("smoke")})
    @DisplayName("Login page title should have header text")
    void checkTitleTest() {
        LoginPage loginPage = LoginPage.openPage();
        String expectedTitle = "Sign in to GitHub · GitHub";

        step("The title of the login page contains '" + expectedTitle + "'", () -> {
            assertThat(loginPage.getTitle()).isEqualTo(expectedTitle);
        });
    }

    @Test
    @Owner("Alexey")
    @Layer("web")
    @Tags({@Tag("web"), @Tag("smoke")})
    @DisplayName("Login page should not have console log errors")
    void consoleLogShouldNotHaveErrors() {
        LoginPage.openPage();

        step("Page Login should not have console log errors", () -> {
            String consoleLogs = getConsoleLogs();
            assertThat(consoleLogs).doesNotContain("SERVE");
        });
    }

//    @Test
//    @Owner("Alexey")
//    @Layer("web")
//    @Tags({@Tag("web"), @Tag("smoke")})
//    @DisplayName("Успешный вход в Систему")
//    void loginSuccessful() {
//        LoginPage loginPage = LoginPage.openPage();
//        loginPage.setLoginValue(loginValue);
//        loginPage.setPasswordValue(passwordValue);
//        loginPage.clickSignInButton();
//
//        String expectedUserName = "Япользователь для автотестов";
//        step("Профиль пользователя содержит '" + expectedUserName + "'", () -> {
//            FrteOibAdminPage frteOibAdminPage = new FrteOibAdminPage();
//            frteOibAdminPage.userProfileName().shouldHave(text(expectedUserName));
//        });
//    }

    @Test
    @Owner("Alexey")
    @Layer("web")
    @Tags({@Tag("web"), @Tag("smoke")})
    @DisplayName("Try to login to the System with an invalid data")
    void inputInvalidLoginShowErrorMessage() {
        Faker faker = new Faker();

        LoginPage loginPage = LoginPage.openPage();
        loginPage.checkLoginInputExists();
        loginPage.checkPasswordInputExists();
        loginPage.setLoginValue(faker.number().digits(3));
        loginPage.setPasswordValue(faker.number().digits(3));
        loginPage.clickSignInButton();
        loginPage.checkAlertContainsMessage("Incorrect username or password.");
        resetLoginAttemptsBeforeCapcha(loginPage);
    }

    @Test
    @Owner("Alexey")
    @Layer("web")
    @Tags({@Tag("web"), @Tag("smoke")})
    @DisplayName("Try to login to the System without specifying a password")
    void passwordCouldNotBeEmpty() {
        Faker faker = new Faker();

        LoginPage loginPage = LoginPage.openPage();
        loginPage.checkLoginInputExists();
        loginPage.checkPasswordInputExists();
        loginPage.setLoginValue(faker.number().digits(3));
        loginPage.clickSignInButton();
        loginPage.checkAlertContainsMessage("Incorrect username or password.");
        resetLoginAttemptsBeforeCapcha(loginPage);
    }

    @Test
    @Owner("Alexey")
    @Layer("web")
    @Tags({@Tag("web"), @Tag("smoke")})
    @DisplayName("Try to login to the System without any data")
    void fieldsCouldNotBeEmpty() {
        LoginPage loginPage = LoginPage.openPage();
        loginPage.checkLoginInputExists();
        loginPage.checkPasswordInputExists();
        loginPage.clickSignInButton();
        loginPage.checkAlertContainsMessage("Incorrect username or password.");
        resetLoginAttemptsBeforeCapcha(loginPage);
    }
    @Test
    @Owner("Alexey")
    @Layer("web")
    @Tags({@Tag("web"), @Tag("smoke")})
    @DisplayName("Go to page 'Forgot password'")
    void checkOpenForgotPasswordPage() {
        LoginPage loginPage = LoginPage.openPage();
        loginPage.clickForgotPasswordButton();

    }

    @Step("Reset the number of login attempts before capcha")
    private void resetLoginAttemptsBeforeCapcha(LoginPage loginPage) {
        loginPage.setLoginValue(loginValue);
        loginPage.setPasswordValue(passwordValue);
        loginPage.clickSignInButton();
    }
}