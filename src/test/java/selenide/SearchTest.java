package selenide;


import org.testng.annotations.Test;
import selenide.po.SearchPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchTest {



    @Test
    void shouldBeVisibleArticleKyiv() {
        open("https://ru.wikipedia.org/");
        getWebDriver().manage().window().maximize();
        new SearchPage()
                .fillSearch("Ubisoft Kyiv")
                .clickEnter()
                .clickFirstArticle();


        assertThat( new SearchPage().getHeaderArticle().shouldBe(visible).getText())
                .as( "The header of Ubisoft Kyiv")
                .isEqualTo("Ubisoft Kyiv");


    }
}
