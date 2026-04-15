package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.testData.TestData.*;

public class RegistrationPage {
    
    CalendarComponent calendar = new CalendarComponent();

    private ElementsCollection cardBody = $$(".card-body");
    private ElementsCollection routerLink = $$(".router-link");
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput =  $("#userEmail");
    private SelenideElement genderContainer =  $("#genterWrapper");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement userSubjectInput =  $("#subjectsInput");
    private SelenideElement hobbiesContainer =   $("#hobbiesWrapper");
    private SelenideElement userFileInput =  $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement stateSelect =  $("#state");
    private SelenideElement citySelect =  $("#city");
    private SelenideElement submitButtom = $("#submit");
    private SelenideElement dateOfBirth = $("#dateOfBirthInput");




    // Actions
    public RegistrationPage openPage(){
        open("");
        cardBody.findBy(text("Forms")).click();
        routerLink.findBy(text("Practice Form")).click();

        return this;
    }

    public RegistrationPage removeBanners(){
        executeJavaScript("""
                document.getElementById('fixedban')?.remove();
                document.querySelector('footer')?.remove();
                """);

        return this;
    }

    public RegistrationPage typeFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationPage typeLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationPage typeUserEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }
    public RegistrationPage setGender(String value){
        genderContainer.$(byText(value)).click();

        return this;
    }
    public RegistrationPage typeSubject(String value){
        userSubjectInput.setValue(value).pressEnter();

        return this;
    }
    public RegistrationPage setHobbies(String value){
        hobbiesContainer.$(byText(value)).click();

        return this;
    }
    public RegistrationPage typeFile(String value){
        userFileInput.uploadFromClasspath(userFile);

        return this;
    }
    public RegistrationPage typeCurrentAddress(String value){
        currentAddressInput.setValue(value);

        return this;
    }
    public RegistrationPage setState(String value){
        stateSelect.click();
        stateSelect.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setCity(String value){
        citySelect.click();
        citySelect.$(byText(value)).click();

        return this;
    }
    public RegistrationPage setStateAndCity (String state, String city){
        setState(state);
        setCity(city);

        return this;
    }
    public RegistrationPage typeUserNumber(String value){
        userNumberInput.setValue(value);

        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year){
       //$("#dateOfBirthInput").click();
        dateOfBirth.click();
        CalendarComponent calendar = new CalendarComponent();
        calendar.setDate(day, month, year);

        return this;
    }
    public RegistrationPage submitForm(){
        submitButtom.click();

        return this;
    }
    public RegistrationPage checkLastNameIsEmpty(){
       lastNameInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return  this;
    }
    public RegistrationPage genderIsEmpty(){
        genderContainer.shouldHave(cssValue("color", "rgba(33, 37, 41, 1)"));

        return this;
    }
    public RegistrationPage wrongEmail(){
        userEmailInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }
    public RegistrationPage wrongNumber(){
        userNumberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }

}
