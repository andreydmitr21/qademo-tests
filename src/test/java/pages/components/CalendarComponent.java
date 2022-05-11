package pages.components;

import com.codeborne.selenide.SelenideElement;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    final private SelenideElement
            calendarYearInput = $(".react-datepicker__year-select"),
            calendarMonthInput = $(".react-datepicker__month-select");

    public void setDate(String year,
                                    String month,
                                    String day) {

        calendarYearInput.selectOption(year);
        calendarMonthInput.selectOption(month);
        $(String.format("[aria-label*='%s %s']", month, day)).click();
        //return this;
    }
}
