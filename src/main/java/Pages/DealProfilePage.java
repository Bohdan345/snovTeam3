package Pages;

import Elements.Button;
import Elements.DropDown;
import Elements.Table;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DealProfilePage {

    private static final SelenideElement tableDeal = $("#table");
    private static final SelenideElement addTagBtn = $(".tags-wrap button");
    private static final SelenideElement dealsTag = $(".deals__tags  ");
    private static final SelenideElement tagDropDown = $(".drop-item-wrapper");


    BasePage basePage = new BasePage();
    Button button = new Button();
    Table table = new Table();
    DropDown dropDown = new DropDown();


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

    public DealProfilePage clisckAddTagBtn() {
        button.click(addTagBtn);
        return this;
    }


    public DealProfilePage getDealTagName(String name) {
        dropDown.getByName(dealsTag, name);
        return this;

    }

}
