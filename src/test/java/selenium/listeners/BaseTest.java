package selenium.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static selenium.config.WebDriverInit.closedDriver;
import static selenium.config.WebDriverInit.getDriver;

public class BaseTest {
    WebDriver driver = null;

    @BeforeMethod(groups = {"All", "Smoke", "Regression"})

    public void setUp() {
        driver = getDriver();
    }
    @AfterMethod(groups = {"All", "Smoke", "Regression"})
    public void tearDown() {
        closedDriver();

    }
}
