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
RegistrationPage registrationPage = new RegistrationPage();
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        registrationPage.setFirstName("Alex");
        registrationPage.setLastName("Egorov");
        registrationPage.setUserEmail("alex@egorov.com");
        registrationPage.setGender("Other");
        registrationPage.setNumber("1231231230");

        registrationPage.setBirthday("2008", "July", "30");
        registrationPage.setSubjects("Math");
        registrationPage.setHobbies("Sports");
        registrationPage.setPicture("img/1.png");
        registrationPage.setAddress("Some address 1");
//        new RegistrationPage().setState("NCR");
//        new RegistrationPage().setCity("Noida");
        $("#submit").pressEnter();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        registrationPage.checkForm("Student Name", "Alex Egorov");
        registrationPage.checkForm("Student Email", "alex@egorov.com");
        registrationPage.checkForm("Gender", "Other");
        registrationPage.checkForm("Mobile", "1231231230");
        registrationPage.checkForm("Date of Birth", "30 July,2008");
        registrationPage.checkForm("Subjects", "Math");
        registrationPage.checkForm("Hobbies", "Sports");
        registrationPage.checkForm("Picture", "1.png");
        registrationPage.checkForm("Address", "Some address 1");
//        new RegistrationPage().checkForm("State and City","NCR Noida");
    }
}