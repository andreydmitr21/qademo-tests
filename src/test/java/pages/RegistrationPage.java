package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private CalendarComponent calendarCompoent= new CalendarComponent();
    // locators
    final private SelenideElement
            hederTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            numberInput = $("#userNumber"),

    birthdayYearInput = $(".react-datepicker__year-select"),
            birthdayMonthInput = $(".react-datepicker__month-select"),
            birthdayInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            stateWrapInput = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            cityWrapInput = $("#stateCity-wrapper"),

    resultsTable = $(".table-responsive");

    // actions

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        hederTitle.shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }


    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setNumber(String number) {
        numberInput.setValue(number);
        return this;
    }

    public RegistrationPage setBirthday(String year,
                                        String month,
                                        String day) {
        birthdayInput.click();
        calendarCompoent.setDate(year,month,day);
        return this;
    }

    public RegistrationPage setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        hobbiesInput.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage setPicture(String file) {
        pictureInput.uploadFromClasspath(file);
        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        stateInput.scrollTo().click();
        stateWrapInput.$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        cityInput.scrollTo().click();
        cityWrapInput.$(byText(city)).click();
        return this;
    }


    public RegistrationPage checkForm(String field, String value) {
        resultsTable.$(byText(field)).parent().shouldHave(text(value));
        return this;
    }

    public RegistrationPage beforeCheckForm() {
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        return this;
    }

}
