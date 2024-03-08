import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.*;

import static com.codeborne.selenide.Selenide.open;
/*
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
*/

public class HomeworkL4_2 {
    @Test
    void HomeworkDragNDrop() {
        open("https://www.auchan.ru/favicon.ico\n");
        Cookie ck = new Cookie("qrator_jsr", "1704747931.258.5D7T4iF7k6CR8I9S-rrcb9b4h77glc43cbtb1lv3usfprnicd-00");
        WebDriverRunner.getWebDriver().manage().addCookie(ck);
        open("https://www.auchan.ru/");
        sleep(100000);

        open("http://www.test.com");
        $("#column-a").dragAndDropTo("#column-b");
        $(".column").shouldHave(text("B"));
    }


}

