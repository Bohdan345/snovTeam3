package Elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;

public class InputField {

    public void cleanInput(SelenideElement element) {
        element.shouldBe(visible).clear();
    }

    public void setValue(SelenideElement element, String text) {
        element.shouldBe(visible).setValue(text);
    }

    public void setValueAndPressEnter(SelenideElement element, String text) {
        element.shouldBe(visible).val(text).pressEnter();
    }


}

