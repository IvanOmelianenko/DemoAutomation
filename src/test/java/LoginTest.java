import org.testng.annotations.Test;
import po.LoginPage;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends BaseTest {

    LoginPage login = new LoginPage();

    @Test
    void checkDisplayingLogin() {
        login.clickOnLogin();
        login.fillNickname("DemoJavaTest");
        login.fillPass("selenium2023");
        login.clickOnSignIn();

        assertEquals("DemoJavaTest", login.getLogin());

    }
}
