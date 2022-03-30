import config.WebDriverConfig;
import org.testng.annotations.Test;
import pageobjects.GoogleAnswerPage;
import pageobjects.GoogleSearchPage;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.text.IsEmptyString.emptyOrNullString;

public class SearchTest {

    @Test
    public void searchQueryReturnsString() {

        String searchQuery = "What is the distance to the sun?";

        System.out.println("Search query: " + searchQuery);

        WebDriverConfig webDriverConfig = new WebDriverConfig();

        GoogleSearchPage googleSearchPage = new GoogleSearchPage(webDriverConfig);
        googleSearchPage.navigate();
        googleSearchPage.clickAcceptConditions();

        GoogleAnswerPage googleAnswerPage = googleSearchPage.insertSearchQueryAndHitEnter(searchQuery);
        String searchResult = googleAnswerPage.retrieveSearchResult();
        googleAnswerPage.closePage();

        System.out.println("Search result: " + searchResult);

        org.hamcrest.MatcherAssert.assertThat(searchResult, is(not(emptyOrNullString())));

    }
}
