package qa.guru.fillForm.pages;

import com.codeborne.selenide.SelenideElement;
import qa.guru.fillForm.pages.components.CalendarComponent;
import qa.guru.fillForm.pages.components.TableResultsComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            subject = $("#subjectsInput"),
            hobby = $("#hobbiesWrapper"),
            uploadFile = $("#uploadPicture"),
            stateInput = $("#state"),
            stateSelection = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            citySelection = $("#stateCity-wrapper"),
            phoneInput = $("#userNumber"),
            address = $("#currentAddress"),
            submit = $("#submit"),
            resultsTable = $(".table-responsive");


    public CalendarComponent calendarComponent = new CalendarComponent();
    public TableResultsComponent tableResultsComponent = new TableResultsComponent();

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public void typeLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void typeEmail(String value) {
        emailInput.setValue(value);
    }

    public void typePhone(String value) {
        phoneInput.setValue(value);
    }

    public void typeAddress(String value) {
        address.setValue(value);
    }

    public void chooseAndClickGender(String value) {
        gender.$(byText(value)).click();
    }


    public void chooseAndClickHobby(String value) {
        hobby.$(byText(value)).click();
    }

    public void uploadFile(String value) {
        uploadFile.uploadFromClasspath(value);
    }

    public void chooseAndClickSubject(String value) {
        subject.setValue(value).pressEnter();
    }

    public void chooseAndClickState(String value) {
        stateInput.click();
        stateSelection.$(byText(value)).click();
    }

    public void chooseAndClickCity(String value) {
        cityInput.click();
        citySelection.$(byText(value)).scrollTo().click();
    }

    public void clickSubmit() {
        submit.click();
    }


}
