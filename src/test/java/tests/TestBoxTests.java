package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.testData.TestData.*;

public class TestBoxTests {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.pageLoadTimeout = 50_000;
    }

    @AfterEach
    void closeBrowser() {
        closeWebDriver();
    }

    @Test
    void checkFullFormTest() {
        open("");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("June")).click();
        $(".react-datepicker__year-select").click();
        $(byText("2000")).click();
        $(".react-datepicker__month").$(byText("14")).click();
        $("#subjectsInput").setValue("o");
        $(byText("Commerce")).click();
        $("#hobbies-checkbox-2").click();
        $("#uploadPicture").uploadFromClasspath("file.png");
        $("#currentAddress").setValue(currentAddress);
        $("#state").scrollTo().click();
        $("#react-select-3-input").click();
        $(byText("Uttar Pradesh")).click();
        $("#react-select-4-input").click();
        $(byText("Lucknow")).click();
        $("#submit").click();

        //Selenide.executeJavaScript("document.querySelector('.ad-container').remove();"); он был нужен, когда пыталась решить проблему с недоступностью элемента

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("14 June,2000"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Commerce"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("file.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Lucknow"));

    }

    @Test
    void checkMustHaveFormTest() {
        open("");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue(userNumber);
        $("#submit").scrollTo().click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));

    }

    @Test
    void negativeEmptyfieldTest() {
        open("");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();
        $("#firstName").setValue("Alex");
        $("#userNumber").setValue("8900562323");
        $("#submit").scrollTo().click();

        $("#lastName").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        $("#genterWrapper").$(byText("Male")).shouldHave(cssValue("color", "rgba(220, 53, 69, 1)"));

    }

    @Test
    void negativeWrongEmailTest() {
        open("");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail+"889");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue(userNumber);
        $("#submit").scrollTo().click();

        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }

    @Test
    void negativeWrongNumberTest() {
        open("");
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("8900");
        $("#submit").scrollTo().click();

        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

    }
}

