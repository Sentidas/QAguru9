package qa.guru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Ivana");
        $("#lastName").setValue("Ivanova");
        $("#userEmail").setValue("aaa@aa.aa");
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue("8987654321");
        $("#dateOfBirthInput").click();
        $("[class=react-datepicker__month-select]").selectOption("April");
        $("[class=react-datepicker__year-select]").selectOption("1995");
        $(byXpath("//div[text()='16']")).click();

        $("#subjectsContainer").click();
        $("#subjectsContainer input").sendKeys(Keys.SPACE);
        $(byText("Social Studies")).click();

        $("[for=hobbies-checkbox-2]").click();
        $("#currentAddress").setValue("Moscow Arbat 14 58 ");

        $(byText("Select State")).click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Delhi")).click();
        $("#uploadPicture").uploadFromClasspath("111.jfif");
        $("#submit").pressEnter();

        $(byXpath("//*[text()='Student Name']/ancestor::tr/td[2]")).shouldHave(text("Ivana Ivanova"));
        $(byXpath("//*[text()='Student Email']/ancestor::tr/td[2]")).shouldHave(text("aaa@aa.aa"));
        $(byXpath("//*[text()='Gender']/ancestor::tr/td[2]")).shouldHave(text("Female"));
        $(byXpath("//*[text()='Mobile']/ancestor::tr/td[2]")).shouldHave(text("8987654321"));
        $(byXpath("//*[text()='Date of Birth']/ancestor::tr/td[2]")).shouldHave(text("16 April,1995"));
        $(byXpath("//*[text()='Subjects']/ancestor::tr/td[2]")).shouldHave(text("Social Studies"));
        $(byXpath("//*[text()='Hobbies']/ancestor::tr/td[2]")).shouldHave(text("Reading"));
        $(byXpath("//*[text()='Picture']/ancestor::tr/td[2]")).shouldHave(text("111.jfif"));
        $(byXpath("//*[text()='Address']/ancestor::tr/td[2]")).shouldHave(text("Moscow Arbat 14 58 "));
        $(byXpath("//*[text()='State and City']/ancestor::tr/td[2]")).shouldHave(text("NCR Delhi"));
    }
}
