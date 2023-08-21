package selenide.po;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    private final SelenideElement loginButton = $x("//a[@accesskey='o']//span");

    private final SelenideElement loginField = $x("//input[@id='wpName1']");

    private final SelenideElement passwordField = $x("//input[@id='wpPassword1']");

    private final SelenideElement signInButton = $x("//button[@id='wpLoginAttempt']");


    public SelenideElement getNickname() {
        return $x("//li[@id='pt-userpage']//a//span");
    }

    public LoginPage clickLoginButton() {
        loginButton.shouldBe(visible).click();
        return page(LoginPage.class);
    }

    public LoginPage fillLogin(String text) {
        loginField.shouldBe(visible).sendKeys(text);
        return page(LoginPage.class);
    }

    public LoginPage fillPassword(String text) {
        passwordField.shouldBe(visible).sendKeys(text);
        return page(LoginPage.class);
    }

    public LoginPage clickSignInButton() {
        signInButton.shouldBe(visible).click();
        return page(LoginPage.class);
    }

}
