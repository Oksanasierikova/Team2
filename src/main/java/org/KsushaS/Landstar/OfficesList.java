package org.KsushaS.Landstar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class OfficesList extends LogIn{
    private static final String BREADCRUMB = "//div[contains(text(),'Offices')]";
    private static final String LOGOUT = "//i[@class='fa fa-sign-out']";
    private static final String EMAIL = "Email";
    private static final String VIEWOFFICE = "//a[@href='/offices/office/view/1']";
    private static final String ADDOFFICE = "//a[@class='btn btn-sm btn-white']";

    public OfficesList(WebDriver driver) {
        super(driver);
    }

    public String Breadcrumbs (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BREADCRUMB))).getText();
    }

    public LogIn logout() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(LOGOUT));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGOUT)));
        Thread.sleep(1000);
        element.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(EMAIL)));
        return new LogIn(driver);
    }

    public ViewOffice viewOffice() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(VIEWOFFICE));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(VIEWOFFICE)));
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
        //element.click();
        return new ViewOffice(driver);
    }

    public AddOffice addOffice() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath(ADDOFFICE));
        Thread.sleep(1000);
        element.click();
        return new AddOffice(driver);
    }

}
