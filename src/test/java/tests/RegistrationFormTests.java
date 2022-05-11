package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        new RegistrationPage().setFirstName("Alex");
        new RegistrationPage().setLastName("Egorov");
        new RegistrationPage().setUserEmail("alex@egorov.com");
        new RegistrationPage().setGender("Other");
        new RegistrationPage().setNumber("1231231230");

        new RegistrationPage().setBirthday("2008", "July", "30");
        new RegistrationPage().setSubjects("Math");
        new RegistrationPage().setHobbies("Sports");
        new RegistrationPage().setPicture("img/1.png");
        new RegistrationPage().setAddress("Some address 1");
//        new RegistrationPage().setState("NCR");
//        new RegistrationPage().setCity("Noida");
        $("#submit").pressEnter();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        new RegistrationPage().checkForm("Student Name", "Alex Egorov");
        new RegistrationPage().checkForm("Student Email", "alex@egorov.com");
        new RegistrationPage().checkForm("Gender", "Other");
        new RegistrationPage().checkForm("Mobile", "1231231230");
        new RegistrationPage().checkForm("Date of Birth", "30 July,2008");
        new RegistrationPage().checkForm("Subjects", "Math");
        new RegistrationPage().checkForm("Hobbies", "Sports");
        new RegistrationPage().checkForm("Picture", "1.png");
        new RegistrationPage().checkForm("Address", "Some address 1");
//        new RegistrationPage().checkForm("State and City","NCR Noida");
    }
}