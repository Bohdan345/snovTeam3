package Pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static ReadData.DataFromProperty.*;
import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {

    private static final SelenideElement signInWithGoogle = $x("//a[@class='google-sign-up google-register']");
    private static final SelenideElement loginField = $x("//input[@id='email']");
    private static final SelenideElement passwordField = $x("//input[@id='password']");
    private static final SelenideElement loginButton = $x("//button[@id='buttonFormLogin']");
    private static final SelenideElement loginHeaderText = $x("//a[text()='Forgot Your Password?']");
    private static final SelenideElement snovLoginLogo = $x("//img[@class='brand-img']");
    private static final SelenideElement snovLogo = $x("//div[@class = 'app-header__logo']");

    BasePage basePage = new BasePage();


    public void goToLoginPage() {
        basePage.startBrowser(URL);
        snovLoginLogo.shouldBe(Condition.visible);
    }


    public void setLoginField() {

        loginField.setValue(USER_LOGIN);
    }

    public void setPasswordField() {

        passwordField.setValue(USER_PASSWORD);
    }

    public void pressLoginButton() {

        loginButton.click();
    }

    public void login() {


        goToLoginPage();

        setLoginField();

        setPasswordField();

        pressLoginButton();




    }
}
