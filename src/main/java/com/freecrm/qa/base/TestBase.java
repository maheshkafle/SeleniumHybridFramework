package com.freecrm.qa.base;

import com.freecrm.qa.utils.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    static WebDriver driver;
    // intialized prop variable
    static Properties prop;

    public TestBase(){

        // read properties from config/config.properties
        try{
            prop = new Properties();
            FileInputStream input = new FileInputStream("config.properties");
            prop.load(input);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void initialization(){
        String browserName = prop.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();

        }
        else if(browserName.equals("FF")){
            System.setProperty("webdriver.gekco.driver", "geckodriver.exe");
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));

    }
}
