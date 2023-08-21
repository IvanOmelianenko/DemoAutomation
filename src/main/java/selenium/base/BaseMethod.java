package selenium.base;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.config.WebDriverInit;
import static java.time.Duration.ofSeconds;



public class BaseMethod {

    public WebDriverWait getWait() {
        return new WebDriverWait(WebDriverInit.getDriver(), ofSeconds(10));
    }

    protected Actions getAction() {
        return new Actions(WebDriverInit.getDriver());
    }
    protected void click(By locator) {
        getWait().until(d -> d.findElement(locator)).click();
    }

    protected void doubleClick(By locator) {
        WebElement doubleElement = getWait().until(d -> d.findElement(locator));
        getAction().doubleClick(doubleElement).build().perform();
    }
    protected void contextClick(By locator) {
        WebElement contextClick = getWait().until(d -> d.findElement(locator));
        getAction().contextClick(contextClick).build().perform();
    }
    protected void send(By search, String text) {
        getWait().until(ExpectedConditions.presenceOfElementLocated(search)).sendKeys(text);
    }
    protected void pressEnter(By search) {
        getWait().until(d -> d.findElement(search)).sendKeys(Keys.ENTER);
    }
    protected String getTextFromElement(By search) {
        return getWait().until(d -> d.findElement(search)).getText();
    }

    protected WebDriverWait getWait(int time) {
        return new WebDriverWait(WebDriverInit.getDriver(), ofSeconds(time));
    }
    protected void sendElement(By search, String text, int time) {
        getWait(time).until(ExpectedConditions.presenceOfElementLocated(search)).sendKeys(text);
    }
    protected void pressEnter(By search, int time) {
        getWait(time).until(d -> d.findElement(search)).sendKeys(Keys.ENTER);
    }
    protected String getTextFromElement(By search, int time) {
        return getWait(time).until(d -> d.findElement(search)).getText();
    }

}
