package TestExamples;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UITests extends TestBase{
    @Test
    public void testGithubIssueSearch() {
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("AlexeyMozgovoy92");
        $(".header-search-input").submit();
        $(withText("Alexey")).should(Condition.exist);
    }

}
