package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tests.testData.TestData.userEmail;

public class TextBoxPage {
    // Elements
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput =  $("#userEmail");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement submitButtom = $("#submit");
    private SelenideElement outputResults =  $(".table-responsive");



    // Actions
    public TextBoxPage openPage(){
        open("");

        return this;
    }
    public TextBoxPage typeFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }
    public TextBoxPage typeLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }
    public TextBoxPage typeUserEmail(String value){
        userEmailInput.setValue(value);

        return this;
    }
    public TextBoxPage typeUserNumber(String value){
        userNumberInput.setValue(value);

        return this;
    }
    public TextBoxPage typeCurrentAddress(String value){
        currentAddressInput.setValue(value);

        return this;
    }
    public TextBoxPage submitForm(){
        submitButtom.click();

        return this;
    }
    public TextBoxPage checkField(String key, String value){
        outputResults.$(byId(key)).parent().shouldHave(text(value));

        return this;
    }

}
