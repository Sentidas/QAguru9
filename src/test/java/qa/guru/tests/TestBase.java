package qa.guru.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import qa.guru.pages.RegistrationPage;

public class TestBase {



        RegistrationPage registrationPage = new RegistrationPage();

        @BeforeAll
        static void beforeAll() {
            Configuration.startMaximized = true;
        }
}
