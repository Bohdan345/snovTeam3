import Pages.CRMPage;
import Pages.DealProfilePage;
import Pages.LoginPage;
import Pages.TableViewPage;
import Utils.MyListener;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static Utils.RandomData.getRandomInt;
import static com.codeborne.selenide.Condition.exactText;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
@ExtendWith(MyListener.class)
public class TagTestCRM {


    @Test

    public void createTag() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        String name = "Tag" + getRandomInt(1, 100);

        new LoginPage()

                .login();

        TableViewPage crmPage = new CRMPage()
                .goToCrm()
                .clickTableViewBtn();
        DealProfilePage dealProfilePage = new DealProfilePage()
                .clickDealLink(2)
                .clisckAddTagBtn();
        Selenide.sleep(2000);
        crmPage.setNameInputModalAndPressEnter(name);
        Selenide.sleep(2000);
        crmPage.clickOkModalButton();
        assertThat(name, is(exactText(name)));

    }


    @Test

    public void deleteTag() {
        new LoginPage()

                .login();

        CRMPage crmPage = new CRMPage()
                .goToCrm();
    }

    @Test

    public void addTagToDeal() {
        new LoginPage()

                .login();

        CRMPage crmPage = new CRMPage()
                .goToCrm();
    }


}
