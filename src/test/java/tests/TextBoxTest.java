package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
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


        //submit
        $("button#submit.btn.btn-primary").click();



        // test after submit
//        $("#output #name").shouldHave(text("Alex"));
//        $("#output #email").shouldHave(text("alex@gmail.com"));
//        $("#output #currentAddress").shouldHave(text("Some address"));
//        $("#output #permanentAddress").shouldHave(text("Perm address"));




    }
}
