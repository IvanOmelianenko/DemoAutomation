package selenide;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import selenide.po.ActionsPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ActionsTest {

    @Test
    public  void doubleClickANdContextClickButtonCheck() {
        open("https://demoqa.com/buttons");
        getWebDriver().manage().window().maximize();

        new ActionsPage()
                .clickDoubleClick()
                .clickContextClick();

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(new ActionsPage().getDoubleClickTextButton().shouldBe(visible).getText())
                .as("The text of clicked double click was not found")
                .isEqualTo("You have done a double click");

        softly.assertThat(new ActionsPage().getContextClickTextButton().shouldBe(visible).getText())
                .as("The text of clicked context click was not found")
                .isEqualTo("You have done a right click");

        softly.assertAll();
    }

    @Test
    public void dragAndDropElementTest() {
        open("https://demoqa.com/droppable");
        getWebDriver().manage().window().maximize();

        new ActionsPage()
                .dragAndDropElement();

        assertThat(new ActionsPage().dropped().shouldBe(visible).getText())
                .as("The text is not visible")
                .isEqualTo("Dropped!");

    }
}
