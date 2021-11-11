package qa.guru.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private SelenideElement dateInput = $("#dateOfBirthInput"),
            monthInput = $(".react-datepicker__month-select"),
    yearInput = $(".react-datepicker__year-select");

    public void setDate(String day, String month, String year) {
        dateInput.click();
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();

    }
}
