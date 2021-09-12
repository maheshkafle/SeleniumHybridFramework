package com.freecrm.qa.testcases;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.pages.*;
import com.freecrm.qa.utils.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    public ContactsPageTest(){
        // BaseClass constructor will be called and properties will be initialized
        super();
    }

    @BeforeMethod
    public void setUp(){

        initialization();
        testUtil = new TestUtil();
        loginPage =  new LoginPage();
        contactsPage = new ContactsPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
    }

    /*
        TestCases should be independent of each other
        Note: Before each test case launch the browser, login to browser, execute test case and close it.
    */

    @Test(priority = 1)
    public void verifyContactsLabelTest(){
        Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label is missing on the Page");
    }


    @Test(priority = 2)
    public void selectContactsTest() {
        contactsPage.selectContactsByName("test1 test2");
    }

    @Test(priority = 2)
    public void selectMultipleContactsTest() throws InterruptedException {
        contactsPage.selectContactsByName("test1 test2");
        Thread.sleep(2000);
        contactsPage.selectContactsByName("smarshqa mahesh1");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
