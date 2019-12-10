package SeleniumHomeworks.Homeworks2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BrowserFactory;
import utils.BrowserUtils;

public class testCase1 {
    WebDriver driver;

    @BeforeMethod
    public void driverSetup(){
        driver= BrowserFactory.getDriver("chrome");
    }

    @Test(description = "Verify that 'The date of birth is not valid' is displayed")
    public void test1(){
      driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(3);
      driver.findElement(By.cssSelector("[href$=\"form\"]")).click();
      BrowserUtils.wait(3);
      driver.findElement(By.cssSelector("[name=\"birthday\"]")).sendKeys("wrong_dob");
      String expectedResult="The date of birth is not valid";
      String actualResult=driver.findElement(By.xpath("//small [contains(text(),'not valid')]")).getText();
        Assert.assertEquals(actualResult,expectedResult,"Test failed");
        System.out.println("Actual message is: "+actualResult);
    }

    @Test(description = "Verify that following options for programming languages are displayed: 'c++, java, JavaScript'")
    public void test2(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(3);
        driver.findElement(By.cssSelector("[href$=\"form\"]")).click();
        String actualResult1=driver.findElement(By.xpath("//label[text()='C++']")).getText();
        String actualResult2=driver.findElement(By.cssSelector("[for=\"inlineCheckbox2\"]")).getText();
        String actualResult3=driver.findElement(By.xpath("//label[text()='JavaScript']")).getText();
        Assert.assertEquals(actualResult1, "C++", "Test failed");
        Assert.assertEquals(actualResult2,"Java", "Test failed");
        Assert.assertEquals(actualResult3,"JavaScript","Test failed");
        }

    @Test(description = "Verify that warning message is displayed 'first name must be more than 2 and\n"  +
                             "less than 64 characters long'")
    public void test3(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(3);
        driver.findElement(By.cssSelector("[href$=\"form\"]")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.cssSelector("[name=\"firstname\"]")).sendKeys("a");
        String expectedResult="first name must be more than 2 and less than 64 characters long";
        System.out.println(expectedResult);
        String actualResult=driver.findElement(By.xpath("//small[contains(text(), 'first name m')]")).getText();
        Assert.assertEquals(actualResult,expectedResult,"Test failed");
    }

    @Test(description = "Verify that warning message is displayed: “The last name must be more than 2" +
                         " and less than 64 characters long”")
    public void test4(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(3);
        driver.findElement(By.cssSelector("[href$=\"form\"]")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.cssSelector("[name=\"lastname\"]")).sendKeys("a");
        BrowserUtils.wait(2);
        String expectedResult="The last name must be more than 2 and less than 64 characters long";
        String actualResult=driver.findElement(By.xpath("//small[contains(text(), 'last name must')]")).getText();
        Assert.assertEquals(actualResult,expectedResult,"Test failed");
    }

