package pages;

import com.github.javafaker.Faker;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    Faker faker = new Faker(new Locale("ru"));

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String addres = faker.address().streetAddress();

    public RegistrationPage openPage(String url) {
        open(url);
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName() {
        $("#firstName").setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName() {
        $("#lastName").setValue(lastName);
        return this;
    }

    public void verifyResults(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }

    public RegistrationPage setEmail() {
        $("#userEmail").setValue(email);
        return this;
    }

    public RegistrationPage setPhoneNumber() {
        $("#userNumber").setValue("9778930552");
        return this;
    }

    public RegistrationPage setBirthday(String jear, String month, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(jear);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day--0" + day).click();
        return this;
    }

    public RegistrationPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setHobby() {
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        return this;
    }

    public RegistrationPage setAddresAndRegion() {
        $("#currentAddress").setValue(addres);
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        return this;
    }

    public RegistrationPage uploadPicture() {
        $("#uploadPicture").uploadFromClasspath("img/sampleFile.jpeg");
        return this;
    }

    public RegistrationPage clickSubmit() {
        $(("#submit")).click();
        return this;
    }

}
