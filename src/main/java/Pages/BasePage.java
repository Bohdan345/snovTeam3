package Pages;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static ReadData.DataFromProperty.BROWSER;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;

public class BasePage {


    protected void startBrowser(String url) {

        Configuration.browser = BROWSER;
        Configuration.startMaximized = true;
        Configuration.timeout = Duration.of(30, ChronoUnit.SECONDS).toMillis();
        open(url);

    }


    protected void dragAndDrop(SelenideElement element, SelenideElement target) {
        actions().moveToElement(element).clickAndHold().moveToElement(target).release().perform();

    }


    public static void destroy() {
        Selenide.closeWebDriver();

    }

}
