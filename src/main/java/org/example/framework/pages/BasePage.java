package org.example.framework.pages;

import org.example.framework.managers.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriverWait wait = new WebDriverWait(DriverManager.getDriverManager().getDriver(),
            Duration.ofSeconds(10));

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriverManager().getDriver(), this);
    }

    public WebElement waitUntilElementToBeVisible(WebElement element) {
        return wait.until((ExpectedConditions.visibilityOf(element)));
    }

    public void fillInputField(WebElement field, String value) {
        waitUntilElementToBeVisible(field).click();
        field.sendKeys(value);
    }

}
