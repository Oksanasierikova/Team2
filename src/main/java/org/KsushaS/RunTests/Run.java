package org.KsushaS.RunTests;

import org.KsushaS.BaseWebDriverTest;
import org.KsushaS.Landstar.AddOffice;
import org.KsushaS.Landstar.LogIn;
import org.KsushaS.Landstar.OfficesList;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class Run extends BaseWebDriverTest {

    @DataProvider(name = "login")
    public Object[][] login() {
        return new Object[][]{{"osierikova@devsymmetrix.com", "Q1w2e3r4"}};
    }


    @Test(dataProvider = "login", enabled = true)
    public void logInToSite(String email, String passw) {
        LogIn site = new LogIn(driver).navigate().login(email, passw);
        OfficesList officesList = new OfficesList(driver);
        softAssert.assertTrue(officesList.Breadcrumbs().contains("Office"));
        softAssert.assertAll();
    }

    @Test(dataProvider = "login"/*, dependsOnMethods = {"logInToSite"}*/, enabled = true)
    public void LogOut(String email, String passw) throws InterruptedException {
        LogIn site = new LogIn(driver).navigate().login(email, passw);
        OfficesList officesList = new OfficesList(driver);
        officesList.Breadcrumbs();
        softAssert.assertTrue(officesList.Breadcrumbs().contains("Office"));
        officesList.logout();
        softAssert.assertAll();
    }

    @Test(dataProvider = "login")
    public void RedirectToViewOffice(String email, String passw) throws InterruptedException {
        LogIn site = new LogIn(driver).navigate().login(email, passw);
        OfficesList officesList = new OfficesList(driver);
        //officesList.viewOffice().getBreacrumb();
        softAssert.assertTrue(officesList.viewOffice().getBreacrumb().contains("Fabrika"));
        softAssert.assertAll();
    }

    @Test(dataProvider = "login")
    public void ClickAddOffice(String email, String passw) throws InterruptedException {
        LogIn site = new LogIn(driver).navigate().login(email, passw);
        OfficesList officesList = new OfficesList(driver);
        officesList.addOffice();
        AddOffice addOffice = new AddOffice(driver);
        softAssert.assertTrue(addOffice.getBreadcrumbs().contains("Office info"));
        softAssert.assertAll();
    }
}
