import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import pages.RegistrationPage;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeworkL10 extends TestBase{
    @DisplayName("Проверка типовой страницы регистрации")
    @Test
    void HomeworkRegistrationForm(){
        registrationPage.openPage("http://demoqa.com/automation-practice-form")
                        .setFirstName()
                        .setLastName()
                        .setEmail()
                        .setGender("Other")
                        .setPhoneNumber()
                        .setBirthday("1998", "July","13")
                        .setHobby()
                        .setAddresAndRegion()
                        .uploadPicture()
                        .clickSubmit();
        registrationPage.verifyResults("Student Name", registrationPage.firstName + " " + registrationPage.lastName);
        registrationPage.verifyResults("Student Email", registrationPage.email);
        registrationPage.verifyResults("Gender", "Other" ); //todo
        registrationPage.verifyResults("Mobile", "9778930552" );  //todo
        registrationPage.verifyResults("Date of Birth", "13 July,1998" );  //todo
        registrationPage.verifyResults("Subjects", "Maths" );  //todo
        registrationPage.verifyResults("Hobbies", "Sports" );  //todo
        registrationPage.verifyResults("Address", registrationPage.addres );
        registrationPage.verifyResults("State and City", "NCR Delhi" );  //todo



    }
}