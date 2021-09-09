import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class DealTest {

    @Test
    public void openTest() {

        open("https://www.google.com/");
        closeWebDriver();
    }

    @Test
    public void openTest2() {

        open("https://www.google.com/");
        closeWebDriver();
    }

    @Test
    public void openTest3() {

        open("https://www.google.com/");
        closeWebDriver();
    }
}
