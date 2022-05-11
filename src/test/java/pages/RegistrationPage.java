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
    SelenideElement userNumberInput = $("#userNumber");

    SelenideElement birthdayYearInput = $(".react-datepicker__year-select");
    SelenideElement birthdayMonthInput = $(".react-datepicker__month-select");
    SelenideElement birthdayInput = $("#dateOfBirthInput");







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
    public void setUserNumber(String number) {
        userNumberInput.setValue(number);
    }
    public void setBirthday(String year,
                            String month,
                            String day) {
        birthdayInput.click();
        birthdayYearInput.selectOption(year);
        birthdayMonthInput.selectOption(month);
        $(String.format("[aria-label*='%s %s']",month,day)).click();
    }










    public void checkForm(String field, String value) {
        resultsTable.$(byText(field)).parent().shouldHave(text(value));
    }

}
