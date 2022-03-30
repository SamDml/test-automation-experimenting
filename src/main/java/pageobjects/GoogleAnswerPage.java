package pageobjects;

import config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleAnswerPage extends Page {

    private final By answerCssSelector = By.cssSelector("div[data-tts= 'answers']");

    public GoogleAnswerPage(WebDriverConfig webDriverConfig) {
        super(webDriverConfig);
    }

    public String retrieveSearchResult() {
        WebElement answerElement = getElementWaitVisible(answerCssSelector);
        return answerElement.getAttribute("data-tts-text");
    }

}
