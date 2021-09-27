import Pages.CRMPage;
import Pages.FunnelEditPage;
import Pages.LoginPage;
import Utils.MyListener;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static Utils.RandomData.getRandomInt;
import static Utils.RandomData.getRandomName;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MyListener.class)
public class FunnelsTestCRM {
    @Test
    @Feature("Funnel")
    @Tag("positive")
    public void createFunnel() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        String name = getRandomName();

        new LoginPage()
                .login();
        CRMPage crmPage = new CRMPage()
                .goToCrm()
                .clickFunnelDropDown()
                .clickNewPiplineButton()
                .setNameInputModal(name)
                .confirmCreateFunnel()

                .waitLoader()
                .clickFunnelDropDown();

        assertThat(crmPage.getCurrentNameFunnel(), is(name));

    }

    @Test
    @Feature("Funnel")
    @Tag("positive")

    public void deleteFunnel() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        new LoginPage()
                .login();

        CRMPage crmPage = new CRMPage()
                .goToCrm()
                .clickFunnelDropDown();
        int funnelSize = crmPage.getFunnelListSize();

        crmPage.checkActiveDeal(funnelSize);
        String name = crmPage.getCurrentNameFunnel();


        crmPage.clickToolBarBtn()
                .clickDeleteFunnelButton()
                .clickDeleteModalButton();

        crmPage.waitLoader()
                .clickFunnelDropDown();
        assertThat(name, not(crmPage.getCurrentNameFunnel()));


    }


    @Test
    @Feature("Funnel")
    @Tag("positive")
    public void renameFunnel() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        new LoginPage()

                .login();

        CRMPage crmPage = new CRMPage()
                .goToCrm()
                .clickFunnelDropDown()
                .getFunnel(2);
        String name = crmPage.getCurrentNameFunnel();

        crmPage.clickToolBarBtn()
                .setFunnelNameToolBar("Rename" + getRandomInt(1, 100))
                .backToCRMPage()
                .waitInvisibleLoader();

        assertThat(name, not(Condition.exactText(crmPage.getCurrentNameFunnel())));

    }

    @Test
    @Feature("Funnel")
    @Tag("positive")

    public void addNewStage() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        String name = getRandomName();
        new LoginPage()

                .login();

        FunnelEditPage crmPage = new CRMPage()
                .goToCrm()
                .clickFunnelDropDown()
                .getFunnel(0)
                .clickToolBarBtn()
                .addCustomStage()
                .addStageName(name);
        assertThat(name, is(Condition.exactText(crmPage.getStageName())));

    }
}

