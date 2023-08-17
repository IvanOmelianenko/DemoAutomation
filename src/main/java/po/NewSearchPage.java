package po;

import base.BaseMethod;
import org.openqa.selenium.By;

public class NewSearchPage extends BaseMethod {

    private String searchValue;

    private final By searchField = By.xpath("//div//textarea[@class='gLFyf']");

    private final By googleSearch = By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@class='gNO89b']");

    private final By searchResult = By.xpath("//span[@class='OSrXXb']");

    public NewSearchPage enterSearchValue(String searchValue) {
        this.searchValue= searchValue;
        send(searchField, searchValue);
        return this;
    }

//    public NewSearchPage enterText(String text) {
//        send(searchField, text);
//        return this;
//    }

    public NewSearchPage clickSearch() {
        click(googleSearch);
        return this;
    }

    public String getResult() {
        return getTextFromElement(searchResult);
    }



}
