package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qa.guru.allure.steps.WebSteps;

public class StepAnnotatedTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final Integer ISSUE_NUMBER = 68;

    private final WebSteps steps = new WebSteps();

    @Disabled
    @Test
    @Owner("BaharevaElena")
    @Feature("GitHub")
    @Story("GitHub - Issues")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Тест в GitHub на проверку Issues")
    @Link(name = "GitHub", url = "https://github.com")
    public void testGithub() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }

}