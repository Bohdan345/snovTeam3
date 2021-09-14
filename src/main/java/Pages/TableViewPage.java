package Pages;

import Elements.Button;
import Elements.DropDown;
import Elements.Table;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TableViewPage {
    private static final SelenideElement modalDeleteBtn = $x("//button[text()='Delete']");
    private static final SelenideElement modalSaveBtn = $x("//button[text()='Save']");
    private static final SelenideElement modalNameInput = $(".snovio-modal__window input");
    private static final SelenideElement deleteDealBtn = $(".delete");
    private static final SelenideElement tableDeal = $("#table");
    private static final SelenideElement moveBtn = $x("//div[text()=' Move']");
    private static final SelenideElement pipelineDropDown = $(".move-name");
    private static final SelenideElement modalPipelineList = $(".move-name ul");
    private static final SelenideElement stageDropDown = $(".move-stage");
    private static final SelenideElement modalStageList = $(".move-stage ul");

    BasePage basePage = new BasePage();
    Button button = new Button();
    Table table = new Table();
    DropDown dropDown = new DropDown();

    public TableViewPage clickCheckBoxTable(int rowNumber) {
        SelenideElement element = table.getColumn(tableDeal, rowNumber, 0);
        button.click(element);
        return this;
    }

    public DealProfilePage clickDealLink(int rowNumber) {
        SelenideElement element = table.getColumn(tableDeal, rowNumber, 1);
        button.click(element);
        return new DealProfilePage();
    }

    public String getColumnText(int rowNumber, int columnNumber) {
        SelenideElement element = table.getColumn(tableDeal, rowNumber, columnNumber);
        return element.getText();
    }


    public TableViewPage clickDeleteButton() {

        button.click(deleteDealBtn);
        return this;
    }


    public void setNameInputModal(String text) {
        modalNameInput.val(text);

    }


    public TableViewPage clickConfirmModalButton() {
        button.click(modalDeleteBtn);
        return this;
    }

    public TableViewPage clickMoveBtn() {
        button.click(moveBtn);
        return this;
    }


    public TableViewPage clickModalPipelineDrop() {
        button.click(pipelineDropDown);
        return this;
    }

    public TableViewPage getPipelineFromModalDrop(int pipelineIndex) {
        button.click(dropDown.getByIndex(modalPipelineList, pipelineIndex));
        return this;
    }


    public TableViewPage clickModalStageDropDown() {
        button.click(stageDropDown);
        return this;
    }

    public TableViewPage getStageFromModalDrop(int stageIndex) {
        button.click(dropDown.getByIndex(modalStageList, stageIndex));
        return this;
    }

    public TableViewPage clickSaveBtn() {
        button.click(modalSaveBtn);
        return this;
    }

}

