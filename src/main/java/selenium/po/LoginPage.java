package selenium.po;

import selenium.base.BaseMethod;
import org.openqa.selenium.By;

public class LoginPage extends BaseMethod {

    private final By login = By.xpath("//a[@accesskey='o']//span");
    private final By fillLogin = By.xpath("//input[@id='wpName1']");
    private final By fillPassword = By.xpath("//input[@name='wpPassword']");
    private final By clickSignIn = By.xpath("//button[@name='wploginattempt']");

    private final By nickName = By.xpath("//a[span='DemoJavaTest']");

    private final By invalidData = By.xpath("//div[@class='cdx-message__content']");

    public void clickOnLogin() {
        click(login);
    }

    public void fillNickname(String text) {
        send(fillLogin, text);
    }
    public void fillPass(String text) {
        send(fillPassword, text);
    }
    public void clickOnSignIn() {
        click(clickSignIn);
    }

    public String getLogin() {
        return getTextFromElement(nickName);
    }

    public String getErrorMessage() {
        return getTextFromElement(invalidData);
    }

}
