package Pages;

import Elements.Button;
import Elements.DropDown;
import Elements.InputField;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

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
    private static final SelenideElement newPipelineButton = $x("//span[text()='New pipeline']");
    private static final SelenideElement pipelineModal = $x("//div[text()='Add new pipeline']");
    private static final SelenideElement modalNameInput = $(".snovio-modal__window input");
    private static final SelenideElement funnelName = $(".snovio-dropdown__name");
    private static final SelenideElement modalConfirmButton = $(".snovio-btn--gray + button");

    private static final ElementsCollection createdDeals = $$(".deal__name");

    private static final SelenideElement dealTitle = $(".deal-head__name");
    private static final SelenideElement checkIcon = $(".icon-small");
    private static final SelenideElement toolBarSettings = $(".toolbar__settings");
    private static final SelenideElement errorsSnovio = $(".snovio-input__error");
    private static final SelenideElement leadInFirstDeal = $("//div[@class='deal'][2]//div[@class='deal__name']");
    private static final SelenideElement deleteZone = $x("//div[@data-status='delete'])");
    private static final SelenideElement tableViewButton = $x(" //div[@class ='toolbar__tabs']/a[2]");

    private static final SelenideElement funnelsList = $x("//div[@class='snovio-dropdown__drop']/ul[1]");
    private static final SelenideElement funnelBtnList = $x("//div[@class='snovio-dropdown__drop']/ul[2] ");
    private static final SelenideElement prospectsLists = $(".deal__dropdown ul");

    BasePage basePage = new BasePage();
    Button button = new Button();
    InputField inputField = new InputField();
    DropDown dropDown = new DropDown();


    public TableViewPage clickTableViewBtn() {
        button.click(tableViewButton);
        return new TableViewPage();
    }




    public CRMPage moveDealToDeleteZone() {
        basePage.dragAndDrop(leadInFirstDeal, deleteZone);
        return this;
    }

    //  refactor
    public String getDealFromStage(String dealName) {
        return createdDeals.findBy(exactText(dealName)).getText();
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

    // refactor
    public CRMPage clickProspectDropDown() {
        button.click(prospectsListDropDown);
        return this;
    }


    //refactor
    public CRMPage chooseProspectList(int listIndex) {
        button.click(dropDown.getByIndex(prospectsLists, listIndex));
        return this;

    }

    public CRMPage clickSaveQuickDealBtn() {
        button.click(saveQickDeal);
        return this;
    }


    public String getErrorsText() {
        String text = errorsSnovio.getText();
        return text;
    }

    public int getFunnelNumber() {
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


    public CRMPage clickConfirmModalButton() {
        button.click(modalConfirmButton);
        return this;
    }


    public CRMPage getFunnel(int funnelNumber) {
        button.click(dropDown.getByIndex(funnelsList, funnelNumber));
        return this;
    }

    public int getFunnelListSize() {
        return funnelList.size();
    }

    public CRMPage getLastFunnel() {
        button.click(dropDown.getLastItem(funnelsList));
        return this;
    }


    public CRMPage waitLoader() {
        crmLoader.shouldNotBe(visible);
        return this;
    }


    public String getCurrentNameFunnel() {
        return funnelName.shouldBe(visible).getText();
    }


    public CRMPage waitInvisibleLoader() {
        crmLoader.shouldNotBe(visible);
        return this;
    }

    public FunnelEditPage clickToolBarBtn() {
        toolBarSettings.shouldBe(enabled).click();
        return new FunnelEditPage();

    }

    public CRMPage goToCrm() {
        basePage.startBrowser("https://preprod.snov.io/crm");
        crmLoader.shouldNotBe(visible);
        return new CRMPage();
    }


}


