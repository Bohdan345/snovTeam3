package Elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class Table {

    public ElementsCollection getRow(SelenideElement table) {
        ElementsCollection rows = table.findAll("tr");
        return rows;
    }

    public SelenideElement getColumn(SelenideElement table, int rowNumb, int columnNumb) {

        ElementsCollection columns = getRow(table).get(rowNumb).findAll("td");
        SelenideElement element = columns.get(columnNumb);
        return element;

    }
}