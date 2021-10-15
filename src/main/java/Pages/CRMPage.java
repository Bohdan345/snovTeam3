package Pages;

import Elements.Button;
import Elements.DropDown;
import Elements.InputField;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CRMPage {


    private static final SelenideElement crmLoader = $x(" //div[@class='loader']");
    private static final SelenideElement quickAddButton = $(".deal__quick");
    private static final SelenideElement dealNameInput = $x("//input[@placeholder = 'Deal name']");
    private static final SelenideElement priceInput = $x("//input[@placeholder='$0']");
    private static final SelenideElement nameProspectInput = $x("//input[@placeholder='Prospect name']");
    private static final SelenideElement emailProspectInput = $x("//input[@placeholder='Prospect email']");
    private static final SelenideElement prospectsListDropDown = $x("//input[@placeholder='Prospect list']");
    private static final SelenideElement saveQickDeal = $x(" //div[@class='deal__btns']/button[1]");
    private static final ElementsCollection nameDeals = $$("[data-index='0'].deal__name");
    private static final SelenideElement funnelDropDown = $(".toolbar__funnels");
    private static final ElementsCollection funnelList = $$x(".//ul[@class= 'snovio-dropdown__list']/li");
    private static final SelenideElement modalNameInput = $(".snovio-modal__window input");
    private static final SelenideElement funnelName = $(".snovio-dropdown__name");

    private static final SelenideElement createFunnelOkButton = $x("//button[@data-test='modal-cancel']//following-sibling::button");

    private static final ElementsCollection createdDeals = $$(".deal__name");


    private static final SelenideElement checkIcon = $(".icon-small");
    private static final SelenideElement toolBarSettings = $(".toolbar__settings");
    private static final SelenideElement errorsSnovio = $(".snovio-input__error");
    private static final SelenideElement leadInFirstDeal = $("//div[@class='deal'][2]//div[@class='deal__name']");
    private static final SelenideElement deleteZone = $x("//div[@data-status='delete'])");
    private static final SelenideElement tableViewButton = $x(" //div[@class ='toolbar__tabs']/a[2]");

    private static final SelenideElement funnelsList = $x("//div[@class='snovio-dropdown__drop']/ul[1]");
    private static final SelenideElement funnelsDropDownBtns = $(".snovio-dropdown__list--sticky");
    private static final SelenideElement funnelBtnList = $x("//div[@class='snovio-dropdown__drop']/ul[2] ");
    private static final SelenideElement prospectsLists = $(".deal__dropdown ul");

    private static final ElementsCollection activeDeal = $$(".dashboard .deal__link");
    private static final SelenideElement createDealBtn = $(".toolbar__btn");
    private static final SelenideElement dashboardColumns = $(".dashboard__columns");
    private static final SelenideElement dealCounter = $(".toolbar__info-counter");


    BasePage basePage = new BasePage();
    Button button = new Button();
    InputField inputField = new InputField();
    DropDown dropDown = new DropDown();


    /**
     * Получаем массив стейджей
     */
    private ElementsCollection getStageColumns() {

        ElementsCollection stages = dashboardColumns.findAll("td");
        return stages;
    }


    /**
     * Получаем один стейдж по индексу
     */
    @Step()
    private SelenideElement getStageColumn(int stageIndex) {

        return getStageColumns().get(stageIndex);
    }


    @Step("Проходим по стейджам  и ищем сделки в стейджах ")
    private SelenideElement getActiveDealsInStages(int dealIndex) {


        SelenideElement element = null;


        for (int i = 0; i < getStageColumns().size(); i++) {

            ElementsCollection deals = getStageColumns().get(i).findAll(".deal__name");
            if (deals.size() > 0) {
                element = deals.get(dealIndex);
                break;
            }

        }
        return element;
    }

    @Step("Нажимаем на активную  сделку в стейдже ")
    public DealProfilePage clickActiveDeal() {
        button.click(getActiveDealsInStages(0));
        return new DealProfilePage();
    }

    public DealProfilePage getDealFromStage(int stageIndex, int dealIndex) {
        ElementsCollection deals = getStageColumns().get(stageIndex).findAll(".deal__name");

        button.click(deals.get(dealIndex));
        return new DealProfilePage();

    }

    public DealProfilePage getFirstDealFromStage(int stageIndex) {
        ElementsCollection deals = getStageColumns().get(stageIndex).findAll(".deal");

        button.clickVisible(deals.get(1));
        return new DealProfilePage();
    }

    public int getDealCounterValue() {
        String dealNumber;
        String counterText = dealCounter.shouldBe(visible).getText();
        if (counterText.equals("No deals")) {
            dealNumber = "0";
        } else {
            dealNumber = counterText.replaceAll("\\p{L}|\\s", "");
        }
        return Integer.parseInt(dealNumber);
    }

    public String getDealName(String name, int stageIndex) {
        ElementsCollection deals = getStageColumns().get(stageIndex).findAll(".deal .deal__name");
        return deals.find(exactText(name)).getText();

    }


    public DealProfilePage clickCreateDeal() {
        button.click(createDealBtn);
        return new DealProfilePage();
    }

    public CRMPage clickAllPipelineBtn() {
        button.click(dropDown.getByIndex(funnelsDropDownBtns, 1));

        return this;
    }

    public int getActiveDealNumber() {

        int dealNumber = activeDeal.size();

        return dealNumber;
    }

    public TableViewPage clickTableViewBtn() {
        button.click(tableViewButton);
        return new TableViewPage();
    }

    public CRMPage clickQuickDealBtn() {
        button.click(quickAddButton);
        return this;

    }

    public CRMPage setDealName(String name) {
        inputField.cleanInput(dealNameInput);
        inputField.setValue(dealNameInput, name);

        return this;

    }

    public CRMPage setDealPrice(String price) {
        inputField.cleanInput(priceInput);
        inputField.setValue(priceInput, price);


        return this;

    }

    public CRMPage setDealProspect(String name) {
        inputField.cleanInput(nameProspectInput);
        inputField.setValue(nameProspectInput, name);

        return this;

    }

    public CRMPage setDealEmail(String email) {
        inputField.cleanInput(emailProspectInput);
        inputField.setValue(emailProspectInput, email);
        return this;
    }

    public CRMPage clickProspectDropDown() {
        button.click(prospectsListDropDown);
        return this;
    }

    public CRMPage chooseProspectList(int listIndex) {
        button.clickVisible(dropDown.getByIndex(prospectsLists, listIndex));
        return this;

    }

    public CRMPage clickSaveQuickDealBtn() {
        button.click(saveQickDeal);
        return this;
    }

    //not use
    public String getErrorsText() {
        String text = errorsSnovio.getText();
        return text;
    }

    public int getFunnelNumbers() {
        int size = funnelList.size();
        return size;
    }

    public CRMPage clickFunnelDropDown() {

        button.click(funnelDropDown);
        return this;
    }

    public CRMPage checkChooseIcon() {
        button.click(checkIcon);
        return this;
    }

    public CRMPage checkIconVisible() {
        funnelDropDown.click();
        checkIcon.shouldBe(visible);
        return this;
    }

    public CRMPage clickNewPiplineButton() {
        button.click(dropDown.getByIndex(funnelBtnList, 2));

        return this;
    }


    public CRMPage setNameInputModal(String text) {
        modalNameInput.val(text);
        return this;
    }


    public CRMPage confirmCreateFunnel() {
        button.click(createFunnelOkButton);
        return this;

    }

    public CRMPage getFunnel(int funnelNumber) {
        button.click(dropDown.getByIndex(funnelsList, funnelNumber));
        return this;
    }

    public int getFunnelListSize() {
        int size = funnelList.size();
        return size;
    }

    public CRMPage getLastFunnel() {
        button.click(dropDown.getLastItem(funnelsList));
        return this;
    }

    @Step("Ожидание прогрузки лоадера ")
    public CRMPage waitLoader() {
        crmLoader.shouldNotBe(visible);
        return this;
    }


    public String getCurrentNameFunnel() {
        return funnelName.shouldBe(visible).getText();
    }

    @Step("Нажатие на кнопку настройки воронки ")
    public FunnelEditPage clickToolBarBtn() {
        toolBarSettings.shouldBe(enabled).click();
        return new FunnelEditPage();

    }

    @Step("Переход на CRM")
    public CRMPage goToCrm() {
        basePage.startBrowser("https://preprod.snov.io/crm");
        crmLoader.shouldNotBe(visible);
        return new CRMPage();
    }

    @Step("Получение воронки без активных сделок")
    public void getFunnelWithoutActiveDeals(int funnelSize) {

        for (int i = 0; i < funnelSize; i++) {

            getFunnel(i);
            waitLoader();
            if (getActiveDealNumber() > 0) {
                System.out.println("Funnel " + " '" + getCurrentNameFunnel() +
                        "' " + " have active deal");
                clickFunnelDropDown();


            } else {

                break;
            }
        }
    }

    @Step("Получение воронки с активными сделками")
    public CRMPage getFunnelWithActiveDeals(int funnelSize) {

        for (int i = 0; i < funnelSize; i++) {

            getFunnel(i);
            waitLoader();

            if (getActiveDealNumber() <= 0) {
                System.out.println("Funnel " + " '" + getCurrentNameFunnel() +
                        "' " + " have not active deal");

                clickFunnelDropDown();


            } else {

                break;
            }
        }
        return this;
    }


}




