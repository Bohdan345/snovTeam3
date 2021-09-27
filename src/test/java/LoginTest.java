import Pages.LoginPage;
import Utils.MyListener;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static Pages.BasePage.destroy;
@ExtendWith(MyListener.class)
public class LoginTest {


    @Test
    public void login() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        new LoginPage()

                .login();



    }
}
