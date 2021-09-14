package Pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static ReadData.DataFromProperty.*;
import static com.codeborne.selenide.Selenide.$x;


public class LoginPage {
    SelenideElement signInWithGoogle = $x("//a[@class='google-sign-up google-register']");
    SelenideElement loginField = $x("//input[@id='email']");
    SelenideElement passwordField = $x("//input[@id='password']");
    SelenideElement loginButton = $x("//button[@id='buttonFormLogin']");
    SelenideElement loginHeaderText = $x("//a[text()='Forgot Your Password?']");
    SelenideElement snovLoginLogo = $x("//img[@class='brand-img']");
    SelenideElement snovLogo = $x("//div[@class = 'app-header__logo']");

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

        snovLogo.shouldBe(Condition.visible);


    }
}
