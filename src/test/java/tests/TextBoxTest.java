package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {
    String firstName="Alex";
    String lastName="Popov";
    String email="Alex@mail.com";
    String number="89999999999";
    String gender="Male";
    String birthdayYear="2014";
    String birthdayMonth="January";
    String birthdayDay="29";

    String subjects="Maths Physics";
    String hobby="Reading";
    String address="Alex st Msk";
    String state="Haryana";
    String city="Panipat";


    @BeforeAll
    static void beforeAll() {
        //System.out.println("beforeAll");
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "4320x7680";
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");

        $(".main-header").shouldHave(text("Practice Form"));

        //System.out.println(String.format("[class^='react-datepicker__day '][aria-label*='%s %s']",
        //        birthdayMonth, birthdayDay));
        //System.exit(0);
        $("input#firstName.mr-sm-2.form-control").setValue(firstName);
        $("input#lastName.mr-sm-2.form-control").setValue(lastName);
        $("input#userEmail.mr-sm-2.form-control").setValue(email);
        $(byText(gender)).click();
        // gender
        //$("label[for=gender-radio-1]").click();

        $("input#userNumber.mr-sm-2.form-control").setValue(number);

        // birthday
        $("input#dateOfBirthInput.form-control").click();
        // year
        $(".react-datepicker__year-select").selectOption(birthdayYear);
        $(".react-datepicker__month-select").selectOption(birthdayMonth);
        $(String.format("[class^='react-datepicker__day '][aria-label*='%s %s']",
                birthdayMonth, birthdayDay)).click();

        $("input#subjectsInput").setValue(subjects);

        $("#hobbiesWrapper").click();
        $(byText(hobby)).click();
        $("input#dateOfBirthInput.form-control").shouldBe(visible).click();
        //submit
        $("button#submit.btn.btn-primary").click();


        // test after submit
//        $("#output #name").shouldHave(text("Alex"));
//        $("#output #email").shouldHave(text("alex@gmail.com"));
//        $("#output #currentAddress").shouldHave(text("Some address"));
//        $("#output #permanentAddress").shouldHave(text("Perm address"));


    }
}
