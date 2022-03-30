package pageobjects;

import config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage extends Page {

    private final By acceptConditionsButtonBy = By.id("L2AGLb");
    private final By searchFieldBy = By.name("q");
    private final By searchButtonBy = By.className("gNO89b");

    public GoogleSearchPage(WebDriverConfig webDriverConfig) {
        super(webDriverConfig);
    }

    public void navigate() {
        webDriverConfig.getWebDriver().navigate().to("https://www.google.com");
    }

    public void clickAcceptConditions() {
        WebElement acceptConditionsButton = getElementWaitVisible(acceptConditionsButtonBy);
        acceptConditionsButton.click();
    }

    public GoogleAnswerPage insertSearchQueryAndHitEnter(String searchQuery) {
        WebElement searchField = getElementWaitVisible(searchFieldBy);
        searchField.sendKeys(searchQuery);
        searchField.sendKeys(Keys.RETURN);

        GoogleAnswerPage googleAnswerPage = new GoogleAnswerPage(webDriverConfig);
        PageFactory.initElements(webDriverConfig.getWebDriver(), googleAnswerPage);

        return googleAnswerPage;
    }
    
}
