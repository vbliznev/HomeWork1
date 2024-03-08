import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeworkL7 {
    //Странный тест. Нужно сткролить чтобы все работало. Нужно останавливать загрузку страницы. Нужно менять
    //размер экрана, т.к. мешает footer
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "750x1000";
    }
    @Timeout(100000)
    @Test
    void HomeworkRegistrationForm(){
        Faker faker = new Faker(new Locale("ru"));
        open("http://demoqa.com/automation-practice-form");
        $("#firstName").setValue(faker.name().firstName());
        $("#lastName").setValue(faker.name().lastName());
        $("#userEmail").setValue(faker.internet().emailAddress());
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue(faker.phoneNumber().cellPhone());
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__day--013").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/sampleFile.jpeg");
        $("#currentAddress").setValue(faker.address().streetAddress());
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $(byText("Submit")).click();
        sleep(10000);


    }
}
