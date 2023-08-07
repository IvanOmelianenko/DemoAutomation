package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static config.WebDriverInit.getDriver;

public class BaseMethod {

    public WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), 10);
    }
    protected void click(By locator) {
        getWait().until(d -> d.findElement(locator)).click();
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
        return new WebDriverWait(getDriver(), time);
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
