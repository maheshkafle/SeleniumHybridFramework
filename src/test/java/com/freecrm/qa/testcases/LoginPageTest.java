package com.freecrm.qa.testcases;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import org.apache.commons.logging.Log;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest(){
        // Calls TestBase Class constructor
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage =  new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() throws InterruptedException {
        String title = loginPage.validateLoginPageTitle();
        Thread.sleep(3000);
        Assert.assertEquals(title, "Cogmento CRM");
    }

//    @Test(priority = 2)
//    public void validateCRMImageTest(){
//        boolean flag = loginPage.validateCRMImage();
//        Assert.assertTrue(flag);
//    }

    @Test(priority = 2)
    public void LoginTest() throws InterruptedException {
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        Thread.sleep(3000);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
