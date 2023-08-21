package selenide;

import org.testng.annotations.Test;
import selenide.po.LoginPage;
import selenide.po.SearchPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginTest {

    @Test
    public void shouldBeVisibleNickname() {
        open("https://ru.wikipedia.org/");
        getWebDriver().manage().window().maximize();
        new LoginPage()
                .clickLoginButton()
                .fillLogin("DemoJavaTest")
                .fillPassword("selenium2023")
                .clickSignInButton();

        assertThat( new LoginPage().getNickname().shouldBe(visible).getText())
                .as( "Nickname is displayed")
                .isEqualTo("DemoJavaTest");

    }
}
