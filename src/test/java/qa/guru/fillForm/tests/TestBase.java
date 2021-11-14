package qa.guru.fillForm.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import qa.guru.fillForm.pages.RegistrationPage;

public class TestBase {



        RegistrationPage registrationPage = new RegistrationPage();

        @BeforeAll
        static void beforeAll() {
            Configuration.startMaximized = true;
        }
}
