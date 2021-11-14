package qa.guru.fillForm.pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class TableResultsComponent {

    private final String FORM_TITLE = "Thanks for submitting the form";
    private SelenideElement resultsTable = $(".table-responsive"),
                            titleTable = $("#example-modal-sizes-title-lg");


    public void checkTitle() {
        titleTable.shouldHave(text(FORM_TITLE));

    }
    public TableResultsComponent checkResultsValue(String key, String value) {
        resultsTable.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }
}
