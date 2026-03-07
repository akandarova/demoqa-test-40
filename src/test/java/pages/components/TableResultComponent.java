package pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableResultComponent {
    public void modalDialog() {
        $(".modal-dialog.modal-lg").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
    public TableResultComponent checkResults(String key, String value){
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));

        return this;
    }
}
