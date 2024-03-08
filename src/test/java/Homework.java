import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Homework {
    @Test
    void HomeworkOpenPageSelenide() {
        open("http://github.com");
        $(".header-search-button").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $(byText("selenide/")).click();
        $("#wiki-tab").click();
        $(byText("Soft assertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").shouldBe(visible);
        sleep(5000);
    }
}
