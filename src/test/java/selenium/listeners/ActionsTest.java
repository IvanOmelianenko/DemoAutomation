package selenium.listeners;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selenium.po.ActionsPage;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ActionsTest extends BaseTest {

    @Test
    public  void checkDoubleAndContextClick() {
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();
        new ActionsPage()
                .clickDoubleClick()
                .clickRightClick();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(new ActionsPage().getDoubleText())
                .as("The text is not visible")
                .isEqualTo("You have done a double click");

        softly.assertThat(new ActionsPage().getRightClickText())
                .as("The text is not visible")
                .isEqualTo("You have done a right click");

        softly.assertAll();
    }

    @Test
    public void getTextFromFrame() {
        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();

        WebElement frame = driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(frame);
        assertThat(new ActionsPage().getTextFromFrame())
                .as("Selenium located not into frame")
                .isEqualTo("This is a sample page");
        driver.switchTo().defaultContent();

        assertThat(new ActionsPage().getFramesHeader())
                .as("Selenium located into frame")
                .isEqualTo("Frames");
    }

    @Test
    public void getTextFromNestedFrame() {
        driver.get("https://demoqa.com/nestedframes");
        driver.manage().window().maximize();

        WebElement frame = driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(frame);
        WebElement nestedframe = driver.findElement(By.xpath("//html//body//iframe[@srcdoc]"));
        driver.switchTo().frame(nestedframe);
        assertThat(new ActionsPage().getTextFromNestedFrame())
                .as("Selenium located not into frame")
                .isEqualTo("Child Iframe");



    }

    @Test
    public void uploadFileTest() {
        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();

        new  ActionsPage()
                .uploadFile("C:\\Users\\ivom\\IdeaProjects\\TestNG\\untitled1\\text.txt");


    }

    @Test
    public void getTextFromTable() {
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();

        assertThat(new ActionsPage().getTextFromTable(1, 1))
                .as("Text isn't equals")
                .isEqualTo("Insurance");
    }



}
