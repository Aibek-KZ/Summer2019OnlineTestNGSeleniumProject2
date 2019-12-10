package SeleniumHomeworks.Homeworks4;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalendarEventsPage;
import pages.LoginPage;
import tests.TestBase;
import utils.BrowserUtils;
import utils.Driver;

public class TestCasesFrom9to12 extends TestBase {

    @Test(description = "Verify that following message as a summary is displayed: “Summary: Daily every 1 day”")
    public void test9(){
        extentTest=extentReports.createTest("Verify that following message as a summary is displayed: “Summary: Daily every 1 day”");

        LoginPage loginPage = new LoginPage();
        loginPage.login("storemanager85","UserUser123");
        loginPage.waitUntilLoaderMaskDisappear();

        loginPage.navigateTo("Activities","Calendar Events");
        loginPage.waitUntilLoaderMaskDisappear();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.clickToCreateCalendarEvent();
        loginPage.waitUntilLoaderMaskDisappear();

        Driver.get().findElement(By.xpath("//input[@data-name='recurrence-repeat']")).click();
        loginPage.waitUntilLoaderMaskDisappear();
        BrowserUtils.wait(2);
        Assert.assertTrue(Driver.get().findElement(By.xpath("//input[@data-name='recurrence-repeat']")).isSelected(),"“Repeat” checkbox is selected");
        Assert.assertTrue(Driver.get().findElement(By.xpath("//input[@checked='checked']")).isSelected()," 'Repeat Every' radio button is not selected");
        Assert.assertTrue(Driver.get().findElement(By.xpath("//input[@type='radio' and @checked='']")).isSelected(),"“Never” radio button is not selected");
        Assert.assertTrue(Driver.get().findElement(By.xpath("//span[text()='Daily every 1 day']")).isDisplayed());
        Assert.assertTrue(Driver.get().findElement(By.xpath("//label[text()='Summary:']")).isDisplayed());

        extentTest.pass("Verify that following message as a summary is displayed: “Summary: Daily every 1 day”");
    }

    @Test(description = "Verify that following message as a summary is displayed: “Summary: Daily every 1 day, end\n" +
                         "after 10 occurrences”")
    public void test10(){

        LoginPage loginPage = new LoginPage();
        loginPage.login("storemanager85","UserUser123");
        loginPage.waitUntilLoaderMaskDisappear();

        loginPage.navigateTo("Activities","Calendar Events");
        loginPage.waitUntilLoaderMaskDisappear();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.clickToCreateCalendarEvent();
        loginPage.waitUntilLoaderMaskDisappear();

        Driver.get().findElement(By.cssSelector("[data-name='recurrence-repeat']")).click();
        BrowserUtils.wait(2);
        Driver.get().findElement(By.xpath("//span[text()='After']")).click();
        Driver.get().findElement(By.xpath("//input[@data-related-field='occurrences']")).sendKeys("10");
        Driver.get().findElement(By.xpath("//span[text()='occurrences']")).click();
        BrowserUtils.wait(2);

        String actualMessage = Driver.get().findElement(By.xpath("//div[@data-name='recurrence-summary']")).getText();
        String expectedMessage = "Daily every 1 day, end after 10 occurrences";
        Assert.assertEquals(actualMessage,expectedMessage,"Test failed");

    }

    @Test(description = "Verify that following message as a summary is displayed: “Summary: Daily every 1 day," +
            "end by Nov 18, 2021”")
    public void test11(){

        LoginPage loginPage = new LoginPage();
        loginPage.login("storemanager85","UserUser123");
        loginPage.waitUntilLoaderMaskDisappear();

        loginPage.navigateTo("Activities","Calendar Events");
        loginPage.waitUntilLoaderMaskDisappear();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.clickToCreateCalendarEvent();
        loginPage.waitUntilLoaderMaskDisappear();

        Driver.get().findElement(By.cssSelector("[data-name='recurrence-repeat']")).click();
        Driver.get().findElement(By.xpath("//span[text()='By']")).click();
        Driver.get().findElement(By.xpath("//input[@placeholder='Choose a date' and @autocomplete='off']")).sendKeys("Nov 18, 2021");

        String actualMessage = Driver.get().findElement(By.xpath("//div[@data-name='recurrence-summary']")).getText();
        String expectedMessage = "Daily every 1 day, end by Nov 18, 2021";
        Assert.assertEquals(actualMessage,expectedMessage,"Test failed");
        BrowserUtils.wait(5);
    }

    @Test
    public void test12(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("storemanager85","UserUser123");
        loginPage.waitUntilLoaderMaskDisappear();

        loginPage.navigateTo("Activities","Calendar Events");
        loginPage.waitUntilLoaderMaskDisappear();

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.clickToCreateCalendarEvent();
        loginPage.waitUntilLoaderMaskDisappear();

        Driver.get().findElement(By.xpath("//input[@data-name='recurrence-repeat']")).click();
        Driver.get().findElement(By.xpath("//select[@data-name='recurrence-repeats\']")).click();
        Driver.get().findElement(By.xpath("//option[text()='Weekly']")).click();
        Driver.get().findElement(By.xpath("//input[@value='monday']")).click();
        Driver.get().findElement(By.xpath("//input[@value='friday']")).click();
        BrowserUtils.wait(5);

        Assert.assertTrue(Driver.get().findElement(By.xpath("//input[@value='monday']")).isSelected());
        Assert.assertTrue(Driver.get().findElement(By.xpath("//input[@value='friday']")).isSelected());

        String expectedMessage = "Weekly every 1 week on Monday, Friday";
        String actualMessage = Driver.get().findElement(By.xpath("//span[text()='Weekly every 1 week on Monday, Friday']")).getText();
        Assert.assertEquals(actualMessage,expectedMessage);

    }

}
