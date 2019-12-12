package tests.day20_ddt_with_excel;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.TestBase;
import utils.BrowserUtils;
import utils.Driver;
import utils.ExcelUtil;

import java.util.Arrays;
import java.util.Map;

public class Practice extends TestBase {
    @DataProvider(name = "credentials")
    public static Object[][] credentials(){
        ExcelUtil qa1 = new ExcelUtil("vytrack_testusers.xlsx","QA1-short");
        return qa1.getDataArray();
    }
    //username  password   firstname  lastname   result
    @Test(dataProvider = "credentials", description = "Login Page test with credentials")
    public void LoginTest(String username, String password, String firstname, String lastname, String result){
        extentTest = extentReports.createTest("Login as "+username);
        if (username.equals("username")){
            throw new SkipException("Test was skipped because it's first row!");
        }else {
            LoginPage loginPage = new LoginPage();
            loginPage.login(username,password);
            BrowserUtils.waitForPageTitle("Dashboard");
            Assert.assertEquals(Driver.get().getTitle(),"Dashboard");
            extentTest.pass("Login test passed for user "+username);
        }
    }

    public static void main(String[] args) {
        ExcelUtil excelUtil = new ExcelUtil("vytrack_testusers.xlsx","QA1-short");
        System.out.println("Column names: "+excelUtil.getColumnsNames());
        System.out.println("Rows: "+excelUtil.rowCount());
        excelUtil.setCellData("Aibek",4,2);
        System.out.println(excelUtil.getCellData(5,2));
        System.out.println(excelUtil.rowCount());

        for (Map<String, String>map : excelUtil.getDataList()){
            System.out.print(map.get("username")+" ");
            System.out.println(map.get("password"));
        }
    }
}
