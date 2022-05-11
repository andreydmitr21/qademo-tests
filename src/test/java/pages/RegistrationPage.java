package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    // locators
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement userEmailInput = $("#userEmail");
    SelenideElement genderInput = $("#genterWrapper");
    SelenideElement numberInput = $("#userNumber");

    SelenideElement birthdayYearInput = $(".react-datepicker__year-select");
    SelenideElement birthdayMonthInput = $(".react-datepicker__month-select");
    SelenideElement birthdayInput = $("#dateOfBirthInput");
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement hobbiesInput = $("#hobbiesWrapper");
    SelenideElement pictureInput = $("#uploadPicture");
    SelenideElement addressInput =  $("#currentAddress");
    SelenideElement stateInput =  $("#state");
    SelenideElement stateWrapInput =  $("#stateCity-wrapper");
    SelenideElement cityInput =  $("#city");
    SelenideElement cityWrapInput =  $("#stateCity-wrapper");







    //
    SelenideElement resultsTable =  $(".table-responsive");

    // actions
    public void setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }

    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }

    public void setUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);
    }

    public void setGender(String gender) {
        genderInput.$(byText(gender)).click();
    }
    public void setNumber(String number) {
       numberInput.setValue(number);
    }
    public void setBirthday(String year,
                            String month,
                            String day) {
        birthdayInput.click();
        birthdayYearInput.selectOption(year);
        birthdayMonthInput.selectOption(month);
        $(String.format("[aria-label*='%s %s']",month,day)).click();
    }

    public void setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
    }

    public void setHobbies(String hobbies) {
        hobbiesInput.$(byText(hobbies)).click();
    }

    public void setPicture(String file) {
        pictureInput.uploadFromClasspath(file);
    }
    public void setAddress(String address) {
       addressInput.setValue(address);
    }

    public void setState(String state) {
        stateInput.scrollTo().click();
        stateWrapInput.$(byText(state)).click();
    }
    public void setCity(String city) {
        cityInput.scrollTo().click();
        cityWrapInput.$(byText(city)).click();
    }





    public void checkForm(String field, String value) {
        resultsTable.$(byText(field)).parent().shouldHave(text(value));
    }

}