    @Test(description = "Verify that following success message is displayed: “You've successfully" +
                         "completed registration!”")
    public void test5(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(3);
        driver.findElement(By.cssSelector("[href$=\"form\"]")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("Aibek");
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("Cybertek");
        BrowserUtils.wait(1);
        driver.findElement(By.cssSelector("[name='username']")).sendKeys("Kaz");
        driver.findElement(By.cssSelector("[name=\"email\"]")).sendKeys("asdf@gmail.com");
        driver.findElement(By.cssSelector("[name='password']")).sendKeys("myPassword");
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[name=\'phone\']")).sendKeys("7475552487");
        driver.findElement(By.xpath("//input[@value='male']")).click();
        driver.findElement(By.cssSelector("[name=\"birthday\"]")).sendKeys("10/24/2019");
        WebElement drop = driver.findElement(By.cssSelector("[name=\"department\"]"));
        Select select=new Select(drop);
        select.selectByVisibleText("Department of Engineering");
        BrowserUtils.wait(2);
        WebElement drop1 = driver.findElement(By.cssSelector("[name=\"job_title\"]"));
        Select select1=new Select(drop1);
        select1.selectByVisibleText("SDET");
        BrowserUtils.wait(2);
        driver.findElement(By.id("inlineCheckbox2")).click();
        driver.findElement(By.id("wooden_spoon")).click();
    }

    @Test(description = "Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”")
    public void test6(){
        driver.get("https://www.tempmailaddress.com");
        BrowserUtils.wait(2);
        String email=driver.getCurrentUrl();
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.cssSelector("[name=\"full_name\"]")).sendKeys("Aibek");
        BrowserUtils.wait(1);
        driver.findElement(By.cssSelector("[name=\"email\"]")).sendKeys("repairman.austin@gmail.com");
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[name=\"wooden_spoon\"]")).click();
        BrowserUtils.wait(2);
        WebElement Message = driver.findElement(By.cssSelector("[name=signup_message]"));
        Assert.assertTrue(Message.isDisplayed(),"Sign Up Message is not displayed");
        driver.navigate().to("https://www.tempmailaddress.com");
        BrowserUtils.wait(2);
        driver.navigate().to("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
        BrowserUtils.wait(1);
        driver.findElement(By.cssSelector("[autocomplete=\"username\"]")).sendKeys("repairman.austin@gmail.com");
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[class=\'CwaK9\']")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.cssSelector("[type=\"password\"]")).sendKeys("Aminok2011");
        driver.findElement(By.xpath("//span[text()='Next']")).click();
        BrowserUtils.wait(4);
        driver.findElement(By.cssSelector("[placeholder=\"Search mail\"]")).sendKeys("do-not-reply@practice.cybertekschool.com");
        driver.findElement(By.cssSelector("[aria-label=\"Search Mail\"]")).click();
        BrowserUtils.wait(3);

        Assert.assertTrue(driver.findElement(By.cssSelector("[data-hovercard-owner-id=\"137\"]")).isDisplayed(),"email didn't received");

        driver.findElement(By.cssSelector("[data-hovercard-owner-id=\"137\"]")).click();
        BrowserUtils.wait(2);
        String expectedEmail = "do-notreply@practice.cybertekschool.com";
        String actualEmail = driver.findElement(By.cssSelector("[data-hovercard-owner-id=\"137\"]")).getText();
        Assert.assertEquals(actualEmail, expectedEmail, "Test failed");
        BrowserUtils.wait(2);
        String expectedSubject = "Thanks for subscribing to practice.cybertekschool.com!";
        String actualSubject = driver.findElement(By.id("[id=\":5f\"]")).getText();
        Assert.assertEquals(actualSubject,expectedSubject, "Test failed");
        BrowserUtils.wait(2);
    }

    @Test
    public void test7(){
        WebDriverWait wait=new WebDriverWait(driver,10);
        driver.get("http://practice.cybertekschool.com");
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Aibek\\Desktop\\case.txt");
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(4);
        System.out.println(driver.getTitle());
    }

    @Test
    public void test8() {
        WebDriverWait wait = new WebDriverWait(driver,10);
    driver.get("http://practice.cybertekschool.com/");
    driver.findElement(By.linkText("Autocomplete")).click();
    driver.findElement(By.id("myCountry")).sendKeys("United States of America");
    driver.findElement(By.cssSelector("[type=\"button\"]")).click();
    String expectedMessage="You selected: United States of America";
    String actualMessage=driver.findElement(By.xpath("//p[contains(text(), 'You selected:')]")).getText();
    Assert.assertEquals(actualMessage,expectedMessage,"Test failed");
        System.out.println(actualMessage);

    }

    @DataProvider(name="Data")
    public static Object[]Data(){
        return new Object[]{"200", "301", "404", "500"};
    }

    @Test(dataProvider = "Data")
    public void test9(String code){
    driver.get("http://practice.cybertekschool.com");
    driver.findElement(By.linkText("Status Codes")).click();
    driver.findElement(By.linkText(code)).click();
    String expectedResult="This page returned a "+code+" status code";
    int size=expectedResult.length();
    String actualResult=driver.findElement(By.xpath("//p[contains(text(),'This page')]")).getText().trim().substring(0,size);
        Assert.assertEquals(actualResult,expectedResult,"Test failed");
        System.out.println(actualResult);
    }



    @AfterMethod
    public void driverClose(){
       driver.quit();
    }

}
