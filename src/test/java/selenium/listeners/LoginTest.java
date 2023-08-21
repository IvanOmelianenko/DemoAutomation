package selenium.listeners;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.po.LoginPage;


public class LoginTest extends BaseTest {

    LoginPage login = new LoginPage();
    @BeforeMethod
    public void open() {
        driver.get("https://ru.wikipedia.org/");
        driver.manage().window().maximize();
    }

    SoftAssertions softly = new SoftAssertions();

    @Test(groups = {"Smoke"})
    void checkDisplayingLogin() {
        login.clickOnLogin();
        login.fillNickname("DemoJavaTest");
        login.fillPass("selenium2023");
        login.clickOnSignIn();

        softly.assertThat(login.getLogin())
                .as("The result nickname is appeared")
                .isEqualTo("DemoJavaTest");

        softly.assertAll();


    }

    @Test(groups = {"Regression"}, dataProvider = "not-valid-password")
    void checkInvalidPassword(String invalidPassword) {
        login.clickOnLogin();
        login.fillNickname("DemoJavaTest");
        login.fillPass(invalidPassword);
        login.clickOnSignIn();



        softly.assertThat(login.getErrorMessage())
                .as("Error message about password is invalid is appeared")
                .isEqualTo("Введены неверные имя участника или пароль.\n" +
                        "Попробуйте ещё раз.");

        softly.assertAll();


    }

    @Test(groups = {"Regression"}, dataProvider = "not-valid-login")
    void checkInvalidLogin(String invalidLogin) {
        login.clickOnLogin();
        login.fillNickname(invalidLogin);
        login.fillPass("selenium2023");
        login.clickOnSignIn();

        softly.assertThat(login.getErrorMessage())
                .as("Error message about login is invalid is appeared")
                .isEqualTo("Введены неверные имя участника или пароль.\n" +
                        "Попробуйте ещё раз.");

        softly.assertAll();

    }

    @DataProvider(name = "not-valid-password")
    public Object[][] getInvalidPasswords() {
        return new Object[][] {
                {"    "},
                {"3232322"},
                {"№;%:?:&*()!"}
        };
    }

    @DataProvider(name = "not-valid-login")
    public Object[][] getInvalidLogin() {
        return new Object[][] {
                {"DemoJava"},
                {"dfdsf"},
                {"fdsfdsfds"}
        };
    }

}
