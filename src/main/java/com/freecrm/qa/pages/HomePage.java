package com.freecrm.qa.pages;

import com.freecrm.qa.base.TestBase;
import com.freecrm.qa.utils.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class HomePage extends TestBase {

    @FindBy(xpath = "//td[contains(text(), 'User: Smarshqa mahesh')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//a[contains(text(), 'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath = "//a[contains(text(), 'New Contact')]")
    WebElement newContactsLink;

    @FindBy(xpath = "//a[contains(@text(), 'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath = "//a[contains(@text(), 'Tasks')]")
    WebElement tasksLink;

    // Initializing the Page Objects
    public HomePage(){

        PageFactory.initElements(driver, this);
    }

    public String  verifyHomePageTitle(){

        return driver.getTitle();
    }

    public boolean verifyActualUserName(){

        boolean flag = userNameLabel.isDisplayed();
        return flag;
    }

    public ContactsPage clickOnContactsLink(){

        //testU
        contactsLink.click();
        return new ContactsPage();
    }


    public DealsPage clickOnDealsLink(){

        dealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickOntasksLink(){
        tasksLink.click();
        return new TasksPage();
    }

    public void clickOnNewContactLink(){
        //testUtil.switchToFrame();
        Actions action = new Actions(driver);
        action.moveToElement(contactsLink).build().perform();

        newContactsLink.click();
    }
}
