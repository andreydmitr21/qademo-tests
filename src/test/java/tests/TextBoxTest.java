package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

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

    File file = new File("src/test/resources/pik.png");

    @BeforeAll
    static void beforeAll() {
        //System.out.println("beforeAll");
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void successFillTest() {
        open("/automation-practice-form");

        $(".main-header").shouldHave(text("Practice Form"));

        actions().moveToElement($("input#firstName.mr-sm-2.form-control")).
                sendKeys(Keys.chord(Keys.CONTROL, "-")).perform();
        actions().moveToElement($("input#firstName.mr-sm-2.form-control")).
                sendKeys(Keys.chord(Keys.CONTROL, "-")).perform();
//        actions().//se moveToElement($("body")).
//                sendKeys(Keys.chord(Keys.CONTROL, "-")).perform();
//        actions().//se moveToElement($("body")).
//                sendKeys(Keys.chord(Keys.CONTROL, "-")).perform();

        //Actions builder = new Actions(driver);
        //builder.
        //$("body").sendKeys(Keys.chord(Keys.CONTROL, "-"));
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

        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").scrollTo();
        $("#currentAddress").setValue(address);

        $("#state").click();
        $(byText(state)).click();

        $("#city").click();
        $(byText(city)).click();

        $("#submit").scrollTo();
        $("#submit").click();



        // test after submit
        $("#output #name").shouldHave(text("Alex"));
//        $("#output #email").shouldHave(text("alex@gmail.com"));
//        $("#output #currentAddress").shouldHave(text("Some address"));
//        $("#output #permanentAddress").shouldHave(text("Perm address"));


    }
}
