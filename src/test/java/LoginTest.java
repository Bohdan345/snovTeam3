import Pages.LoginPage;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static Pages.BasePage.destroy;

public class LoginTest {


@Test
    public void login() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        new LoginPage()

                .login();
        destroy();

    }
}
