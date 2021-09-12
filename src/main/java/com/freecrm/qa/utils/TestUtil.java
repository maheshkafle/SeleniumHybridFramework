package com.freecrm.qa.utils;

import com.freecrm.qa.base.TestBase;

public class TestUtil extends TestBase {
    // Lets say our site is taking long time to load then we need to change value then
    // in that scenario its better to put this value in one place and it becomes easy to
    // change them
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    public void switchToFrame(){

        driver.switchTo().frame("mainpanel");
    }
}
