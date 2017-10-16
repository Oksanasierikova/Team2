package org.KsushaS.Landstar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddOffice extends OfficesList{
    private static final String TITLE = "div.ibox-title";

    public AddOffice(WebDriver driver) {
        super(driver);
    }

    public String getBreadcrumbs(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(TITLE))).getText();
    }


}
