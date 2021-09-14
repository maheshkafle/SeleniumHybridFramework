package com.freecrm.qa.utils;

import com.freecrm.qa.base.TestBase;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// This method accepts excel sheet , reads row wise and stores it in 2D object data type and and returns it
public class TestUtil extends TestBase {
    // Lets say our site is taking long time to load then we need to change value then
    // in that scenario its better to put this value in one place and it becomes easy to
    // change them
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    public static String TESTDATA_SHEET_PATH = "freecrmtestdata.xlsx";

    static Workbook book;
    static Sheet sheet;

    public void switchToFrame(){

        driver.switchTo().frame("mainpanel");
    }

    public static Object[][] getTestData(String sheetName){

        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        try {
            //XSSFWorkbook book = new XSSFWorkbook(file);
            //book = WorkbookFactory.create(file);
            book = new XSSFWorkbook(file);
        }
        catch (InvalidFormatException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        //System.out.println(sheet.getLastRowNum() + "-------" + sheet.getRow(0).getLastCellNum());
        for (int i=0; i < sheet.getLastRowNum(); i++){
            for (int k=0; k < sheet.getRow(0).getLastCellNum(); k++){
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                //System.out.println(data[i][k]);
            }
        }
        return data;
    }

    // Method to take screenshot if an exception occurs under screenshots folder and gets called from WebEventListener class
    public static void takeScreenshotAtEndOfTest() throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");

        FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }
}
