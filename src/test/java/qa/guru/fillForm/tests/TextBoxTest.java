package qa.guru.fillForm.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class TextBoxTest extends TestBase {

    Faker faker = new Faker(new Locale("ru"));

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String phoneNumber = faker.number().digits(10);
    String addressCity = faker.address().city();
    String addressStreet = faker.address().streetAddress();


    @Test
    void fillFormTest() {

        registrationPage.openPage();
        registrationPage.typeFirstName(firstName)
                .typeLastName(lastName);

        registrationPage.typeEmail("aaa@aa.aa");
        registrationPage.chooseAndClickGender("Female");
        registrationPage.typePhone(phoneNumber);

        registrationPage.calendarComponent.setDate("15", "May", "2000");

        registrationPage.chooseAndClickSubject("History");
        registrationPage.chooseAndClickHobby("Reading");
        registrationPage.uploadFile("1.jfif");
        registrationPage.typeAddress(addressCity + " " + addressStreet);
        registrationPage.chooseAndClickState("NCR");
        registrationPage.chooseAndClickCity("Delhi");
        registrationPage.clickSubmit();

        registrationPage.tableResultsComponent.checkTitle();
        registrationPage.tableResultsComponent
                .checkResultsValue("Student Name", firstName + " " + lastName)
                .checkResultsValue("Student Email", "aaa@aa.aa")
                .checkResultsValue("Gender", "Female")
                .checkResultsValue("Mobile", phoneNumber)
                .checkResultsValue("Date of Birth", "15 May,2000")
                .checkResultsValue("Subjects", "History")
                .checkResultsValue("Hobbies", "Reading")
                .checkResultsValue("Picture", "1.jfif")
                .checkResultsValue("Address", addressCity + " " + addressStreet)
                .checkResultsValue("State and City", "NCR Delhi");

    }
}
