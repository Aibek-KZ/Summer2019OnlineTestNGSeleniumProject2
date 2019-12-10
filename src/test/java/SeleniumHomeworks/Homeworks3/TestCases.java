package SeleniumHomeworks.Homeworks3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCases {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = BrowserFactory.getDriver("chrome");
        wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        WebElement activitiesElement = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activitiesElement));
        wait.until(ExpectedConditions.elementToBeClickable(activitiesElement));
        BrowserUtils.wait(2);
        activitiesElement.click();
        WebElement calendarEventsElement = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(calendarEventsElement));
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsElement));
        calendarEventsElement.click();
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }
    @Test(description = "Verify that page subtitle \"Options\" is displayed")
    public void test1(){
        String ExpectedMessage="Options";
        String ActualMessage=driver.findElement(By.xpath("//div[contains(text(), 'Options')]")).getText();
        Assert.assertEquals(ActualMessage, ExpectedMessage,"Test failed");
        System.out.println(ActualMessage);
    }
    @Test(description = "Verify that page number is equals to 1")
    public void test2(){
        WebElement element=driver.findElement(By.cssSelector("[type=\"number\"]"));
        String actualValue=element.getAttribute("value");
        String expectedValue="1";
        Assert.assertEquals(actualValue, expectedValue,"Test failed");
        System.out.println(actualValue);
    }
    @Test(description = "Verify that view per page number is equals to 25")
    public void test3(){
        String actualResult = driver.findElement(By.xpath("//button[contains(text(), '25')]")).getText();
        System.out.println(actualResult);
        String expectedResult = "25";
        Assert.assertEquals(actualResult, expectedResult, "test failed");
    }
    @Test(description = "Verify that number of calendar events (rows in the table) is equals to number of records")
    public void test4(){
        List<WebElement> ElementRows = driver.findElements(By.xpath("//tbody/tr"));
        String ElementsTotal = driver.findElement(By.xpath("//label[contains(text(),'Total of')]")).getText();
        String Rows=""+ElementRows.size();
        Assert.assertTrue(ElementsTotal.contains(Rows));
        System.out.println(Rows);
        System.out.println(ElementsTotal);

    }
    @Test(description = "Verify that all calendar events were selected")
    public void test5(){
        driver.findElement(By.xpath("//div[@class='btn-group dropdown']/button/input")).click();
        List<WebElement> checkboxes=driver.findElements(By.cssSelector("[data-role=\"select-row-cell\"]"));
        for (WebElement each : checkboxes){
            Assert.assertTrue(each.isSelected(),"Checkbox number "+each+" is not selected");
        }
    }
    @Test
    public void test6(){
        driver.findElement(By.xpath("//table//tbody//tr[14]")).click();
        List<WebElement> DisplayedTitle=driver.findElements(By.xpath("//label[@class='control-label']"));
        for (WebElement each : DisplayedTitle){
            Assert.assertTrue(each.isDisplayed(),"Title is diplayed");
            System.out.println(each.getText());
        }
        List<WebElement> DisplayedMessages=driver.findElements(By.xpath("//div[@class=\"control-label\"]"));
        for (WebElement each : DisplayedMessages){
            Assert.assertTrue(each.isDisplayed(),"Message doesn't display");
            System.out.println(each.getText());
        }
        BrowserUtils.wait(2);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
