package com.freecrm.qa.pages;

import com.freecrm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.*;

public class LoginPage extends TestBase {

    // PageFactory - Object Repositories
    @FindBy(name="email")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(css=".fluid")
    WebElement loginBtn;

    @FindBy(xpath="//button[contains(text(), 'Sign Up']")
    WebElement signUpBtn;

    @FindBy(xpath="//img[contains(@class,'img-responsive')]")
    WebElement crmLogo;

    // Initializing the Page Objects
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    // Actions
    public String validateLoginPageTitle()  {
        return driver.getTitle();
    }

    public HomePage login(String uname, String pwd){
        username.sendKeys(uname);
        password.sendKeys(pwd);
        loginBtn.click();

        return new HomePage();
    }


}
