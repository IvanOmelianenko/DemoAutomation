package selenium.po;

import selenium.base.BaseMethod;
import selenium.base.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ActionsPage extends BaseMethod {

private final By doubleClick = By.xpath("//button[@id='doubleClickBtn']");

private final By contextClick = By.xpath(("//button[@id='rightClickBtn']"));

private final By getDoubleClicktext = By.xpath("//p[@id='doubleClickMessage']");

private final By getContextClickText = By.xpath("//p[@id='rightClickMessage']");

private final By textFromFrame = By.xpath("//h1[@id='sampleHeading']");

private final By framesHeader = By.xpath("//div[@class='main-header']");

private final By textFromNestedFrame = By.xpath("/html/body/p");

private final By upload = By.xpath("//input[@id='uploadFile']");

private final By table = By.xpath("//div[@class='rt-tbody']");

public String getTextFromTable(int row, int column) {
    WebElement tableTmp = getWait().until(d -> d.findElement(table));
    Table table1 = new Table(tableTmp);
    return table1.getValue(row, column);

}



public ActionsPage uploadFile(String path) {
    send(upload, path);
    return this;
}

public String getTextFromNestedFrame() {
    return getTextFromElement(textFromNestedFrame);
}

public String getFramesHeader() {
    return getTextFromElement(framesHeader);
}

    public String getTextFromFrame() {
        return getTextFromElement(textFromFrame);
    }

public ActionsPage clickDoubleClick() {
    doubleClick(doubleClick);
    return this;
}

public ActionsPage clickRightClick() {
    contextClick(contextClick);
    return this;
}

public String getDoubleText() {
    return getTextFromElement(getDoubleClicktext);
}

    public String getRightClickText() {
        return getTextFromElement(getContextClickText);
    }




}
