import Pages.CRMPage;
import Pages.DealProfilePage;
import Pages.LoginPage;
import Pages.TimelinePage;
import Utils.MyListener;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static Utils.RandomData.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MyListener.class)
public class DealTestCRM {


    @Test
    @Feature("Deals")
    @Tag("positive Test")
    public void createDeal() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        String name = getRandomName();
        new LoginPage()
                .login();

        DealProfilePage crm = new CRMPage()
                .goToCrm()
                .waitLoader()
                .clickCreateDeal()
                .setDealName(name)
                .setDealValue("1000")
                .setDealEmail("bt@snov.io")
                .waitSearchProspectLoader()
                .getProspectEmail()
                .clickSaveBtn();
        TimelinePage tlp = new TimelinePage()
                .clickRefreshTimelineBtn();

        assertThat(tlp.getEventText(), is(equalTo("Deal created: " + name)));


        Selenide.sleep(3000);

    }


    @Test
    @Feature("Deals")
    @Tag("positive Test")
    public void deleteDeal() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        new LoginPage()
                .login();

        CRMPage crmPage = new CRMPage()
                .goToCrm()
                .waitLoader()
                .clickFunnelDropDown();

        crmPage.getFunnelWithActiveDeals(crmPage.getFunnelListSize());

        int dealNumbers = crmPage.getDealCounterValue();
        crmPage.clickActiveDeal();


        new DealProfilePage()
                .clickDealContextBtn()
                .clickDeleteDealBtn()
                .clickDeleteModalButton();
        crmPage.waitLoader();

        assertThat(crmPage.getDealCounterValue(), not(dealNumbers));

    }


    @Test
    @Feature("Deals")
    @Tag("positive Test")
    public void createQuickDeal() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        String name = getRandomName();
        new LoginPage()
                .login();

        CRMPage crm = new CRMPage()
                .goToCrm()
                .waitLoader()
                .clickQuickDealBtn()
                .setDealName(name)
                .setDealPrice(String.valueOf(getRandomInt(1, 100)))
                .setDealProspect(getRandomName())
                .setDealEmail(getRandomEmail())
                .clickProspectDropDown()
                .chooseProspectList(getRandomInt(0, 5))
                .clickSaveQuickDealBtn();

        assertThat(crm.getDealName(name, 0), equalTo(name));


    }

    /*
    @Test
    @Feature("Deals")
    @Tag("positive Test")
    public void removeDealFromTable() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        new LoginPage()
                .login();

        TableViewPage crm = new CRMPage()
                .goToCrm()
                .waitLoader()
                .clickTableViewBtn()
                .clickCheckBoxTable(3)
                .clickDeleteButton()
                .clickDeleteModalButton();

        // ???????????????? ???????????????? ???? ?????????????????? ??????????????
    }
*/
/*
    @Test
    @Feature("Deal")
    @Tag("positive Test")
    public void bulkRemoveDealsFromTable() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        new LoginPage()
                .login();

        TableViewPage crm = new CRMPage()
                .goToCrm()
                .waitLoader()
                .clickTableViewBtn()
                .clickCheckBoxTable(3)
                .clickCheckBoxTable(4)
                .clickCheckBoxTable(5)
                .clickDeleteButton()
                .clickDeleteModalButton();

// ???????????????? ???????????????? ???? ?????????????????? ??????????????
    }
*/

    /*
    @Test
    @Feature("Deal")
    @Tag("positive Test")
    public void changePipelineFromTableView() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        new LoginPage()
                .login();

        TableViewPage crm = new CRMPage()
                .goToCrm()
                .waitLoader()
                .clickTableViewBtn()
                .clickCheckBoxTable(3)
                .clickMoveBtn()
                .clickModalPipelineDrop()
                .getPipelineFromModalDrop(3)
                .clickSaveBtn();
        Selenide.sleep(5000);
// ???????????????? ???????????????? , ?????????????????????????? ?????????? ?? ?????? ???? ??????
    }

     */

    /*
    @Test
    @Feature("Deal")
    @Tag("positive Test")
    public void changeStageFromTableView() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        new LoginPage()
                .login();

        TableViewPage crm = new CRMPage()
                .goToCrm()
                .waitLoader()
                .clickTableViewBtn()
                .clickCheckBoxTable(3)
                .clickMoveBtn()
                .clickModalStageDropDown()
                .getStageFromModalDrop(2)
                .clickSaveBtn();
        Selenide.sleep(5000);
// ???????????????? ???????????????? , ?????????????????????????? ?????????? ?? ?????? ???? ??????
    }
*/

/*
    @Test
    @Feature("Deal")
    @Tag("positive Test")

    public void changePipelineAndStageFromTableView() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        new LoginPage()
                .login();

        TableViewPage crm = new CRMPage()
                .goToCrm()
                .waitLoader()
                .clickTableViewBtn()
                .clickCheckBoxTable(3)
                .clickMoveBtn()
                .clickModalPipelineDrop()
                .getPipelineFromModalDrop(3)
                .clickModalStageDropDown()
                .getStageFromModalDrop(2)
                .clickSaveBtn();

// ???????????????? assert , ?????????????????????????? ?????????? ?? ?????? ???? ??????
    }
*/


}
