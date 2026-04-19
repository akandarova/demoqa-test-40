package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private SelenideElement monthCalendar = $(".react-datepicker__month-select");
    private SelenideElement yearCalendar = $(".react-datepicker__year-select");
    private SelenideElement dayCalendar = $(".react-datepicker__day--0");

    public void setDate(String day, String month, String year){
        monthCalendar.$(byText(month)).click();
        yearCalendar.$(byText(year)).click();
        $(".react-datepicker__day--0" + day +":not(.react-datepicker__month)").click();
    }

}
