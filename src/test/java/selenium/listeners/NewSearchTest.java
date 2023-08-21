package selenium.listeners;

import selenium.builder.SearchPageBuilder;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.po.NewSearchPage;


public class NewSearchTest extends BaseTest {


//    NewSearchPage newSearch = new NewSearchPage();

    @BeforeMethod
    public void open() {
        driver.get("https://google.com");
        driver.manage().window().maximize();

    }

    SoftAssertions softly = new SoftAssertions();
    @Test
    void visibleSearchLink() {

        NewSearchPage googleSearch = new SearchPageBuilder()
                .withSearchValue("Hillel")
                        .build();

        new NewSearchPage()
                .clickSearch();

        softly.assertThat(new NewSearchPage().getResult())
                .as("The result link is appeared")
                .isEqualTo("kharkiv.ithillel.ua");

        softly.assertAll();

    }

}
