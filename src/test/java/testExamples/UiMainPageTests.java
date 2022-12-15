package testExamples;

import com.codeborne.selenide.Condition;
import helpers.DriverUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class UiMainPageTests extends TestBase{


    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://github.com/'", () ->
                open("https://github.com/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }

    @Test
    @DisplayName("Search field should work as expected")
    public void githubSearchTest() {
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("AlexeyMozgovoy92");
        $(".header-search-input").submit();
        $(withText("Alexey")).should(Condition.exist);
    }


}
