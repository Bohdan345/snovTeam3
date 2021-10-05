import Pages.CRMPage;
import Pages.LoginPage;
import Utils.MyListener;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static Utils.RandomData.getRandomInt;
import static Utils.RandomData.getRandomName;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MyListener.class)
public class FunnelsTestCRM {
    @Test
    @Feature("Funnel")
    @Tag("positive")
    @Order(1)
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

        assertThat(crmPage.getCurrentNameFunnel(), is(equalTo(name)));

    }

    @Test
    @Feature("Funnel")
    @Tag("positive")
    @Order(2)
    public void deleteFunnel() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        new LoginPage()
                .login();

        CRMPage crmPage = new CRMPage()
                .goToCrm()
                .clickFunnelDropDown();
        int funnelSize = crmPage.getFunnelListSize();

        crmPage.getFunnelWithoutActiveDeals(funnelSize);
        String name = crmPage.getCurrentNameFunnel();


        crmPage.clickToolBarBtn()
                .clickDeleteFunnelButton()
                .clickDeleteModalButton();

        crmPage.waitLoader()
                .clickFunnelDropDown();
        assertThat(crmPage.getCurrentNameFunnel(), not(equalTo(name)));


    }

    @Test
    @Feature("Funnel")
    @Tag("positive")
    void checkAllPipeline() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        new LoginPage()
                .login();

        CRMPage crmPage = new CRMPage()
                .goToCrm()
                .clickFunnelDropDown()
                .clickAllPipelineBtn()
                .waitLoader();
        assertThat(crmPage.getAllPipelinesDealCounterValue(), is(notNullValue()));
    }

    @Test
    @Feature("Funnel")
    @Tag("positive")
    @Order(3)

    public void renameFunnel() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        new LoginPage()

                .login();

        CRMPage crmPage = new CRMPage()
                .goToCrm()
                .clickFunnelDropDown();

        int funnelSize = crmPage.getFunnelListSize();

        crmPage.getFunnel(getRandomInt(0, funnelSize));

        String name = crmPage.getCurrentNameFunnel();

        crmPage.clickToolBarBtn()
                .setFunnelNameToolBar("Rename" + getRandomInt(1, 100))
                .backToCRMPage()
                .waitInvisibleLoader();
        assertThat(crmPage.getCurrentNameFunnel(), not(equalTo(name)));


    }


/*
    @Test
    @Feature("Funnel")
    @Tag("positive")
    @Order(4)

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
                .addStageName(name)
                        .backToCRMPage()

        Selenide.sleep(3000);
        assertThat(name, equalTo(crmPage.getStageName()));
    }

 */
}

