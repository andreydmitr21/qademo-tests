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

    final private String
    nameFirst="Alex",
    nameLast="Egorov",
    email="alex@egorov.com",
    gender="Other",
    number="1231231230"
    ;
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successFillTest() {
        registrationPage.openPage()

                .setFirstName(nameFirst)
                .setLastName(nameLast)
                .setUserEmail(email)
                .setGender(gender)
                .setNumber(number)

                .setBirthday("2008", "July", "30")
                .setSubjects("Math")
                .setHobbies("Sports")
                .setPicture("img/1.png")
                .setAddress("Some address 1");
//        .setState("NCR")
//        .setCity("Noida")

        $("#submit").pressEnter();

        registrationPage.beforeCheckForm()
                .checkForm("Student Name", nameFirst+" "+nameLast)
                .checkForm("Student Email", email)
                .checkForm("Gender", gender)
                .checkForm("Mobile", number)
                .checkForm("Date of Birth", "30 July,2008")
                .checkForm("Subjects", "Math")
                .checkForm("Hobbies", "Sports")
                .checkForm("Picture", "1.png")
                .checkForm("Address", "Some address 1");
//      .checkForm("State and City","NCR Noida");
    }
}