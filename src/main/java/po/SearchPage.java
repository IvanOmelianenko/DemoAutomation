package po;
import base.BaseMethod;
import org.openqa.selenium.By;

public class SearchPage extends BaseMethod {
    private final By search = By.xpath("//input[@name='search']");
    private final By result = By.xpath("//h1//span");

        public void fillText(String text) {
            send(search, text);
        }
        public void pressEnter() {
            pressEnter(search);
        }
        public String getTitle() {
            return getTextFromElement(result);
        }
}
