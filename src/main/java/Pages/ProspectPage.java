package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static Utils.RandomData.getRandomInt;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class ProspectPage {


    private static final SelenideElement createFolderButton = $x("//div[@data-test='aside-create-folder']");
    private static final SelenideElement createFolderModalTitle = $x("//p[text()='Create a new folder']");
    private static final SelenideElement deleteFolderModalTitle = $x("//p[text()='Confirm deletion']");

    private static final SelenideElement addNewList = $x("//button[@data-test='aside-create-new-lists']");
    private static final SelenideElement myListsDropDow = $x("//span[@class='name']");
    private static final SelenideElement createOrImportButton = $x("//div[@data-test='add-human']");
    private static final SelenideElement importFromFileButton = $x("//ul[@data-test='add-human-list']//li[1]");
    private static final SelenideElement customFieldButton = $x("//div[@data-test='add-custom-fields']");
    private static final SelenideElement exportButton = $x("//div[@data-test='export-prospects-button']");
    private static final SelenideElement dublicateButton = $x("//div[@data-test='filter-duplicates']");
    private static final SelenideElement createButton = $x("//span[text()='Create']");
    private static final SelenideElement confirmButton = $x("//span[text()='Confirm']");
    private static final SelenideElement nameField = $x("//input[@id='createNewList']");
    private static final SelenideElement createListModalTitle = $x("//p[text()='Create a new prospects list']");

    private static final ElementsCollection listElements = $$x("//li[@class='aside__item-relative']");
    private static final ElementsCollection folderElements = $$x("//li[@class='folder-box']");
    private static final ElementsCollection folderContextMenu = $$(".folder-box >* .control");
    private static final ElementsCollection dropDownElements = $$(".folder-box >* .control__drop li");

    BasePage basePage = new BasePage();

    public void createNewList() {
        addNewList.click();
        createListModalTitle.shouldBe(Condition.visible);
        nameField.sendKeys(Keys.BACK_SPACE);
        String listNameText = "List " + getRandomInt(1, 9999);
        nameField.setValue(listNameText);
        createButton.click();

        listElements.findBy(Condition.text(listNameText)).scrollIntoView(true).click();


    }


    public void createNewFolder() {
        createFolderButton.click();
        createFolderModalTitle.shouldBe(Condition.visible);
        nameField.clear();
        String folderNameText = "Folder " + getRandomInt(1, 9999);
        nameField.setValue(folderNameText);
        createButton.click();
        folderElements.findBy(Condition.text(folderNameText)).scrollIntoView(true).click();
        assertThat(folderNameText, is(containsString(folderNameText)));

    }


    public void deleteFolder() {
        if (folderElements.size() > 0) {
            String folderName = folderElements.first().getText();
            folderContextMenu.first().click();
            dropDownElements.filterBy(Condition.exactText("Delete folder")).first().click();
            deleteFolderModalTitle.shouldBe(Condition.visible);
            confirmButton.click();
            String actual = folderElements.findBy(Condition.exactText(folderName)).getText();
            assertThat(" ", true);


        }

    }


}
