package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize= "4320x7680";
    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");

        $(".main-header").shouldHave(text("Practice Form"));

        $("input#firstName.mr-sm-2.form-control").setValue("Alex");
        $("input#lastName.mr-sm-2.form-control").setValue("Petrov");
        $("input#userEmail.mr-sm-2.form-control").setValue("Petrov@email.com");

        // gender
        $("label[for=gender-radio-1]").click();

        $("input#userNumber.mr-sm-2.form-control").setValue("89999999999");

        // birthday
//        $("input#dateOfBirthInput.form-control").setSelected(true);
//        $("input#dateOfBirthInput.form-control").setValue("11 Nov 1972");
        $("input#dateOfBirthInput.form-control").shouldBe(visible).click();
        $("select.react-datepicker__month-select").shouldBe(visible).click();
        $("select.react-datepicker__month-select").selectOption(2);
       // $("option[value=2]").click();

        $("input#subjectsInput").setValue("Mathematic");

        //submit
        $("button#submit.btn.btn-primary").click();



        // test after submit
//        $("#output #name").shouldHave(text("Alex"));
//        $("#output #email").shouldHave(text("alex@gmail.com"));
//        $("#output #currentAddress").shouldHave(text("Some address"));
//        $("#output #permanentAddress").shouldHave(text("Perm address"));




    }
}
