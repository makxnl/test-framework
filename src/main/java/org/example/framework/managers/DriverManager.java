package org.example.framework.managers;

import org.example.framework.utils.PropConst;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.example.framework.utils.PropConst.PATH_CHROME_DRIVER_WINDOWS;
import static org.example.framework.utils.PropConst.PATH_GECKO_DRIVER_WINDOWS;

public class DriverManager {

    private WebDriver driver;

    private static DriverManager INSTANCE = null;

    private final TestPropertiesManager propManager = TestPropertiesManager.getTestPropertiesManager();

    private DriverManager() {
    }

    public static DriverManager getDriverManager() {
        if (INSTANCE == null) {
            INSTANCE = new DriverManager();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    private void initDriver() {
        initDriverWindowsOsFamily();
    }

    private void initDriverWindowsOsFamily() {
        initDriverAnyOsFamily(PATH_GECKO_DRIVER_WINDOWS, PATH_CHROME_DRIVER_WINDOWS);
    }

    private void initDriverAnyOsFamily(String gecko, String chrome) {
        switch (propManager.getProperty(PropConst.TYPE_BROWSER)) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", propManager.getProperty(gecko));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", propManager.getProperty(chrome));
                driver = new ChromeDriver();
                break;
            default:
                Assertions.fail("Типа браузера '" + propManager.getProperty(PropConst.TYPE_BROWSER)
                        + "' не существует во фреймворке");
        }
    }

    public void quitDriver() {
        driver.quit();
    }

}
