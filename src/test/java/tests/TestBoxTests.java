package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestBoxTests {


    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.pageLoadTimeout = 120_000;
        holdBrowserOpen = true;
    }

    @Test
    void checkFullFormTest() {
        open("");
        $$(".card-body").findBy(text("Forms")).click();
        $$(".router-link").findBy(text("Practice Form")).click();
        $("[id = firstName]").setValue("Alex");
        $("[id = lastName]").setValue("Ivanov");
        $("[id = userEmail]").setValue("AlexIvanov@mail.ru");
        $("label[for='gender-radio-1']").click();
        $("[id = userNumber]").setValue("8900562321");
        $("[id =dateOfBirthInput]").click();
        $(".react-datepicker__month-select").click();
        $(byText("June")).click();
        $(".react-datepicker__year-select").click();
        $(byText("2000")).click();
        $(".react-datepicker__month").$(byText("14")).click();
        $("[id=subjectsInput").setValue("o");
        $(byText("Commerce")).click();
        $("[id =hobbies-checkbox-2]").click();
        $("[id =uploadPicture]").uploadFile(new File("src/test/resources/file.png"));
        $("[id = currentAddress]").setValue("First street 1");
        $("[id = state]").scrollTo().click(); //тест падал из-за невозможности кликнуть по элементу, рекламу я не видела, поэтому сделала скролл, не знаю насколько это правильно
        $("[id =react-select-3-input]").click();
        $(byText("Uttar Pradesh")).click();
        $("[id =react-select-4-input]").click();
        $(byText("Lucknow")).click();
        $("#submit").click();


        //Selenide.executeJavaScript("document.querySelector('.ad-container').remove();"); он был нужен, когда пыталась решить проблему с недоступностью элемента


        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Alex Ivanov"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("AlexIvanov@mail.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("8900562321"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("14 June,2000"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Commerce"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("file.png"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("First street 1"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Uttar Pradesh Lucknow"));


    }
}

