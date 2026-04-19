package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResultComponent {
    private SelenideElement modalDialog = $(".modal-dialog.modal-lg");
    private SelenideElement modalSizesTitle =  $("#example-modal-sizes-title-lg");
    private SelenideElement tableResponsive = $(".table-responsive");

    public void modalDialog() {
       modalDialog.should(appear);
       modalSizesTitle.shouldHave(text("Thanks for submitting the form"));
    }
    public TableResultComponent checkResults(String key, String value){
        tableResponsive.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }
}
