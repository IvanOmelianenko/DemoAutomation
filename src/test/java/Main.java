import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertEquals;

public class Main {
    public static void main(String[] args) {
        By search = By.xpath("//input[@name='search']");
        By result = By.xpath("//h1//span");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://en.wikipedia.org/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.presenceOfElementLocated(search)).sendKeys("Ubisoft");
//        wait.until(d -> d.findElement(search)).sendKeys(Keys.ENTER);
        sendElement(driver, search, "Ubisoft");
        pressEnter(driver, search);

        assertEquals("", getTextFromElement(driver, result));





        driver.quit();
    }
    static void sendElement(WebDriver driver, By search, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(search)).sendKeys(text);
    }
    static void pressEnter(WebDriver driver, By search) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(d -> d.findElement(search)).sendKeys(Keys.ENTER);
    }
    static String getTextFromElement(WebDriver driver, By search) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(d -> d.findElement(search)).getText();
    }

}
