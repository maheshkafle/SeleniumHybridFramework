package com.freecrm.qa.testcases;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.*;
import com.freecrm.qa.utils.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    DealsPage dealsPage;
    TasksPage tasksPage;

    public HomePageTest(){
        // BaseClass constructor will be called and properties will be initialized
        super();
    }

    @BeforeMethod
    public void setUp(){

        initialization();
        testUtil = new TestUtil();
        loginPage =  new LoginPage();
        contactsPage = new ContactsPage();
        dealsPage = new DealsPage();
        tasksPage = new TasksPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    /*
        TestCases should be independent of each other
        Note: Before each test case launch the browser, login to browser, execute test case and close it.
    */

    @Test(priority = 1)
    public void verifyHomePageTitleTest(){

        String homePageTitle = homePage.verifyHomePageTitle();
        System.out.println(homePageTitle);
        Assert.assertEquals(homePageTitle, "CRMPRO", "Home Page Title Not Matched");
    }


    @Test(priority = 2)
    public void verifyActualUserNameTest() {

        testUtil.switchToFrame();
        System.out.println(homePage.verifyActualUserName());
        Assert.assertTrue(homePage.verifyActualUserName());
    }

    @Test(priority = 3)
    public void verifyContactsLinkTest() {

        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();

    }

//    @Test(priority = 4)
//    public void verifyDealsLinkTest() {
//
//        testUtil.switchToFrame();
//        dealsPage = homePage.clickOnDealsLink();
//    }

//    @Test(priority = 5)
//    public void verifyTasksLinkTest() {
//
//        testUtil.switchToFrame();
//        tasksPage = homePage.clickOntasksLink();
//    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
