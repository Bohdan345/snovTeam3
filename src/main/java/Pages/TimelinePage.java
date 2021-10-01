package Pages;

import Elements.Button;
import Elements.DropDown;
import Elements.InputField;
import Elements.Table;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TimelinePage {
    private static final SelenideElement tableDeal = $("#table");
    private static final SelenideElement timelineEvents = $(".timeline__feed");
    private static final SelenideElement noteTextArea = $x("//form[@class='snovio-notes']");
    private static final SelenideElement noteInputArea = $(".snovio-notes__text");
    private static final SelenideElement refreshTimeline = $(".timeline__filter button");
    private static final SelenideElement createdDealEvent = $(".card__message p");

    BasePage basePage = new BasePage();
    Button button = new Button();
    Table table = new Table();
    DropDown dropDown = new DropDown();
    InputField inputField = new InputField();


    public String getEventText() {

        return createdDealEvent.getText();
    }

    public TimelinePage clickRefreshTimelineBtn() {
        button.click(refreshTimeline);
        return this;
    }

    public void setNoteText(String text) {

        inputField.setValue(noteInputArea, text);
    }


    public TimelinePage clickNoteTextArea() {
        button.click(noteTextArea);
        return this;
    }

    public ElementsCollection getRow(SelenideElement table) {
        ElementsCollection rows = table.findAll("tr");
        return rows;
    }

    public SelenideElement getColumn(SelenideElement table, int rowNumb, int columnNumb) {

        ElementsCollection columns = getRow(table).get(rowNumb).findAll("td");
        SelenideElement element = columns.get(columnNumb);
        return element;

    }


    public ElementsCollection getNoteContextMenu() {

        ElementsCollection element = timelineEvents.findAll(".card .card__context-menu");
        return element;
    }


    public void clickContextMenuNote(int notesNumber) {
        SelenideElement element = getNoteContextMenu().get(notesNumber);
        button.click(element);

    }


}
