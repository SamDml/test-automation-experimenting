package pageobjects;

import config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {

    final WebDriverConfig webDriverConfig;

    Page(WebDriverConfig webDriverConfig) {
        this.webDriverConfig = webDriverConfig;
    }

    public WebElement getElementWaitVisible(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriverConfig.getWebDriver(), Duration.ofSeconds(20));
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void closePage() {
        webDriverConfig.getWebDriver().close();
    }

}
