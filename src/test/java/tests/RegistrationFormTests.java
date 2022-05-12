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
            nameFirst = "Alex",
            nameLast = "Egorov",
            email = "alex@egorov.com",
            gender = "Other",
            number = "1231231230",
            year = "2008",
            month = "July",
            day = "30",
            subjects = "Math",
            hobbies = "Sports",
            picture = "1.png",
            picturePath = "img/",
            address = "Some address 1";

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

                .setBirthday(year, month, day)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(picturePath + picture)
                .setAddress(address)
                //        .setState("NCR")
//        .setCity("Noida")
                .doSubmit();


        registrationPage.beforeCheckForm()
                .checkForm("Student Name", nameFirst + " " + nameLast)
                .checkForm("Student Email", email)
                .checkForm("Gender", gender)
                .checkForm("Mobile", number)
                .checkForm("Date of Birth", day+" "+month+","+year)
                .checkForm("Subjects", subjects)
                .checkForm("Hobbies", hobbies)
                .checkForm("Picture", picture)
                .checkForm("Address", address);
//      .checkForm("State and City","NCR Noida");
    }
}