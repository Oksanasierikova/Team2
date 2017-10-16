package org.KsushaS.Landstar;

import org.KsushaS.BaseWebDriverTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogIn extends BaseWebDriverTest{
    public WebDriver driver;
    public WebDriverWait wait;
    private long DEFAULT_TIMEOUT = 5;
    private static final String SITE_URL = "http://test.imbatransport.com/login";
    private static final String EMAIL = "Email";
    private static final String PASSW = "Password";
    private static final String SUBMIT = "//button[@type='submit']";

    public LogIn(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    public LogIn navigate() {
        driver.get(SITE_URL);
        return this;
    }

    public OfficesList login(String email, String passw) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(EMAIL))).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PASSW))).sendKeys(passw);
        WebElement element = driver.findElement(By.xpath(SUBMIT));
        element.click();
        return new OfficesList(driver);
    }

}
