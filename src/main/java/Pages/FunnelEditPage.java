package Pages;

import Elements.Button;
import Elements.InputField;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class FunnelEditPage {

    private static final SelenideElement deleteFunnelButton = $(".toolbar__delete");
    private static final SelenideElement modalConfirmButton = $(".snovio-btn--gray + button");
    private static final SelenideElement modalNameInput = $(".snovio-modal__window input");
    private static final SelenideElement funnelNameToolBar = $(".toolbar__name input");
    private static final SelenideElement backBtn = $("#backId");

    BasePage basePage = new BasePage();
    Button button = new Button();
    InputField inputField = new InputField();

    public void setNameInputModal(String text) {
        modalNameInput.val(text);

    }


    public CRMPage clickConfirmModalButton() {
        modalConfirmButton.shouldBe(enabled).click();
        return new CRMPage();
    }

    public FunnelEditPage clickDeleteFunnelButton() {
        deleteFunnelButton.shouldBe(enabled).click();
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
