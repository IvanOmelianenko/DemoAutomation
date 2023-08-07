import org.testng.annotations.Test;
import po.SearchPage;

import static org.testng.AssertJUnit.assertEquals;

public class SearchTest extends BaseTest {

    SearchPage search = new SearchPage();
    @Test
    void shouldBeVisibleResultSearch() {
        search.fillText("Ubisoft");
        search.pressEnter();

        assertEquals("Ubisoft", search.getTitle());
    }
}
