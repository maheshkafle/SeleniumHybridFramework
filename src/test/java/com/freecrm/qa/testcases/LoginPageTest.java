package com.freecrm.qa.testcases;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    // Global variables so that we can use throughout this class
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest(){
        // Calls TestBase Class constructor and this will initialize all the properties
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
        System.out.println("Actual Title-->"+title); //CRMPRO  - CRM software for customer relationship management, sales, and support.
        Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");

    }

    @Test(priority = 3)
    public void crmLogoImageTest(){
        boolean flag = loginPage.validateCRMLogo();
        Assert.assertTrue(flag);
    }

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
