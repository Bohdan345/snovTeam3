package Elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;

public class DropDown {

    public ElementsCollection getListItems(SelenideElement dropDownList) {
        ElementsCollection list = dropDownList.findAll("li");
        return list;
    }

    public SelenideElement getByIndex(SelenideElement list, int index) {
        SelenideElement element = getListItems(list).get(index);
        return element;
    }

    public SelenideElement getByName(SelenideElement list, String name) {
        SelenideElement element = getListItems(list).find(exactText(name));
        return element;
    }


    public SelenideElement getLastItem(SelenideElement list) {

        SelenideElement element = getListItems(list).first();

        return element;
    }


}
