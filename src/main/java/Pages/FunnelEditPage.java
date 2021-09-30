package Pages;

import Elements.Button;
import Elements.InputField;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FunnelEditPage {

    private static final SelenideElement deleteFunnelButton = $(".toolbar__delete");
    private static final SelenideElement modalDeleteButton = $x("//button[text()='Delete']");
    private static final SelenideElement modalConfirmButton = $(".snovio-btn--gray + button");
    private static final SelenideElement modalNameInput = $(".snovio-modal__window input");
    private static final SelenideElement funnelNameToolBar = $(".toolbar__name input");
    private static final SelenideElement backBtn = $("#backId");
    private static final SelenideElement addStageBox = $x("//div[@class='edit__columns']/div[1]//div[@class='stage__add-box']");
    private static final SelenideElement    addStageName = $x("//div[@class='stage'][2]//input[@class='stage__input']");


    BasePage basePage = new BasePage();
    Button button = new Button();
    InputField inputField = new InputField();



    public FunnelEditPage clickDeleteModalButton() {
        button.click(modalDeleteButton);
        return new FunnelEditPage();
    }

    public void setNameInputModal(String text) {
        modalNameInput.val(text);

    }





    public String getStageName() {
        return addStageName.getText();

    }

    public FunnelEditPage addCustomStage() {

        button.click(addStageBox);
        return this;
    }

    public FunnelEditPage addStageName(String text) {
        inputField.setValueAndPressEnter(addStageName, text);
        return this;
    }

    public CRMPage clickConfirmModalButton() {
        modalConfirmButton.shouldBe(enabled).click();
        return new CRMPage();
    }

    public FunnelEditPage clickDeleteFunnelButton() {
        button.click(deleteFunnelButton);
        return this;
    }


    public FunnelEditPage setFunnelNameToolBar(String name) {
        button.click(funnelNameToolBar);
        inputField.cleanInput(funnelNameToolBar);
        inputField.setValue(funnelNameToolBar, name);
        return this;
    }

    public CRMPage backToCRMPage() {
        backBtn.shouldBe(enabled).click();
        return new CRMPage();
    }

}
