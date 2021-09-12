package com.freecrm.qa.pages;

import com.freecrm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.*;

public class LoginPage extends TestBase {

    // PageFactory - Object Repositories - Collection of WebElements - we use @FindBy TestNG annotation
    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//input[contains(@value, 'Login')]")
    WebElement loginBtn;

    @FindBy(xpath="//button[contains(text(), 'Sign Up']")
    WebElement signUpBtn;

    @FindBy(xpath = "//img[contains(@class, 'img-responsive')]")
    WebElement crmLogo;

    // Initializing the Page Objects with Constructor - Interview Question
    public LoginPage(){

        PageFactory.initElements(driver, this);

    }

    // Actions
    public String validateLoginPageTitle()  {

        return driver.getTitle();
    }

    public boolean validateCRMLogo() {

        return crmLogo.isDisplayed();
    }

    public HomePage login(String uname, String pwd){

        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginBtn.click();

        return new HomePage();
    }


}
