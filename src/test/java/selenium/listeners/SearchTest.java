package selenium.listeners;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.po.SearchPage;



public class SearchTest extends BaseTest {

    SearchPage search = new SearchPage();

    @BeforeMethod
    public void open() {
        driver.get("https://ru.wikipedia.org/");
        driver.manage().window().maximize();

    }

    SoftAssertions softly = new SoftAssertions();
    @Test
    void shouldBeVisibleResultSearch() {
        search.fillText("Ubisoft office");
        search.pressEnter();
        search.clickArticle();

        softly.assertThat(search.getTitle())
                .as("The result title is appeared")
                .isEqualTo("Ubisoft Poland");

        softly.assertAll();

    }
}
