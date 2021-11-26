package qa.guru.fillForm.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.guru.fillForm.pages.RegistrationPage;

public class TestBase {
        RegistrationPage registrationPage = new RegistrationPage();

        @BeforeAll
        static void beforeAll() {
            Configuration.startMaximized = true;
            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);

            Configuration.browserCapabilities = capabilities;
        }
}
