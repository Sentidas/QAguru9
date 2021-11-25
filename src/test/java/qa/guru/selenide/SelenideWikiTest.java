package qa.guru.selenide;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideWikiTest {
    @Disabled
    @Test
    public void checkTextWithJUnit5(){
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(linkText("Soft assertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));

    }
}

