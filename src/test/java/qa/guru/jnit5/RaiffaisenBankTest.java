package qa.guru.jnit5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


@Feature("Райффайзенбанк")
public class RaiffaisenBankTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
    }

    @Owner("BaharevaElena")
    @Story("Информация об отделениях")
    @Severity(SeverityLevel.NORMAL)
    @EnumSource(RaifData.class)
    @ParameterizedTest(name = "Проверка метро |{0}| в информации об отделении")
    void searchBranchBankTest(RaifData value) {
        open("https://www.raiffeisen.ru/offices/");
        $(".b-switch__block").click();
        $("input[name='search-place']").setValue("метро " + value).pressEnter();
        $(".e-office-item__subway").shouldHave(Condition.text(String.valueOf(value)));

    }
}
