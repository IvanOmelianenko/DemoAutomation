package builder;

import base.BaseMethod;
import po.NewSearchPage;

public class SearchPageBuilder extends BaseMethod {

    private String searchValue;

    public SearchPageBuilder withSearchValue(String searchValue) {
        this.searchValue = searchValue;
        return this;
    }

    public NewSearchPage build() {
        return new NewSearchPage()
                .enterSearchValue(searchValue);
    }
}






