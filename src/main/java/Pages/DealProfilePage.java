package Pages;

import Elements.Button;
import Elements.DropDown;
import Elements.InputField;
import Elements.Table;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class DealProfilePage {

    private static final SelenideElement tableDeal = $("#table");
    private static final SelenideElement addTagBtn = $(".tags-wrap button");
    private static final SelenideElement dealsTag = $(".deals__tags  ");
    private static final SelenideElement tagDropDown = $(".drop-item-wrapper");
    private static final SelenideElement dealHead = $(".deal-head__name");
    private static final SelenideElement emailProspectInput = $x("//input[@placeholder='Prospect email']");
    private static final SelenideElement prospectsListDropDown = $x("//input[@placeholder='Prospect list']");
    private static final SelenideElement prospectsLists = $(".deal__dropdown ul");
    private static final SelenideElement valueInput = $("#Details input");
    private static final SelenideElement responsibleDropDown = $(".select-with-label__selected-name");
    private static final SelenideElement prospectEmailDropDown = $(" .prospect__email .search__list");
    private static final SelenideElement searchEmailLoader = $(".search__label--email svg");
    private static final SelenideElement saveDealBtn = $(".deal-info__btn-group .snovio-btn--save");
    private static final SelenideElement dealContextBtn = $x("//div[@tabindex='2']/div[1]");
    private static final SelenideElement dealContextDropDownList = $x("//div[@tabindex='2']//ul");
    private static final SelenideElement change = $x("//div[@tabindex='2']//ul");
    private static final SelenideElement modalDeleteButton = $x("//button[text()='Delete']");
    private static final SelenideElement modalConfirmButton = $(".snovio-btn--gray + button");
    private static final SelenideElement modalNameInput = $(".snovio-modal__window input");


    BasePage basePage = new BasePage();
    Button button = new Button();
    Table table = new Table();
    DropDown dropDown = new DropDown();
    InputField inputField = new InputField();


    public DealProfilePage clickChangeDropDown() {


        return this;
    }

    public CRMPage clickDeleteModalButton() {
        button.click(modalDeleteButton);
        return new CRMPage();
    }

    public void setNameInputModal(String text) {
        modalNameInput.val(text);

    }

    public CRMPage clickConfirmModalButton() {
        modalConfirmButton.shouldBe(enabled).click();
        return new CRMPage();
    }


    public DealProfilePage clickDeleteDealBtn() {
        button.click(dropDown.getByIndex(dealContextDropDownList, 1));
        return this;
    }

    public DealProfilePage clickDealContextBtn() {
        button.click(dealContextBtn);
        return this;
    }


    public DealProfilePage clickSaveBtn() {
        button.click(saveDealBtn);
        return this;
    }

    public DealProfilePage waitSearchProspectLoader() {
        searchEmailLoader.shouldNotBe(Condition.visible);

        return this;
    }

    public DealProfilePage getProspectEmail() {
        button.click(dropDown.getByIndex(prospectEmailDropDown, 1));
        return this;
    }

    public DealProfilePage setDealValue(String value) {
        button.clickVisible(valueInput);
        inputField.cleanInput(valueInput);
        inputField.setValue(valueInput, value);
        return this;
    }


    public DealProfilePage setDealEmail(String email) {
        inputField.cleanInput(emailProspectInput);
        inputField.setValue(emailProspectInput, email);
        return this;
    }

    // refactor
    public DealProfilePage clickProspectDropDown() {
        button.click(prospectsListDropDown);
        return this;
    }


    //refactor
    public DealProfilePage chooseProspectList(int listIndex) {
        button.click(dropDown.getByIndex(prospectsLists, listIndex));
        return this;

    }


    public DealProfilePage setDealName(String dealName) {
        inputField.cleanInput(dealHead);
        inputField.setValue(dealHead, dealName);
        return this;
    }

    private ElementsCollection getListItems(SelenideElement dropDownList) {
        ElementsCollection list = dropDownList.findAll("div");
        return list;
    }

    public SelenideElement getTagByIndex(SelenideElement list, int index) {
        SelenideElement element = getListItems(list).get(index);
        return element;
    }

    public DealProfilePage clickDealLink(int rowNumber) {
        SelenideElement element = table.getColumn(tableDeal, rowNumber, 1);
        button.click(element);
        return new DealProfilePage();
    }

    //not used
    public DealProfilePage clickAddTagBtn() {
        button.click(addTagBtn);
        return this;
    }

    //not used
    public DealProfilePage getDealTagName(String name) {
        dropDown.getByName(dealsTag, name);
        return this;

    }

}
