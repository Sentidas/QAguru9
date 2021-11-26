package qa.guru.jnit5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

@Feature("Кинопоиск")
public class KinopoiskTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
    }

    @Owner("BaharevaElena")
    @Story("Поиск cериала по названию")
    @Severity(SeverityLevel.BLOCKER)
    @ValueSource(strings = {"Бумажный дом", "Игра престолов", "Ход королевы"})
    @ParameterizedTest(name = "Поиск в Кинопоиске сериала |{0}| и проверка его заголовка")
    void searchFilmTest(String value) {
        open("https://kinopoisk.ru/");
        $("input[name='kp_query']").setValue(value).pressEnter();
        $(linkText("актеры")).click();
        $(".breadcrumbs").shouldHave(Condition.text(value));
    }

    @Owner("BaharevaElena")
    @Story("Наличие сериала в инофрмации об актере")
    @Severity(SeverityLevel.NORMAL)
    @CsvSource(value = {
            "Альваро Морте| Бумажный дом",
            "Трэвис Фиммел| Викинги"
    },
            delimiter = '|')
    @ParameterizedTest(name = "Проверка фильма |{1}| в информации об актере - |{0}|")
    void searchFilmInInfoOfActor(String nameActor, String nameFilm) {
        open("https://kinopoisk.ru/");
        $("input[name='kp_query']").setValue(nameActor).pressEnter();
        $("div h1").shouldHave(Condition.text(nameActor));
        $(".styles_panel__14Dgg").shouldHave(Condition.text(nameFilm));
    }


    private static Stream<Arguments> searchFilmInInfoOfActor2() {
        return Stream.of(
                Arguments.of("Урсула Корберо", "Бумажный дом"),
                Arguments.of("Кит Харингтон", "Игра престолов")
        );
    }

    @Owner("BaharevaElena")
    @Story("Поиск в инофрмации об актере")
    @Severity(SeverityLevel.NORMAL)
    @MethodSource
    @ParameterizedTest(name = "Проверка фильма |{1}|  в информации об актере - |{0}|")
    void searchFilmInInfoOfActor2(String nameActor, String nameFilm) {
        open("https://kinopoisk.ru/");
        $("input[name='kp_query']").setValue(nameActor).pressEnter();
        $("div h1").shouldHave(Condition.text(nameActor));
        $(".styles_panel__14Dgg").shouldHave(Condition.text(nameFilm));
    }
}
