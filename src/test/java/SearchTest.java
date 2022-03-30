import config.WebDriverConfig;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import pageobjects.GoogleAnswerPage;
import pageobjects.GoogleSearchPage;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.text.IsEmptyString.emptyOrNullString;

@Slf4j
public class SearchTest {

    @Test
    public void searchQueryReturnsString() {

        String searchQuery = "What is the distance to the sun?";

        log.info("Search query: {}", searchQuery);

        WebDriverConfig webDriverConfig = new WebDriverConfig();

        GoogleSearchPage googleSearchPage = new GoogleSearchPage(webDriverConfig);
        googleSearchPage.navigate();
        googleSearchPage.clickAcceptConditions();

        GoogleAnswerPage googleAnswerPage = googleSearchPage.insertSearchQueryAndHitEnter(searchQuery);
        String searchResult = googleAnswerPage.retrieveSearchResult();
        googleAnswerPage.closePage();

        org.hamcrest.MatcherAssert.assertThat(searchResult, is(not(emptyOrNullString())));

        log.info("Search result: {}", searchResult);

    }
}
