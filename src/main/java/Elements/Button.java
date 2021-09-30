package Elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class Button {
    public void clickAndChooseFirstItem(ElementsCollection elements) {
        elements.first().shouldBe(enabled).click();
    }

    public void click(SelenideElement element) {
        element.shouldBe(enabled).click();
    }
    public void clickVisible(SelenideElement element) {
        element.shouldBe(visible).click();
    }


}
