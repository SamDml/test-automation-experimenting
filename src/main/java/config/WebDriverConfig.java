package config;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

public class WebDriverConfig {

    @Getter
    private WebDriver webDriver;

    static {
        setWebDriverSystemProperties();
    }

    public WebDriverConfig() {
        setWebDriver();
    }

    private final void setWebDriver() {
        webDriver = new ChromeDriver();
    }

    private static final void setWebDriverSystemProperties() {

        try {
            Path chromedriver = Paths.get("bin/webdrivers/windows/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", chromedriver.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
