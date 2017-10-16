package org.KsushaS.Landstar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ViewOffice extends OfficesList{

    private static final String BREADCRUMB = "//strong[text()='Fabrika']";

    public ViewOffice(WebDriver driver) {
        super(driver);
    }

    public String getBreacrumb(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BREADCRUMB))).getText();
    }

}
